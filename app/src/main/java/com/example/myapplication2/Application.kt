package com.example.myapplication2

import android.app.Application

class myApplication : Application() {
    val Database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { UserRepository(Database.userDAO()) }

}
