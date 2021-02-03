package com.ems.employeemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText TextEmailAddress,TextPassword;
    Button button_login;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Login Form");

        TextEmailAddress=(EditText)findViewById(R.id.TextEmailAddress);
        TextPassword=(EditText)findViewById(R.id.TextPassword);
        button_login=(Button)findViewById(R.id.button_login);
        firebaseAuth=FirebaseAuth.getInstance();

button_login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String email = TextEmailAddress.getText().toString().trim();
        String password = TextPassword.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(MainActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(MainActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(MainActivity.this, "password should be more than 6 characters", Toast.LENGTH_SHORT).show();
        }
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            startActivity(new Intent(getApplicationContext(), Menu.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Login Failed or user not available", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });




    }
});

    }

    public void button_signUp(View view) {
        startActivity(new Intent(getApplicationContext(),signup.class));
    }
}