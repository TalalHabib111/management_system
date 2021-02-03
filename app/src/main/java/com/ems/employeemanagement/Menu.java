package com.ems.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setTitle("DashBoard");

        ImageView home,add_cardView,attendance_cardView,logout_cardView;
        home=(ImageView) findViewById(R.id.home);
        add_cardView=(ImageView) findViewById(R.id.add_cardView);
        attendance_cardView=(ImageView) findViewById(R.id.attendance_cardView);
        logout_cardView=(ImageView) findViewById(R.id.logout_cardView);
    }
    public void home_cardView(View view) {
        startActivity(new Intent(getApplicationContext(),Menu.class));

    }
    public void add_cardView(View view) {
        startActivity(new Intent(getApplicationContext(),EmployeeRecord.class));
    }

     public void logout_cardView(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }


    public void attendance_cardView(View view) {
        startActivity(new Intent(getApplicationContext(),attendance.class));
    }
}