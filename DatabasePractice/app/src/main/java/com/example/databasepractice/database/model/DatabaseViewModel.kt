package com.example.databasepractice.database.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.databasepractice.database.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DatabaseViewModel(application: Application):AndroidViewModel(application) {
    private val userDao = UserDatabase.getDatabase(application).userDao()

    private val repository:UserRepository = UserRepository(userDao)
    val readAllData:LiveData<List<User>> = repository.readAllData


    fun addUser(user:User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)

        }
    }
    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)

        }
    }
    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllUser()
        }
    }
    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }
}