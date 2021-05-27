package com.petruciostech.codenfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Cadastar_Activity : AppCompatActivity() {
    private lateinit var txtNome:EditText
    private lateinit var txtEmail:EditText
    private lateinit var txtSenha:EditText
    private lateinit var txtSenha_Confirmar:EditText
    private lateinit var btnCadastrar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastar)

        txtNome = findViewById(R.id.et_nome)
        txtEmail = findViewById(R.id.et_email_cadastrar)
        txtSenha = findViewById(R.id.et_senha_cadastrar)
        txtSenha_Confirmar = findViewById(R.id.et_confirmar_senha)
        btnCadastrar = findViewById(R.id.btn_cadastrar)

        btnCadastrar.setOnClickListener {
            cadastrar()
        }
    }

    fun cadastrar(){
        if(txtSenha.text.toString() == txtSenha_Confirmar.text.toString()){
            val novoCadastro = Cadastro(
                nome = txtNome.text.toString(),
                email = txtEmail.text.toString(),
                senha = txtSenha.text.toString()
            )
            val intente = Intent(this, LoginActivity::class.java)
            intente.putExtra("cadastro", novoCadastro)
            startActivity(intente)
        }else{
            Toast.makeText(this, "Senhas diferentes", Toast.LENGTH_SHORT).show()
        }
    }
}