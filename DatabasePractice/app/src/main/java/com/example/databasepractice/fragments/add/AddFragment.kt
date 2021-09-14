package com.example.databasepractice.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.databasepractice.R
import com.example.databasepractice.database.model.DatabaseViewModel
import com.example.databasepractice.database.model.User
import com.example.databasepractice.databinding.FragmentAddBinding


class AddFragment : Fragment(R.layout.fragment_add) {
    private lateinit var binding: FragmentAddBinding
    private lateinit var androidViewModel: DatabaseViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddBinding.bind(view)
        androidViewModel = ViewModelProvider(this).get(DatabaseViewModel::class.java)

        binding.btAdd.setOnClickListener {
            insertDataToDataBase()
        }
    }

    private fun insertDataToDataBase() {
       val firstName = binding.edFullNAme.text.toString()
        val lastName = binding.edLastName.text.toString()
        val age = binding.edAge.text
        if (checkIfFieldNotEmpty(firstName,lastName,age)){
            //create object
            val user = User(0,firstName,lastName,age.toString().toInt())
            //add to database
            androidViewModel.addUser(user)
            Toast.makeText(requireContext(),"successfully added to db", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }else{
            Toast.makeText(requireContext(),
                "please fill out all filled", Toast.LENGTH_SHORT).show()
        }
    }
    private fun checkIfFieldNotEmpty(firstName:String,lastName:String,age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())

    }
}