package com.example.navigationpractice.network.repository

import com.example.navigationpractice.model.PokemonData
import com.example.navigationpractice.network.Retrofit
import retrofit2.Response
import retrofit2.http.Query

class PokemonApiCallRepository {


    suspend fun getPokemon(limit:Int,offset:Int): Response<PokemonData> {
        return Retrofit.retrofitBuilder().getPokemon(limit, offset)
    }

}