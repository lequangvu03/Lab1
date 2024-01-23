package com.example.lab;

import androidx.annotation.NonNull;

public class Person {
    private String name;
    private String phoneNumber;
    private String gender;
    private String country;

    public Person(String name, String phoneNumber, String gender, String country) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @NonNull
    @Override
    public String toString() {
        return name + " - " + " - " + phoneNumber + " - " + gender + " - " + country;
    }
}
