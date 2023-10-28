package com.example.job_application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.job_application.R;
import com.example.job_application.controllers.CountriesController;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    public static boolean loadedCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new CountriesController(this).start();
    }

    public void loadLogin() {
        if (loadedCountries) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

}