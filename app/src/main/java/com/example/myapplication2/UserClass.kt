package com.example.myapplication2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


    @Entity(tableName = "User")
    data class UserClass(
        @PrimaryKey(autoGenerate = true)

        @ColumnInfo(name = "id")
        val id: Int?,

        @ColumnInfo(name = "Firstname")
        var firstName: String,

        @ColumnInfo(name = "Lastname")
        var lastName: String,

        @ColumnInfo(name = "Password")
        var password: String,


        )