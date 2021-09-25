package com.example.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import android.widget.Toast



class NewActivity : AppCompatActivity() {


    lateinit var mobilenumber: EditText
    lateinit var pass: EditText
    lateinit var btn: Button
    lateinit var forgot: TextView
    lateinit var register: TextView
    var validmobilenumber = "0123456789"
    var nameOfAvenger = "Avenger"

    //var validPassword="thanos"
    val validPassword = arrayOf("tony", "steve", "bruce", "thanos")
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        setContentView(R.layout.activity_new)
        if (isLoggedIn) {
            val intent = Intent(this@NewActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        title = "LogIn"

        mobilenumber = findViewById(R.id.mobilenumber)
        pass = findViewById(R.id.pass)
        btn = findViewById(R.id.btn)
        forgot = findViewById(R.id.forgot)
        register = findViewById(R.id.register)
        btn.setOnClickListener {
            val mobilenumbers = mobilenumber.text.toString()
            val passw = pass.text.toString()
            var nameOfAvenger = "Avenger"
            val intent = Intent(this@NewActivity, MainActivity::class.java)

            if (mobilenumbers == validmobilenumber) {

                if (passw == validPassword[0]) {
                    nameOfAvenger = "IronMan"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                } else if (passw == validPassword[1]) {
                    nameOfAvenger = "Captain America"
                    savePreferences(nameOfAvenger)

                    startActivity(intent)
                } else if (passw == validPassword[2]) {
                    nameOfAvenger = "The Hulk"
                    savePreferences(nameOfAvenger)

                    startActivity(intent)
                } else if (passw == validPassword[3]) {
                    nameOfAvenger = "The Avengers"
                    savePreferences(nameOfAvenger)

                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@NewActivity, "Incorrect Password", Toast.LENGTH_LONG
                    ).show()

                }
            } else {
                Toast.makeText(
                    this@NewActivity, "Incorrect credentials", Toast.LENGTH_LONG
                ).show()
            }
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("title", title).apply()
    }
}

