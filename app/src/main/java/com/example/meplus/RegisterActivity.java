package com.example.meplus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meplus.database.DatabaseHelper;
import com.example.meplus.databinding.ActivityRegisterBinding;


public class RegisterActivity extends AppCompatActivity {
    public DatabaseHelper dbHelper;
    EditText inputEmail, inputPassword, inputConfirmPassword, inputName;
    Button buttonRegister;
    TextView alreadyHaveaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActivityRegisterBinding binding;
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.alreadyhaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity2.class));
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        inputName = findViewById(R.id.inputName);
        buttonRegister = findViewById(R.id.buttonRegister);
        alreadyHaveaccount = findViewById(R.id.alreadyhaveaccount);

        alreadyHaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity2.class));
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                String confirmPassword = inputConfirmPassword.getText().toString();
                String name = inputName.getText().toString();

                if (password.equals(confirmPassword)) {


                    // Save the email, password, and name to the user table in the database
                    long result = new DatabaseHelper((Context) RegisterActivity.this).adUser(name, email, password);
                    Log.d("User details from RA: ", "Name: " + name + ", Email: " + email + ", Password: " + password);
                    if (result == -1) {
                        Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity2.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
                //dbHelper.close();
            }
        });

    }

}

