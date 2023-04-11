package com.example.meplus

import android.content.Intent
import android.os.Bundle

import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.meplus.databinding.ActivityLoginBinding
import com.example.meplus.databinding.ActivityMainBinding



class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val demoLoginButton = binding.demoLoginBtn
        demoLoginButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

}


