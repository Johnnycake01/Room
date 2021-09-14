package com.example.navigationpractice.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.navigationpractice.network.repository.PokemonApiCallRepository

class PokemonViewModelFactory(private val repository: PokemonApiCallRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PokemonViewModel(repository) as T
    }
}