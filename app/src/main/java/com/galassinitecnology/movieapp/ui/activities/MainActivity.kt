package com.galassinitecnology.movieapp.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.galassinitecnology.movieapp.R
import com.galassinitecnology.movieapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navDrawer: NavigationView
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.toolbar.title = ""

        bottomNavigationView = binding.navView
        drawerLayout = binding.drawerLayout
        navDrawer = binding.navigationDrawer

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment

        navController = navHostFragment.findNavController()
        binding.navView.setupWithNavController(navController)


        setupBottomNavigation()
        setupDrawer()
    }

    private fun setupDrawer() {
        navDrawer.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            when(it.itemId){
                R.id.menu_option_1 -> {
                    true
                }
                R.id.menu_option_2 -> {
                    val intent = Intent(binding.root.context, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    true}
                else -> false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        drawerLayout.openDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_option -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            else -> false
        }
    }

    private fun setupBottomNavigation() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.homeFragment -> binding.navView.visibility = View.VISIBLE
                R.id.searchFragment -> binding.navView.visibility = View.VISIBLE
                R.id.wishlistFragment -> binding.navView.visibility = View.VISIBLE
                R.id.profileFragment -> binding.navView.visibility = View.VISIBLE
                else -> binding.navView.visibility = View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

}