package com.example.job_application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.job_application.R;
import com.example.job_application.component.datepicker.DatePickerFragment;
import com.example.job_application.component.datepicker.DatePickerListener;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Scanner;

public class RegisterUserInfoActivity extends AppCompatActivity implements DatePickerListener {
    private TextInputLayout etDOBInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user_info);
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setDatePickerListener(this);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onDateSelected(String selectedDate) {
        // You can store it, display it, or perform any other action with the selected date
        ((Button) findViewById(R.id.btnDateOfBirth)).setText(selectedDate);
    }


    public void showDatePicker(View view) {
        showDatePickerDialog();
    }
}