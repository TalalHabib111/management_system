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

public class signup extends AppCompatActivity {
EditText name,TextEmailAddress,TextPassword,confirmPassword;
Button button_signUp;
private FirebaseAuth firebaseAuth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("SignUp Form");

        name=(EditText)findViewById(R.id.name);
        TextEmailAddress=(EditText)findViewById(R.id.TextEmailAddress);
        TextPassword=(EditText)findViewById(R.id.TextPassword);
        confirmPassword=(EditText)findViewById(R.id.confirmPassword);
        button_signUp=(Button)findViewById(R.id.button_signUp);

        firebaseAuth=FirebaseAuth.getInstance();

        button_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=name.getText().toString().trim();
                String email=TextEmailAddress.getText().toString().trim();
                String password=TextPassword.getText().toString().trim();
                String confirmpassword=confirmPassword.getText().toString().trim();

                if(TextUtils.isEmpty(username))
                {
                    Toast.makeText(signup.this, "Please enter username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(signup.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(signup.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(confirmpassword))
                {
                    Toast.makeText(signup.this, "Please confirm your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length()<6)
                {
                    Toast.makeText(signup.this, "password should be more than 6 characters", Toast.LENGTH_SHORT).show();
                }
                if (password.equals(confirmpassword))
                {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        Toast.makeText(signup.this, "Registration SuccessFull", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(signup.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }


                                }
                            });
                }


            }
        });


    }

    public void activity_main(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}