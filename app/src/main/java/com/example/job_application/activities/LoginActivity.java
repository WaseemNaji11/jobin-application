package com.example.job_application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.job_application.R;
import com.example.job_application.util.Constants;
import com.example.job_application.util.Global;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginOnClick(View view) {
        String email = ((TextInputEditText) findViewById(R.id.etEmail)).getText().toString();
        String password = ((TextInputEditText) findViewById(R.id.etPassword)).getText().toString();
        // TODO : validate if the email is matches the regular email, if matches proceed to login, else not just return form this function
        login(email, password);
    }

    private void login(String email, String password) {
        Task<AuthResult> loginTask = Constants.mAuth.signInWithEmailAndPassword(email, password);
        loginTask.addOnSuccessListener(authResult -> {
            Constants.currentUser = authResult.getUser();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        });
        loginTask.addOnFailureListener(result -> {
            // TODO : show Toast shows a message R.string.invalid_login
        });

    }
}