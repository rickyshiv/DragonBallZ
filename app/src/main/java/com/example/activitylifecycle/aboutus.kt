package com.example.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class aboutus : AppCompatActivity() {
    lateinit var home: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutus)
        home = findViewById(R.id.homep)
        home.setOnClickListener {
            val intent = Intent(this@aboutus,dash::class.java)
            val message = home.text.toString()
            intent.putExtra("Message", message)
            startActivity(intent)
        }
    }
}