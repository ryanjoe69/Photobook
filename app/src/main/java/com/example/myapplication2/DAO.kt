package com.example.myapplication2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


    @Dao
    interface UserDAO {
        @Insert
        suspend fun insert (user: UserClass)

        @Update
        suspend fun update(user: UserClass)

        @Delete
        suspend fun delete(user: UserClass)

        @Query("SELECT * FROM User WHERE  Firstname= :Firstname AND Lastname= :Lastname AND password =:password LIMIT 1")
        suspend fun getuser (Firstname: String, Lastname: String, password: String): UserClass?
    }
