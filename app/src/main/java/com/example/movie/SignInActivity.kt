package com.example.movie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var signInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInButton = findViewById(R.id.buttonSignIn)
        signInButton.setOnClickListener {
            handleSignInButtonClick()
        }
    }

    private fun handleSignInButtonClick() {
        // Perform sign-in logic here
        // Check if the user exists and the provided credentials are valid

        // Assuming the sign-in is successful
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
