package com.example.activitylifecycle

//import android.widget.Toolbar
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class dash : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var toolbar: Toolbar
    lateinit var intentA: Intent
    lateinit var intentB: Intent
    lateinit var intentC: Intent
    lateinit var intentD: Intent
    lateinit var intentE: Intent
    lateinit var intentR: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        navigationView.bringToFront()



        setSupportActionBar(toolbar)

        val toggle =
            ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()



        navigationView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.nav_home -> {

                    Toast.makeText(this@dash, "Home Page", Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.nav_cycle -> {
                    intentR = Intent(this@dash, aboutus::class.java)
                    startActivity(intentR)
                    Toast.makeText(this@dash, "Welcome to about us page", Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.gall -> {
                    intentA = Intent(this@dash, gallery::class.java)
                    startActivity(intentA)
                    Toast.makeText(this@dash, "Welcome to Image Gallery", Toast.LENGTH_SHORT)
                        .show()
                }

                R.id.nav_plane ->
                    Toast.makeText(this@dash, "clicked on aboutApp", Toast.LENGTH_SHORT)
                        .show()
                R.id.nav_login -> {
                    intentB = Intent(this@dash, devlp::class.java)
                    startActivity(intentB)
                    Toast.makeText(this@dash, "Welcome To Developers Profile", Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.nav_share -> {
                    intentC = Intent(this@dash, Music::class.java)
                    startActivity(intentC)
                    Toast.makeText(this@dash, "Enjoy Music", Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.nav_logout -> {
                    intentE = Intent(this@dash, LoginActivity2::class.java)
                    startActivity(intentE)
                    Toast.makeText(this@dash, "Logged Out", Toast.LENGTH_SHORT)
                        .show()
                }
                R.id.nav_rate -> {
                    intentD = Intent(this@dash, rossi::class.java)
                    startActivity(intentD)
                    Toast.makeText(this@dash, "Ready To Watch Videos", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            return@setNavigationItemSelectedListener true

        }

        //val imageView = findViewById(R.id.imageView) as ImageView
        val saiyonsc = findViewById(R.id.saiyonsc) as CardView
        // set on-click listener
        saiyonsc.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            //Toast.makeText(this@dash, "You clicked on ImageView.", Toast.LENGTH_SHORT).show()
            val intent10 = Intent(this@dash, AvengersActivity::class.java)
            startActivity(intent10)
        }
        val villansc = findViewById(R.id.villansc) as CardView
        // set on-click listener
        villansc.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            //Toast.makeText(this@dash, "You clicked on ImageView.", Toast.LENGTH_SHORT).show()
            val intent11 = Intent(this@dash, Villans::class.java)
            startActivity(intent11)
        }
        /* val musicc = findViewById(R.id.musicc) as CardView
         // set on-click listener
         musicc.setOnClickListener {
             // your code to perform when the user clicks on the ImageView
             //Toast.makeText(this@dash, "You clicked on ImageView.", Toast.LENGTH_SHORT).show()
             val intent11 = Intent(this@dash, Music::class.java)
             startActivity(intent11)
         }
         */

    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
