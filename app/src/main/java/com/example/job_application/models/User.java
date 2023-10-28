package com.example.job_application.models;

import java.time.LocalDate;

public class User {
    private String email;
    private String password;
    private CountryDetailedInfo country;
    private String phone;
    private String imageUri;
    private String firstName;
    private String lastName;
    private String university;
    private LocalDate dateOfBirth;

    private static User user;

    private User() {
    }

    public static User getInstance() {
        if (user == null)
            user = new User();
        return user;
    }

    public CountryDetailedInfo getCountry() {
        return country;
    }

    public void setCountry(CountryDetailedInfo country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
