package com.example.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class AvengersActivity : AppCompatActivity() {

    var titleName = "Dragon Ball Z"
    lateinit var etMessage: EditText
    lateinit var btnSendMessage: Button
    lateinit var btnLogout: Button
    lateinit var trunkskid: Button
    lateinit var goku: Button
    lateinit var goten: Button
    lateinit var gohan: Button
    lateinit var Ftrunks: Button
    lateinit var vegeta: Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), MODE_PRIVATE)

        setContentView(R.layout.activity_avengers)


        titleName = sharedPreferences.getString("title", "ZTrial") as String

        title = titleName

        etMessage = findViewById(R.id.etMessage)
        btnSendMessage = findViewById(R.id.btnSendMessage)
        trunkskid = findViewById(R.id.Trunkskid)
        goku = findViewById(R.id.goku)
        goten = findViewById(R.id.Goten)
        gohan = findViewById(R.id.gohan)
        Ftrunks = findViewById(R.id.Ftrunks)
        vegeta = findViewById(R.id.vegeta)
        btnLogout = findViewById(R.id.btnLogout)

        btnSendMessage.setOnClickListener {
            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)
            val message = etMessage.text.toString()
            intent.putExtra("Message", message)
            startActivity(intent)
        }
        trunkskid.setOnClickListener {
            val intent1 = Intent(this@AvengersActivity, Trunkskid::class.java)
            startActivity(intent1)
        }
        goku.setOnClickListener {
            val intent2 = Intent(this@AvengersActivity, Goku::class.java)
            startActivity(intent2)

        }
        goten.setOnClickListener {
            val intent3 = Intent(this@AvengersActivity, Goten::class.java)
            startActivity(intent3)
        }
        gohan.setOnClickListener {
            val intent4 = Intent(this@AvengersActivity, Gohan::class.java)
            startActivity(intent4)
        }
        Ftrunks.setOnClickListener {
            val intent5 = Intent(this@AvengersActivity, FutureTrunks::class.java)
            startActivity(intent5)
        }
        vegeta.setOnClickListener {
            val intent6 = Intent(this@AvengersActivity, Vegeta::class.java)
            startActivity(intent6)
        }

        /*Log out from the application. Remember to clear the shared preferences when you log out of the app*/
        btnLogout.setOnClickListener {
            startActivity(Intent(this@AvengersActivity,LoginActivity::class.java))
            sharedPreferences.edit().clear().apply()
            finish()
        }

    }
}

