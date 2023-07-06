package com.example.movie

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var signUpButton: Button
    private lateinit var passwordMismatchTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize views
        emailEditText = findViewById(R.id.editTextEmail)
        passwordEditText = findViewById(R.id.editTextPassword)
        confirmPasswordEditText = findViewById(R.id.editTextConfirmPassword)
        signUpButton = findViewById(R.id.buttonSignUp)
        passwordMismatchTextView = findViewById(R.id.passwordMismatchTextView)

        // Set click listener for sign-up button
        signUpButton.setOnClickListener {
            signUp()
        }
    }

    private fun signUp() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()

        if (password == confirmPassword) {
            // Perform your own sign-up logic here
            // For example, you can display a success message using Toast:
            Toast.makeText(this, "Sign up successful.", Toast.LENGTH_SHORT).show()
            // Redirect to the Home activity or perform any other desired actions
            // For example, you can start the Home activity using an Intent:
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Optional: finish the Sign Up activity to prevent going back
        } else {
            // Passwords don't match, display error message
            passwordMismatchTextView.visibility = View.VISIBLE
        }
    }
}
