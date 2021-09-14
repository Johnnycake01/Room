package com.example.navigationpractice.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.navigationpractice.R
import com.example.navigationpractice.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) { // pass in layout directly as fragment class constructor

    private lateinit var binding: FragmentLoginBinding //fragment Binding class

    // on fragment view created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)//bind view using view binding

        binding.tvRegister.setOnClickListener (
            Navigation.createNavigateOnClickListener(
                R.id.action_loginFragment_to_registrationFragment
            )
        )
        binding.btSubmit.setOnClickListener{
            if (binding.edEmail.text.isNotBlank() && binding.edPassword.text.isNotBlank()){
                findNavController().navigate(R.id.action_loginFragment_to_listOfPokemonFragment2)
            }
        }
    }

}

