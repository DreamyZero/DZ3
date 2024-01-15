package com.example.a3dz

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextText: EditText
    private lateinit var editTextNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextText = findViewById(R.id.editTextText)
        editTextNumber = findViewById(R.id.editTextNumber)

        val buttonSendText: Button = findViewById(R.id.buttonSendText)
        val buttonDialNumber: Button = findViewById(R.id.buttonDialNumber)

        buttonSendText.setOnClickListener {
            startSecondActivity()
        }

        buttonDialNumber.setOnClickListener {
            dialPhoneNumber()
        }

        println("MainActivity onCreate")
    }

    private fun startSecondActivity() {
        val textToPass = editTextText.text.toString()
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("textData", textToPass)
        }
        startActivity(intent)
    }

    private fun dialPhoneNumber() {
        val phoneNumber = editTextNumber.text.toString()
        if (phoneNumber.isNotEmpty() && phoneNumber.matches(Regex("\\d+"))) {
            val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(dialIntent)
        } else {
            // Handle invalid phone number input
        }
    }
}

