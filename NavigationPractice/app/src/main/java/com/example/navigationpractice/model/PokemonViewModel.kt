package com.example.navigationpractice.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationpractice.network.repository.PokemonApiCallRepository
import com.example.navigationpractice.util.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonViewModel(private val repository: PokemonApiCallRepository):ViewModel() {
    private var _pokemonData:MutableLiveData<List<Results>> = MutableLiveData()
    val pokemonData:LiveData<List<Results>> = _pokemonData


    fun loadPokemonFromApi(limit:Int, offSet:Int){

        viewModelScope.launch(Dispatchers.IO){
            val response = repository.getPokemon(limit,offSet)
            if (response.isSuccessful){
                val responseBody = response.body()
                withContext(Dispatchers.Main){
                    _pokemonData.value = responseBody?.results
                }
            }else{
                _pokemonData.value = null
            }

        }
    }
}