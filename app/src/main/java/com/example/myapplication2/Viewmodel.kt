package com.example.myapplication2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel (private val repository: UserRepository) : ViewModel(){
     fun insert(user: UserClass) = viewModelScope.launch {
        repository.insert(user) }
    fun update(user: UserClass) = viewModelScope.launch {
        repository.update(user)
    }
    fun delete(user: UserClass) = viewModelScope.launch {
        repository.delete(user)
    }
    fun getuser (Firstname: String, Lastname: String, password: String, callback: (UserClass?) -> Unit) = viewModelScope.launch {
        val UserClass = repository.getuser(Firstname, Lastname, password)
        callback(UserClass)
    }





}


