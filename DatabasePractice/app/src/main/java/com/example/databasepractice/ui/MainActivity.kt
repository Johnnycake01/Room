package com.example.databasepractice.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.databasepractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference = getSharedPreferences("mySharePreference", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()

        binding.btSave.setOnClickListener {
            val name = binding.edName.text.toString()
            val age = binding.edAge.text.toString().toInt()
            val isAdult = binding.chkAdult.isChecked

            editor.apply {
                putString("name", name)
                putInt("age",age)
                putBoolean("isAdult", isAdult)
                apply()
            }
        }

        binding.btLoad.setOnClickListener {
            val name = sharedPreference.getString("name", null)
            val age = sharedPreference.getInt("age",0)
            val isAdult = sharedPreference.getBoolean("isAdult",false)

            binding.edName.setText(name)
            binding.edAge.setText(age.toString())
            binding.chkAdult.isChecked = isAdult
        }
        binding.btNext.setOnClickListener {
            val intent = Intent(this,RoomDatabaseActivity::class.java)
            startActivity(intent)
        }
    }
}