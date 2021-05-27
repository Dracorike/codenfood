package com.petruciostech.codenfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FoodDetailActivity : AppCompatActivity() {
    private lateinit var imgDetail:ImageView
    private lateinit var txtTitleDetail:TextView
    private lateinit var txtDescDetail:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        imgDetail = findViewById(R.id.img_imageFoodDetail)
        txtTitleDetail = findViewById(R.id.tv_TitleDetail)
        txtDescDetail = findViewById(R.id.tv_receita)

        val details = intent
        val foodDetail = details.getSerializableExtra("foodSelecionada") as Food

        imgDetail.setImageResource(foodDetail.image)
        txtTitleDetail.text = foodDetail.titulo
        txtDescDetail.text = foodDetail.receita
    }
}