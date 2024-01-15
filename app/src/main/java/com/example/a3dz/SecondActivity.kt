package com.example.a3dz
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val receivedText: TextView = findViewById(R.id.receivedText)

        val receivedIntent = intent
        if (receivedIntent != null && receivedIntent.hasExtra("textData")) {
            val receivedTextData = receivedIntent.getStringExtra("textData")
            if (receivedTextData != null) {
                receivedText.text = "Received Text: $receivedTextData"
            } else {
                // Обработка ситуации, когда receivedTextData равен null
            }
        } else {
            // Обработка ситуации, когда Intent не содержит нужные данные
        }
    }
}


