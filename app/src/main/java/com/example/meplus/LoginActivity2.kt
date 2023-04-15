package com.example.meplus

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.meplus.database.DatabaseHelper
import com.example.meplus.databinding.ActivityLoginBinding

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.meplus.databinding.ActivityLogin2Binding

class LoginActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityLogin2Binding
    private lateinit var dbHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createNewAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        val loginButton = binding.buttonLogin
        dbHelper = DatabaseHelper(this)

        val demoLoginButton = binding.demoLoginBtn2
        demoLoginButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        loginButton.setOnClickListener {
            val email = binding.inputEmail.text.toString()
            val password = binding.inputPassword.text.toString()

            if (dbHelper.authenticateUser(email, password)) {
                startActivity(Intent(this, MainActivity::class.java))
                Toast.makeText(this, "Successful email and password!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

    }

}

