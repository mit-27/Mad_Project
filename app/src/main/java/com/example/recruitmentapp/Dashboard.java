package com.example.recruitmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dashboard extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        firebaseAuth = FirebaseAuth.getInstance();

    }

    private void checkuserstatus()
    {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null && user.isEmailVerified())
        {
            // User signed and stay here

        }
        else
        {
            // user is not signed and go to Mainactivity
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
    }

    @Override
    protected void onStart() {
        checkuserstatus();
        super.onStart();
    }

    // inflate the option Menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Handle the menu item clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.action_logout)
        {
            firebaseAuth.signOut();
            checkuserstatus();
        }
        return super.onOptionsItemSelected(item);
    }
}
