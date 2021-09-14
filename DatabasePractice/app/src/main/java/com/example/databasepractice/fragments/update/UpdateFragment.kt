package com.example.databasepractice.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.databasepractice.R
import com.example.databasepractice.database.model.DatabaseViewModel
import com.example.databasepractice.database.model.User
import com.example.databasepractice.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment(R.layout.fragment_update) {
    private lateinit var binding: FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var androidViewModel: DatabaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUpdateBinding.bind(view)
        androidViewModel = ViewModelProvider(this).get(DatabaseViewModel::class.java)
        setHasOptionsMenu(true)

        binding.edUpdateFullNAme.setText(args.userData.firstName)
        binding.edUpdateLastName.setText(args.userData.lastName)
        binding.edUpdateAge.setText(args.userData.age.toString())
        binding.btUpdate.setOnClickListener {
            updateDataToDataBase()
        }
    }
    private fun updateDataToDataBase() {
        val firstName = binding.edUpdateFullNAme.text.toString()
        val lastName = binding.edUpdateLastName.text.toString()
        val age = binding.edUpdateAge.text
        if (checkIfFieldNotEmpty(firstName,lastName,age)){
            //create object
            val user = User(args.userData.id,firstName,lastName,age.toString().toInt())
            //update to database
            androidViewModel.updateUser(user)
            Toast.makeText(requireContext(),
                "successfully updated to db", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }else{
            Toast.makeText(requireContext(),
                "please fill out all filled", Toast.LENGTH_SHORT).show()
        }
    }
    private fun checkIfFieldNotEmpty(firstName:String,lastName:String,age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
            inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete_menu) deleteItem()
        return super.onOptionsItemSelected(item)
    }

    private fun deleteItem() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            androidViewModel.deleteUser(args.userData)
            Toast.makeText(requireContext(),
                "successfully deleted ${args.userData.firstName}", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No"){_,_ ->

        }
        builder.setTitle("Delete ${args.userData.firstName}?")
        builder.setMessage("are you sure you want to delete ${args.userData.firstName}?")
        builder.create().show()
    }
}