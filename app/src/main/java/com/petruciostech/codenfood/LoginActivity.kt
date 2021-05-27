package com.petruciostech.codenfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var btnCadastrar:Button
    private var lista = arrayListOf<Cadastro>()
    private lateinit var txtEmail:EditText
    private lateinit var txtSenha:EditText
    private lateinit var lblCadastrar:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnCadastrar = findViewById(R.id.btn_login)
        txtEmail = findViewById(R.id.et_email)
        txtSenha = findViewById(R.id.et_senha)
        lblCadastrar = findViewById(R.id.tv_cadastrarse)

        val intent = intent
        if (intent.hasExtra("cadastro")){
            val cadastro = intent.getSerializableExtra("cadastro")
            lista.add(cadastro as Cadastro)
        }
        btnCadastrar.setOnClickListener{
            if (autetication()){
                logar()
            }else{
                Toast.makeText(this, "Deu errado", Toast.LENGTH_SHORT).show()
            }
        }

        lblCadastrar.setOnClickListener {
            val intent = Intent(this, Cadastar_Activity::class.java)
            startActivity(intent)
        }



    }

    private fun autetication(): Boolean{
        var retorno = false
        lista.forEach {
            if(txtEmail.text.toString() == it.email && txtSenha.text.toString() == it.senha){
                retorno = true
            }
        }
        return retorno
    }

    fun logar(){
        var intente = Intent(this, MainActivity::class.java)
        startActivity(intente)
        this.finish()
    }
}