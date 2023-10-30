package com.novlesh.exp72

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayDetailsActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_details)

        val textViewDetails = findViewById<TextView>(R.id.textViewDetails)

        // Retrieve data passed from SignUpActivity
        val name = intent.getStringExtra("name")
        val regNumber = intent.getStringExtra("regNumber")
        val email = intent.getStringExtra("email")
        val contact = intent.getStringExtra("contact")
        val subject = intent.getStringExtra("subject")

        // Display the details
        textViewDetails.text = "Name: $name\n" +
                "Registration Number: $regNumber\n" +
                "Email: $email\n" +
                "Contact: $contact\n" +
                "Subject: $subject"
    }
}

