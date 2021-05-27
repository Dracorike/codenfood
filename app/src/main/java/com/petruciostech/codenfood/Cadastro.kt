package com.petruciostech.codenfood

import java.io.Serializable

data class Cadastro(
    var nome:String,
    var email:String,
    var senha:String
): Serializable