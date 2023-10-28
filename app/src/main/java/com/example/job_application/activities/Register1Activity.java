package com.example.job_application.activities;

import static com.example.job_application.util.Shared.containsNumbers;
import static com.example.job_application.util.Shared.containsUpperAndLowerCase;
import static com.example.job_application.util.Shared.isValidEmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.job_application.R;
import com.example.job_application.models.User;
import com.google.android.material.textfield.TextInputEditText;

public class Register1Activity extends AppCompatActivity {

    private TextInputEditText etEmail, etPassword, etConfirmPassword;
    private Button btnContinueRegistration ;
    boolean validPasswordLength;
    boolean containsUpperAndLowerLetters;
    boolean containsNumber;
    boolean matchesPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        etEmail = findViewById(R.id.etEmailInput);
        etPassword = findViewById(R.id.etPasswordInput);
        etConfirmPassword = findViewById(R.id.etConfirmPasswordInput);
        etPassword.addTextChangedListener(passwordWatcher);
        etConfirmPassword.addTextChangedListener(confirmPasswordWatcher);
        btnContinueRegistration = findViewById(R.id.btnContinue);
    }


    TextWatcher passwordWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // TODO Auto-generated method stub
            if (s.length() >= 8) {
                ((TextView) findViewById(R.id.tvLengthError)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.correct, 0, 0, 0);
                validPasswordLength = true;
            } else {
                ((TextView) findViewById(R.id.tvLengthError)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.error, 0, 0, 0);
                validPasswordLength = false;
            }
            if (containsNumbers(s.toString())) {
                ((TextView) findViewById(R.id.tvContainNumbers)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.correct, 0, 0, 0);
                containsNumber = true;
            } else {
                ((TextView) findViewById(R.id.tvContainNumbers)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.error, 0, 0, 0);
                containsNumber = false;
            }
            if (containsUpperAndLowerCase(s.toString())) {
                ((TextView) findViewById(R.id.tvLowerAndUpperCase)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.correct, 0, 0, 0);
                containsUpperAndLowerLetters = true;
            } else {
                ((TextView) findViewById(R.id.tvLowerAndUpperCase)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.error, 0, 0, 0);
                containsUpperAndLowerLetters = false;
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // TODO Auto-generated method stub
        }

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
        }
    };

    TextWatcher confirmPasswordWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (String.valueOf(etConfirmPassword.getText()).equals(String.valueOf(etPassword.getText()))) {
                ((TextView) findViewById(R.id.tvMatchPassword)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.correct, 0, 0, 0);
                matchesPassword = true;
            } else {
                ((TextView) findViewById(R.id.tvMatchPassword)).setCompoundDrawablesWithIntrinsicBounds(R.drawable.error, 0, 0, 0);
                matchesPassword = false;
            }
            enableContinueBtn();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void enableContinueBtn() {
        btnContinueRegistration.setEnabled(validPasswordLength && containsUpperAndLowerLetters && containsNumber && matchesPassword);
    }

    public void continueRegistration(View view) {
        if (!isValidEmail(String.valueOf(etEmail.getText()).trim())) {

        }else {
            User.getInstance().setEmail(String.valueOf(etEmail.getText()).trim());
            User.getInstance().setPassword(String.valueOf(etPassword.getText()));

            startActivity(new Intent(this , Register2Activity.class));
        }
    }
}