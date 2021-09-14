package com.example.navigationpractice.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.navigationpractice.R
import com.example.navigationpractice.databinding.FragmentListOfPokemonBinding


class ListOfPokemonFragment : Fragment(R.layout.fragment_list_of_pokemon) {
private lateinit var binding:FragmentListOfPokemonBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentListOfPokemonBinding.bind(view)

        val navHostFragment = childFragmentManager.findFragmentById(
            R.id.listFragment
        ) as NavHostFragment

        binding.bottomNavBar.setupWithNavController(navController = navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener{ _, destination,_ ->
            binding.toolbar.title = destination.label
        }
    }
}