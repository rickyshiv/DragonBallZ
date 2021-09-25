package com.example.activitylifecycle


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var mysong: MediaPlayer
    lateinit var mysong2: MediaPlayer
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegisterYourself: TextView

    val validMobileNumber = "8602911525"
    val validPassword = arrayOf("goku", "vegeta", "goten", "trunks")

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        setContentView(R.layout.activity_login)
        mysong=MediaPlayer.create(this@LoginActivity, R.raw.dragon3);
        mysong.start();
       /* if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }*/

        title = "Dragon Ball Z"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegisterYourself = findViewById(R.id.txtRegister)

        btnLogin.setOnClickListener {
           mysong.pause()
            
            val mobileNumber = etMobileNumber.text.toString()

            val password = etPassword.text.toString()

            var nameOfAvenger = "Dragon Ball Z"

            val intent = Intent(this@LoginActivity,dash::class.java)

            if ((mobileNumber == validMobileNumber)) {

                when (password) {
                    validPassword[0] -> {

                        nameOfAvenger = "Cooler mode"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)

                    }
                    validPassword[1] -> {

                        nameOfAvenger = "Frieza mode"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)

                    }
                    validPassword[2] -> {

                        nameOfAvenger = "MajinBuu Mode"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)

                    }
                    validPassword[3] -> {

                        nameOfAvenger = "Cell Mode"

                        savePreferences(nameOfAvenger)

                        startActivity(intent)

                    }
                    else -> Toast.makeText(this@LoginActivity, "Incorrect Password", Toast.LENGTH_LONG).show()
                }

            } else {

                Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()

            }
        }


        txtForgotPassword.setOnClickListener {
            mysong.pause()
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        txtRegisterYourself.setOnClickListener {
            mysong.pause()
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
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