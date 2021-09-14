package com.example.databasepractice.database.model

import androidx.lifecycle.LiveData
import com.example.databasepractice.database.UserDao

class UserRepository (private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

   suspend fun addUser(user: User){
       userDao.addUser(user)
   }
    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
    suspend fun deleteAllUser(){
        userDao.deleteAll()
    }
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

}