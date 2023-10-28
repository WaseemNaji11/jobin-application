package com.example.job_application.activities;


import static com.example.job_application.util.Shared.countryInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.job_application.R;
import com.example.job_application.adapters.CountryAdapter;
import com.example.job_application.controllers.CountriesController;
import com.example.job_application.models.CountryDetailedInfo;
import com.example.job_application.models.User;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class Register2Activity extends AppCompatActivity {
    public RecyclerView recycleCountries;
    private TextInputEditText etSearchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        recycleCountries = findViewById(R.id.recycleCountries);
        etSearchInput = findViewById(R.id.etSearchInput);
        etSearchInput.addTextChangedListener(searchTextWatcher);
        fillData(countryInfo);
    }

    public void fillData(List<CountryDetailedInfo> countryInfo) {
        if (countryInfo != null) {
            // لا اعتراف بمحتل
            countryInfo.removeIf(country ->
                    "Israel".equalsIgnoreCase(country.name.common)
            );
            recycleCountries.setLayoutManager(new LinearLayoutManager(this));
            // Set up the custom adapter
            CountryAdapter adapter = new CountryAdapter(this, countryInfo);
            adapter.setClickListener(new CountryAdapter.ItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    User.getInstance().setCountry(adapter.getItem(position));
                    startActivity(new Intent(Register2Activity.this, RegisterUserInfoActivity.class));
                }
            });
            recycleCountries.setAdapter(adapter);

        }
    }

    TextWatcher searchTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            List<CountryDetailedInfo> countryInfoTemplate = new ArrayList<>();

            for (CountryDetailedInfo country : countryInfo) {
                if (country.name.common.toLowerCase().contains(s.toString().toLowerCase())
                        || country.name.official.toLowerCase().contains(s.toString().toLowerCase())
                ) {
                    countryInfoTemplate.add(country);
                }
            }
            fillData(countryInfoTemplate);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}