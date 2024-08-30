package com.example.myapplication2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

public class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appdb: AppDatabase

    lateinit var firstName: EditText
    lateinit var lastName: EditText
    lateinit var password: EditText
    lateinit var signin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.signup.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
        binding.signin.setOnClickListener(View.OnClickListener {
            loginUser(this,"exampleFirstname",
                "exampleLastname",
                "examplepassword"
            ) { isAuthenticated ->
                if (isAuthenticated) {
                    Toast.makeText(this,"Login Successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,"Login unsuccessful", Toast.LENGTH_SHORT).show()
                }

                 }
            }
        )
    }
        fun loginUser (context: Context, firstname: String, lastname: String, password: String, callback: (Boolean) -> Unit) {
        // Get the database instance
        val db = AppDatabase.getDatabase(context)

        // Use a coroutine to perform the database operation
        GlobalScope.launch {
            // Fetch the user by username
            val user = db.userDAO()
                .getuser(Firstname = firstname, Lastname = lastname, password = password)

            // Check if the user exists and the password matches
            val isAuthenticated = user?.let { it.password == password } ?: false

            // Call the callback function with the result
            withContext(Dispatchers.Main) {
                callback(isAuthenticated)
            }
        }
    }
}

