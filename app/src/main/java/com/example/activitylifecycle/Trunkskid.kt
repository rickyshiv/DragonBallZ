package com.example.activitylifecycle


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class Trunkskid : AppCompatActivity() {

    lateinit var txtMessage: TextView
    var message = "Custom Message"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trunkskid)



    }
}
