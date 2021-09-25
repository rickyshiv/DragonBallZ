package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Cell : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cell)
        title="Villans->Cell"
    }
}