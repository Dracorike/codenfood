package com.petruciostech.codenfood

import java.io.Serializable


data class Food(
    val titulo:String,
    val desc:String,
    val image:Int,
    val receita:String
): Serializable