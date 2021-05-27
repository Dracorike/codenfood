package com.petruciostech.codenfood

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class AdapterRecyclerView(val listaFood:List<Food>):
    RecyclerView.Adapter<itemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return itemViewHolder(view)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.bind(listaFood[position])

    }

    override fun getItemCount(): Int = listaFood.size

}

class itemViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
    private val txtTitle:TextView = itemView.findViewById(R.id.tv_Title)
    private val txtDesc:TextView = itemView.findViewById(R.id.tv_desc)
    private val imgSanduba:ImageView = itemView.findViewById(R.id.img_imageFood)

    fun bind(food: Food){
        txtTitle.text = food.titulo
        txtDesc.text = food.desc
        imgSanduba.setImageResource(food.image)

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, FoodDetailActivity::class.java)
            intent.putExtra("foodSelecionada", food)
            ContextCompat.startActivity(itemView.context, intent, null)
        }
    }

}