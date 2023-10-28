package com.example.job_application.api;

import com.example.job_application.models.CountryDetailedInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("v3.1/all")
    Call<List<CountryDetailedInfo>> getAllCountries();
}
