package com.bam.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.bam.firstproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginBtn.setOnClickListener {

            val emailText = binding.editTextEmailAddress.text.toString()
            val passText = binding.editTextPassword.text.toString()

            val repository = LoginUserRepository()
            repository.login(emailText, passText)

            if (repository.loginUser == null) {
                showToast("User not found")
            }
            else {
                showToast("user name is ${repository.loginUser!!.displayName}")
            }
        }

    }

    private fun showToast(text: String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }



}