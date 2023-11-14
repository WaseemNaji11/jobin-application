package com.example.job_application.controllers;

import static com.example.job_application.util.Constants.COUNTRIES_BASE_URL;
import static com.example.job_application.util.Shared.countryInfo;

import android.app.Activity;
import android.util.Log;

import com.example.job_application.activities.SplashActivity;
import com.example.job_application.api.ApiService;
import com.example.job_application.models.CountryDetailedInfo;

import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesController implements Callback<List<CountryDetailedInfo>> {
    Activity context;

    public CountriesController(Activity context) {
        this.context = context;
    }

    public void start() {
        ApiService apiService =
                new Retrofit.Builder()
                        .baseUrl(COUNTRIES_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(ApiService.class);
        Call<List<CountryDetailedInfo>> call = apiService.getAllCountries();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<CountryDetailedInfo>> call, Response<List<CountryDetailedInfo>> response) {
        countryInfo = response.body();
        countryInfo.sort(Comparator.comparing(country -> country.name.common));
        SplashActivity.loadedCountries = true ;
        ((SplashActivity)context).loadLogin();
    }

    @Override
    public void onFailure(Call<List<CountryDetailedInfo>> call, Throwable t) {
        Log.e("TEST", t.getMessage());

    }
}
