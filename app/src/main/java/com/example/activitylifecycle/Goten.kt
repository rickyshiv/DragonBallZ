package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Goten : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goten)
        title="DBZ"
        setTitle(title)
    }
}