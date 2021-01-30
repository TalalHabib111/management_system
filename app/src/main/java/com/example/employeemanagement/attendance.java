package com.example.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class attendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        getSupportActionBar().setTitle("Attendance");
    }
}