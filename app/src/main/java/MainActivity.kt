package com.example.movie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var errorMessageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signInButton = findViewById<Button>(R.id.buttonSignIn)
        signInButton.setOnClickListener {
            handleSignInButtonClick()
        }

        val signUpButton = findViewById<Button>(R.id.buttonSignUp)
        signUpButton.setOnClickListener {
            handleSignUpButtonClick()
        }

        errorMessageTextView = findViewById(R.id.textViewErrorMessage)
    }

    private fun handleSignInButtonClick() {
        val emailInput = findViewById<EditText>(R.id.editTextEmail)
        val passwordInput = findViewById<EditText>(R.id.editTextPassword)

        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()

        // TODO: Add sign-in logic here
        // Validate email and password (e.g., check if they are not empty)

        if (password == "correctpassword") {
            // Correct password, proceed to next activity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // Incorrect password, display error message
            errorMessageTextView.text = "Wrong password. Please try again."
            Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleSignUpButtonClick() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}
