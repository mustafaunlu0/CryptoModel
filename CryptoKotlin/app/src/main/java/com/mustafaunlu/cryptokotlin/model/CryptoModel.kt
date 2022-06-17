package com.mustafaunlu.cryptokotlin.model

import com.google.gson.annotations.SerializedName

data class CryptoModel(
    //@SerializedName("currency")
    val currency : String,

    //@SerializedName("price")  ---> bunu javada yapardık veri gelicek eşitle demek lakin kotlinde buna gerek yok oto gelir
     val price : String
     )