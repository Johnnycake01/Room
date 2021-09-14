package com.example.navigationpractice.util

const val BASE_URL = "https://pokeapi.co/api/v2/"
const val TAG = "mainActivity"

fun getNumber(url: String):Int{
    val splitNumber = url.split("/")
    return splitNumber[splitNumber.lastIndex-1].toInt()
}