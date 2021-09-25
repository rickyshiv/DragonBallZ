package com.example.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class switchActivity : AppCompatActivity() {
    lateinit var goku: Button

    lateinit var cell2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch)
        goku = findViewById(R.id.goku)
        cell2 = findViewById(R.id.cell2)

        goku.setOnClickListener {
            val intent1 = Intent(this@switchActivity, AvengersActivity::class.java)
            startActivity(intent1)
        }



        cell2.setOnClickListener {
            val intent = Intent(this@switchActivity, Villans::class.java)
            startActivity(intent)
        }
    }
}