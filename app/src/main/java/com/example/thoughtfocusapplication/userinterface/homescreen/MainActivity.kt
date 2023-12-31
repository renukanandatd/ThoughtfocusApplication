package com.example.thoughtfocusapplication.userinterface.homescreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.databinding.ActivityMainBinding
import com.example.thoughtfocusapplication.userinterface.homescreen.fragments.HomeFragment
import com.example.thoughtfocusapplication.userinterface.homescreen.fragments.RefundFragment
import com.example.thoughtfocusapplication.userinterface.homescreen.fragments.SaleFragment
import com.example.thoughtfocusapplication.userinterface.homescreen.fragments.TransactionHistoryFragment
import com.example.thoughtfocusapplication.userinterface.homescreen.fragments.VoidFragment
import com.example.thoughtfocusapplication.userinterface.login.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var mainBinding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2

    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)



            //supportActionBar?.setDisplayHomeAsUpEnabled(true)

            drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
            //val toolbar = findViewById<Toolbar>(R.id.toolbar)
            //setSupportActionBar(toolbar)

            toggle = ActionBarDrawerToggle(
                this, mainBinding.drawerLayout,
                R.string.open_nav,
                R.string.close_nav
            )
            mainBinding.drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            //supportActionBar?.setDisplayHomeAsUpEnabled(true)


            val navigationView = findViewById<NavigationView>(R.id.nav_view)
            navigationView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_sale -> Toast.makeText(
                        applicationContext,
                        "Clicked Item Sale",
                        Toast.LENGTH_SHORT
                    ).show()

                    R.id.nav_void -> Toast.makeText(
                        applicationContext,
                        "Clicked Item Void",
                        Toast.LENGTH_SHORT
                    ).show()

                    R.id.nav_refund -> Toast.makeText(
                        applicationContext,
                        "Clicked Item Refund",
                        Toast.LENGTH_SHORT
                    ).show()

                    R.id.nav_logout -> Toast.makeText(
                        applicationContext,
                        "Clicked Item Logout",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                true
            }

            val bottomNavView: BottomNavigationView = mainBinding.bottomNavigation

            bottomNavView.setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.nav_sale -> openFragment(SaleFragment())
                    R.id.nav_void -> openFragment(VoidFragment())
                    R.id.nav_refund -> openFragment(RefundFragment())
                    R.id.history -> openFragment(TransactionHistoryFragment())
                    R.id.nav_home -> openFragment(HomeFragment())
                }
                mainBinding.drawerLayout.closeDrawer(GravityCompat.START)
                true
            }

            fragmentManager = supportFragmentManager

            // Set the default selected item
            bottomNavView.selectedItemId = R.id.nav_home

        }


        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (toggle.onOptionsItemSelected(item)) {
                return true
            }
            return super.onOptionsItemSelected(item)
        }

        private fun openFragment(fragment: Fragment) {
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.commit()
        }

        private fun toggleVisibility(view: View) {
            if (view.visibility == View.VISIBLE) {
                view.visibility = View.GONE
            } else {
                view.visibility = View.VISIBLE
            }
        }

    override fun onBackPressed() {
        super.onBackPressed()
        showLogoutConfirmationDialog()
    }
    private fun showLogoutConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Logout")
        builder.setMessage("Are you sure you want to logout?")
        builder.setPositiveButton("Yes") { dialog, which ->
            navigateToLoginPage()
        }
        builder.setNegativeButton("No") { dialog, which ->
            Toast.makeText(this, "Logout canceled", Toast.LENGTH_SHORT).show()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun navigateToLoginPage() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
    }
