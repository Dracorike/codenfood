package com.petruciostech.codenfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var listaReceitas:RecyclerView
    private val lista = arrayListOf<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initToolBar()
        initReceitas()
        setRecyclerView()
    }

    private fun initToolBar(){
        var toolbar = findViewById<Toolbar>(R.id.tb_Barra)
        setSupportActionBar(toolbar)
    }

    private fun setRecyclerView(){
        listaReceitas = findViewById(R.id.rv_ListaComida)
        val adapter = AdapterRecyclerView(lista)
        listaReceitas.layoutManager = LinearLayoutManager(this)
        listaReceitas.adapter = adapter
    }

    private fun initReceitas(){
        lista.add(Food("Pudim", "Pudim molhadinho muito gostoso", R.mipmap.ic_pudim,
            Receitas().receita_Pudim))

        lista.add(Food("Pastel de  Frango", "Pastel crocante que dá água na boca",
            R.mipmap.ic_pastel, Receitas().receita_Pastel))

        lista.add(Food("Mousse de Chocolate", "Mousse geladinho e apetitoso",
            R.mipmap.ic_moussechocolate, Receitas().receita_MousseDeChocolate))

        lista.add(Food("Bolo de Chocolate", "Bolo delicioso com massa de chocolate",
            R.mipmap.ic_bolodechocolate, Receitas().receita_BoloDeChocolate))

        lista.add(Food("Bolinha de Queijo", "Bolinhas recheadas de queijo",
            R.mipmap.ic_bolinhadequeijo, Receitas().receita_BolinhaDeQueijo))
    }
}