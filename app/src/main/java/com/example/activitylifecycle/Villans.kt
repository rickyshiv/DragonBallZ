package com.example.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class Villans : AppCompatActivity() {

    var titleName = "ZTrial"
    lateinit var etMessage: EditText
    lateinit var btnSendMessage: Button
    lateinit var btnLogout: Button
    lateinit var frieza: Button
    lateinit var cell: Button
    lateinit var cooler: Button
    lateinit var android18: Button
    lateinit var boo: Button
    lateinit var kidboo: Button

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), MODE_PRIVATE)

        setContentView(R.layout.activity_villans)

        titleName = sharedPreferences.getString("title", "ZTrial") as String

        title = titleName

        etMessage = findViewById(R.id.etMessage)
        btnSendMessage = findViewById(R.id.btnSendMessage)
        frieza = findViewById(R.id.goku)
        cell = findViewById(R.id.vegeta)
        boo = findViewById(R.id.Ftrunks)
        cooler = findViewById(R.id.gohan)
        kidboo = findViewById(R.id.Goten)
        android18 = findViewById(R.id.Trunkskid)
        btnLogout = findViewById(R.id.btnLogout)
        frieza.setOnClickListener {
            val intent2 = Intent(this@Villans, Frieza::class.java)
            startActivity(intent2)

        }
        cell.setOnClickListener {
            val intent3 = Intent(this@Villans, Cell::class.java)
            startActivity(intent3)

        }
        android18.setOnClickListener {
            val intent6 = Intent(this@Villans, android::class.java)
            startActivity(intent6)
        }
        cooler.setOnClickListener {
            val intent4 = Intent(this@Villans, Cooler::class.java)
            startActivity(intent4)

        }
        boo.setOnClickListener {
            val intent7 = Intent(this@Villans, mazzin::class.java)
            startActivity(intent7)

        }
        kidboo.setOnClickListener {
            val intent5 = Intent(this@Villans, Kidboo::class.java)
            startActivity(intent5)

        }

        btnSendMessage.setOnClickListener {
            val intent = Intent(this@Villans, MessageActivity::class.java)
            val message = etMessage.text.toString()
            intent.putExtra("Message", message)
            startActivity(intent)
        }



        /*Log out from the application. Remember to clear the shared preferences when you log out of the app*/
        btnLogout.setOnClickListener {
            startActivity(Intent(this@Villans, LoginActivity::class.java))
            sharedPreferences.edit().clear().apply()
            finish()
        }

    }
}
