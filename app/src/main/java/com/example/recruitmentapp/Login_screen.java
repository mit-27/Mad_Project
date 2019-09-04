package com.example.recruitmentapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_screen extends AppCompatActivity {

    TextInputEditText et_email,et_password;
    Button btn_loginup;
    // ProgressBar to display progress of sign up
    ProgressDialog progressDialog;
    // Declare an instance of FirebaseAuth
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        // Action Bar and its Title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Login");
        // enable back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back_icon);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        et_email = findViewById(R.id.l_et_email);
        et_password = findViewById(R.id.l_et_password);
        btn_loginup = (Button)findViewById(R.id.loginBtn);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Log in...");

        btn_loginup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et_email.getText().toString().trim();
                String password = et_password.getText().toString().trim();

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    et_email.setError("Invalid Email");
                    et_email.setFocusable(true);
                }
                else
                {
                    loginuser(email,password);
                }
            }
        });
    }

    private void loginuser(String email,String password)
    {
        // Email and Password are valid , show progress dialogue and register User
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //  login success, dismiss dialogue and start dashboard activity
                            progressDialog.dismiss();
                            FirebaseUser user = mAuth.getCurrentUser();
                            if(user.isEmailVerified())
                            {
                                Toast.makeText(Login_screen.this, "\n Login Successful "+user.getEmail(), Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Dashboard.class));
                                finish();
                            }
                            else
                            {
                                Toast.makeText(Login_screen.this, "\n Please Verify your Email ", Toast.LENGTH_SHORT).show();

                            }

                        } else {
                            // If login fails, display a message to the user.
                            progressDialog.dismiss();
                            Toast.makeText(Login_screen.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Dismiss progrss Dialogue and show error msg
                        progressDialog.dismiss();
                        Toast.makeText(Login_screen.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })
        ;


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }


    public void signup_page_open(View view)
    {
        Intent i = new Intent(getApplicationContext(),Signup_screen.class);
        startActivity(i);
    }
}
