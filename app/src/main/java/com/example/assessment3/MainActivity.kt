package com.example.assessment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assessment3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        binding.btnLogIn.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogIn.setOnClickListener {
           validateInputs()
       }

    }
     fun validateInputs(){
        var valid = true
         val userName = binding.etUserName.text.toString()
         val phoneNUmber = binding.etPhoneNumber.text.toString()
         val email = binding.etEmail.text.toString()
         val password = binding.etPassword.text.toString()




        if (userName.isBlank()) {
            valid = false
            binding.etUserName.error = "Username is required"
        }

        if (phoneNUmber.isBlank()) {
            valid = false
            binding.etPhoneNumber.error = "Phone number is required"
        }

        if (email.isBlank()) {
            valid = false
            binding.etEmail.error = "Email address is required"
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text).matches()) {
            valid = false
            binding.etEmail.error = "Invalid email address format"
        }

        if (password.isBlank()) {
            valid = false
            binding.etPassword.error = "Password is required"
        }

        return validateInputs()
    }

}







