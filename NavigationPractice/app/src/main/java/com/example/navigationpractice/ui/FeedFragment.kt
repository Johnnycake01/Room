package com.example.navigationpractice.ui


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.navigationpractice.R
import com.example.navigationpractice.databinding.FragmentFeedBinding
import com.example.navigationpractice.model.PokemonViewModel
import com.example.navigationpractice.model.PokemonViewModelFactory
import com.example.navigationpractice.network.repository.PokemonApiCallRepository
import com.example.navigationpractice.ui.adapter.PokemonAdapter
import com.example.navigationpractice.util.TAG
import com.google.android.material.snackbar.Snackbar


class FeedFragment : Fragment(R.layout.fragment_feed) {
    private lateinit var binding: FragmentFeedBinding
    private lateinit var rvAdapter:PokemonAdapter
    private lateinit var viewModelInstance:PokemonViewModel
    private lateinit var viewmodelFactory: PokemonViewModelFactory
    private lateinit var repository: PokemonApiCallRepository
    

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFeedBinding.bind(view)
        repository = PokemonApiCallRepository()
        viewmodelFactory = PokemonViewModelFactory(repository)
        viewModelInstance = ViewModelProvider(this,viewmodelFactory)
            .get(PokemonViewModel::class.java)
        Log.d(TAG, "onViewCreated: sssssssssss")

        rvAdapter = PokemonAdapter(requireActivity())
        binding.pokemonRecyclerView.adapter = rvAdapter

       viewModelInstance.loadPokemonFromApi(10,0)

        binding.pokemonRecyclerView.layoutManager = GridLayoutManager(requireActivity(),2)

        viewModelInstance.pokemonData.observe(viewLifecycleOwner,{
            if (it != null){

                val listOfPokemon = it
                rvAdapter.addNewPokemon(listOfPokemon)

            }else{
                Log.d(TAG, "onViewCreated: null null null")
            }

        })

    }

}