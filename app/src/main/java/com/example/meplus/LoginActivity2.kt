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
            //Toast.makeText(context, "This is a toast message", Toast.LENGTH_SHORT).show()

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
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

    }

}

class DatabaseHelper2(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(DatabaseContract.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DatabaseContract.SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun addUser(email: String, password: String) {
        val values = ContentValues().apply {
            put(DatabaseContract.UserEntry.COLUMN_EMAIL, email)
            put(DatabaseContract.UserEntry.COLUMN_PASSWORD, password)
        }
        writableDatabase.insert(DatabaseContract.UserEntry.TABLE_NAME, null, values)
    }

    fun authenticateUser(email: String, password: String): Boolean {
        val db = readableDatabase
        val projection = arrayOf(DatabaseContract.UserEntry.COLUMN_EMAIL)
        val selection = "${DatabaseContract.UserEntry.COLUMN_EMAIL} = ? AND ${DatabaseContract.UserEntry.COLUMN_PASSWORD} = ?"
        val selectionArgs = arrayOf(email, password)
        val cursor = db.query(
            DatabaseContract.UserEntry.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        val count = cursor.count
        cursor.close()
        return count > 0
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "MePlus.db"
    }
}

object DatabaseContract2 {
    /* Inner class that defines the table contents */
    class UserEntry : BaseColumns {
        companion object {
            const val TABLE_NAME = "users"
            const val COLUMN_EMAIL = "email"
            const val COLUMN_PASSWORD = "password"
            const val _ID = BaseColumns._ID
        }
    }

     val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${UserEntry.TABLE_NAME} (" +
                "${UserEntry._ID} INTEGER PRIMARY KEY," +
                "${UserEntry.COLUMN_EMAIL} TEXT," +
                "${UserEntry.COLUMN_PASSWORD} TEXT)"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${UserEntry.TABLE_NAME}"
}


