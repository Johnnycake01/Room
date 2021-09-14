package com.example.databasepractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.databasepractice.R
import com.example.databasepractice.databinding.ActivityRoomDatabaseBinding

class RoomDatabaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomDatabaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
       setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp()||super.onSupportNavigateUp()
    }
}