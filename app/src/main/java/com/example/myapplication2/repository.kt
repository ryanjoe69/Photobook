package com.example.myapplication2

import com.google.firebase.firestore.auth.User

class UserRepository (private val userDAO: UserDAO) {
    suspend fun insert(user: UserClass) = userDAO.insert(user)
    suspend fun update(user: UserClass) = userDAO.update(user)
    suspend fun delete(user: UserClass) = userDAO.delete(user)
    suspend fun getuser(Firstname: String, Lastname: String, password: String) =
        userDAO.getuser(Firstname, Lastname, password)
}

