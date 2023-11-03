package com.example.job_application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.job_application.R;
import com.example.job_application.util.Constants;
import com.example.job_application.util.Shared;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void toForgetPassword(View view) {
        Intent intent = new
                Intent(LoginActivity.this, ResetPasswordActivity.class);
        startActivity(intent);
    }

    public void loginOnClick(View view) {
        TextInputEditText etPassword  =  ((TextInputEditText) findViewById(R.id.etPasswordInput)) ;
        TextInputEditText etEmail =  ((TextInputEditText) findViewById(R.id.etEmailInput)) ;
        String email = String.valueOf(etEmail.getText());
        String password =  String.valueOf(etPassword.getText());
        if (!Shared.isValidEmail(email)) {
            etEmail.setError(getResources().getString(R.string.invalid_email));
            etEmail.requestFocus();
            return;
        }
        if (!Shared.isPasswordLongEnough(password)) {
            etPassword.setError(getResources().getString(R.string.invalid_password));
            etPassword.requestFocus();
            return;
        }
        login(email, password);

    }

    public void toRegisterOnClick(View view) {
        Intent intent = new
                Intent(LoginActivity.this, Register1Activity.class);
        startActivity(intent);


    }

    private void login(String email, String password) {
        Task<AuthResult> loginTask = Constants.mAuth.signInWithEmailAndPassword(email, password);
        /*
         * if login is successful
         */
        loginTask.addOnSuccessListener(authResult -> {
            // save the current user
            Constants.currentUser = authResult.getUser();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));

        });
        // if login is not successful
        loginTask.addOnFailureListener(result -> {
            // TODO : Azzah ==>  show Toast shows a message R.string.invalid_login
            // Toast.makeText(getApplicationContext(),"invalid login",Toast.LENGTH_LONG).show();
            String message = getString(R.string.invalid_login);
            Toast toast=Toast.makeText(this,message, Toast.LENGTH_SHORT);
            toast.show();
        });

    }
}