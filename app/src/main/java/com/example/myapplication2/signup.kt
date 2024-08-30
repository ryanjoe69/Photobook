package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.RoomDatabase
import com.example.myapplication2.databinding.ActivitySignupBinding

class signup : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var appDatabase: AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        setContentView(binding.root)

        setContentView(R.layout.activity_signup)
        appDatabase= AppDatabase.getDatabase(this)

        binding.signup1.setOnClickListener {
            val Firstname=binding.signupFirstname.text.toString()
            val Lastname=binding.signupLastname.text.toString()
            val password=binding.signuppassword.text.toString()
            signupDatabase(Firstname,Lastname,password, id =0)

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun signupDatabase(firstname:String,lastname:String,password:String,id:Int){
        val insertedRowId=AppDatabase .insert(firstname, lastname ,password,id)
        if(insertedRowId != -1L){
            Toast.makeText(this,"Signup Successful", Toast.LENGTH_SHORT).show()
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this,"Try again", Toast.LENGTH_SHORT).show()
        }
    }
}