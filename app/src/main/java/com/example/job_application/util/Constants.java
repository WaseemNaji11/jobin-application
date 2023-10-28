package com.example.job_application.util;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Constants {
    public static FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public static FirebaseUser currentUser = null ;
    public static final String REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";


    public static double LONGITUDE;
    public static double LATITUDE;

    public static final String INVALID_PASSWORD_LENGTH_MESSAGE = "password should be more than 6 characters";
    public static final String PASSWORD_DOES_NOT_MATCH_MESSAGE = "Password does not match! ";
    public static final String INVALID_EMAIL_PATTERN_MESSAGE = "Please insert a valid email";
    public static final String EMPTY_FIELD_MESSAGE = "This field is required!";
    public static String COUNTRIES_BASE_URL = "https://restcountries.com/";
}
