package com.example.navigationpractice.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.navigationpractice.R
import com.example.navigationpractice.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    private lateinit var binding:FragmentRegistrationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistrationBinding.bind(view)

    }
}