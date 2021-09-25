package com.example.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class devlp : AppCompatActivity() {



    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devlp)
        back = findViewById(R.id.back)
        back.setOnClickListener {
            val intent = Intent(this@devlp,dash::class.java)
            val message = back.text.toString()
            intent.putExtra("Message", message)
            startActivity(intent)
        }
    }
}