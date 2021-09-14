package com.example.databasepractice.fragments.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databasepractice.R
import com.example.databasepractice.database.model.DatabaseViewModel
import com.example.databasepractice.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var binding: FragmentListBinding
    private lateinit var instanceOfViewModel: DatabaseViewModel
    private lateinit var rvAdapter: ListFragmentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        setHasOptionsMenu(true)
        instanceOfViewModel = ViewModelProvider(this).get(DatabaseViewModel::class.java)

        rvAdapter = ListFragmentAdapter()
        binding.rvRecyclerView.adapter = rvAdapter
        binding.rvRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        instanceOfViewModel.readAllData.observe(viewLifecycleOwner, Observer{
            rvAdapter.addToList(it)
        })
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
            instanceOfViewModel.deleteAllUsers()
            Toast.makeText(requireContext(),
                "successfully deleted all users", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No"){_,_ ->

        }
        builder.setTitle("Delete All ?")
        builder.setMessage("are you sure you want to delete all Users ?")
        builder.create().show()
    }
}