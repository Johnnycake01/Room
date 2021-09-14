package com.example.navigationpractice.model


data class PokemonData(
    val results:List<Results>
)
data class Results(
    val name:String,
    val url:String
)