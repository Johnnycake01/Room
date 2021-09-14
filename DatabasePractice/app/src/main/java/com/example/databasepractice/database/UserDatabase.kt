package com.example.databasepractice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.databasepractice.database.model.User

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class UserDatabase:RoomDatabase() {
    abstract  fun userDao():UserDao

    companion object{
        @Volatile
        private var InstanceOfDatabase:UserDatabase? = null

        fun getDatabase(context: Context):UserDatabase{
            val tempIntance = InstanceOfDatabase
            if (tempIntance != null){
                return tempIntance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                InstanceOfDatabase = instance
                return instance
            }
        }
    }
}