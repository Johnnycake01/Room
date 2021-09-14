package com.example.navigationpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigationpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //calling auto generated binding class
   private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //init binding to inflate layout inflater
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}