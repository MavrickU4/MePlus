package com.example.meplus

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast

import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.meplus.databinding.ActivityMainBinding
import com.example.meplus.ui.dashboard.DashboardFragment
import com.example.meplus.ui.notifications.NotificationsFragment
import com.example.meplus.ui.photos.PhotosFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Add an OnNavigationItemSelectedListener to the bottom navigation view
        navView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    val fragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, fragment)
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.navigation_dashboard -> {
                    val fragment = DashboardFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, fragment)
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.navigation_notifications -> {
                    val fragment = NotificationsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, fragment)
                        .addToBackStack(null)
                        .commit()
                    true
                }
                else -> false
            }
        }

        val fragment = PhotosFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.photos_container, fragment)
            .commit()
    }






}


