package com.example.navigationpractice.network

import com.example.navigationpractice.model.PokemonData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Action {
    @GET("pokemon")
    suspend fun getPokemon(@Query("limit") limit:Int, @Query("offset") offset:Int): Response<PokemonData>
}