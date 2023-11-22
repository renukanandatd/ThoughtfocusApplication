package com.example.thoughtfocusapplication.userinterface.homescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var mainBinding: ActivityMainBinding
    //private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)


        toggle = ActionBarDrawerToggle(this,mainBinding.drawerLayout,
            R.string.open_nav,
            R.string.close_nav
        )
        mainBinding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.nav_sale -> Toast.makeText(applicationContext,"Clicked Item Sale", Toast.LENGTH_SHORT).show()
                R.id.nav_void -> Toast.makeText(applicationContext,"Clicked Item Void", Toast.LENGTH_SHORT).show()
                R.id.nav_refund -> Toast.makeText(applicationContext,"Clicked Item Refund", Toast.LENGTH_SHORT).show()
                R.id.nav_logout -> Toast.makeText(applicationContext,"Clicked Item Logout", Toast.LENGTH_SHORT).show()
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}