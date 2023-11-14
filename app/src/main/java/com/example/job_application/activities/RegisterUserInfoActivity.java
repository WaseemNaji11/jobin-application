package com.example.job_application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.job_application.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Scanner;

public class RegisterUserInfoActivity extends AppCompatActivity {
private TextInputEditText etDOBInput ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user_info);
        etDOBInput = findViewById(R.id.etDOBInput);
        etDOBInput.setEnabled(false);
        etDOBInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            
            }
        });
    }
}