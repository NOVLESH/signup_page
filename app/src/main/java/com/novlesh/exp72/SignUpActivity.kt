package com.novlesh.exp72

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btnSignUp = findViewById<Button>(R.id.buttonSignUp)

        btnSignUp.setOnClickListener {
            // Get user input
            val name = findViewById<EditText>(R.id.editTextName).text.toString()
            val regNumber = findViewById<EditText>(R.id.editTextRegNumber).text.toString()
            val email = findViewById<EditText>(R.id.editTextEmail).text.toString()
            val contact = findViewById<EditText>(R.id.editTextContact).text.toString()
            val subject = findViewById<EditText>(R.id.editTextSubject).text.toString()

            // Validate input
            if (validateInput(name, regNumber, email, contact, subject)) {
                // Input is valid, proceed to next activity
                val intent = Intent(this@SignUpActivity, DisplayDetailsActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("regNumber", regNumber)
                intent.putExtra("email", email)
                intent.putExtra("contact", contact)
                intent.putExtra("subject", subject)
                startActivity(intent)
            } else {
                Toast.makeText(this@SignUpActivity, "Invalid input. Please check your details.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInput(name: String, regNumber: String, email: String, contact: String, subject: String): Boolean {
        // Validate mobile number: It should have exactly 10 digits
        val isMobileValid = contact.length == 10 && contact.all { it.isDigit() }


        val isEmailValid = email.contains("@gmail.com")

        if (!isMobileValid) {
            showAlert("Invalid mobile number. Please enter a 10-digit mobile number.")
            return false
        }

        if (!isEmailValid) {
            showAlert("Invalid email address. Please enter a valid email address.")
            return false
        }

        // Check for other fields being empty
        if (name.isEmpty() || regNumber.isEmpty() || email.isEmpty() || subject.isEmpty()) {
            showAlert("All fields are required. Please enter the required information.")
            return false
        }

        // All validations passed
        return true
    }

    private fun showAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
        val dialog = builder.create()
        dialog.show()
    }

}
