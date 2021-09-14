package com.example.databasepractice.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.databasepractice.database.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM User_Table ORDER BY id ASC")
    fun readAllData():LiveData<List<User>>

    @Update
    suspend fun updateUser(user: User)

    @Query("DELETE FROM User_Table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteUser(user: User)
}