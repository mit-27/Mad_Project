package com.example.recruitmentapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class profile_page extends AppCompatActivity {

    MaterialBetterSpinner genderSpinner, jobTitleSpinner ;

    String[] jobTitleArray = {"Job 1 "," Job 2" , "Job 3"};
    String[] gender = {"MALE","FEMALE","OTHER"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        genderSpinner = (MaterialBetterSpinner) findViewById(R.id.genderSpinner);
        jobTitleSpinner = (MaterialBetterSpinner) findViewById(R.id.jobTitleSpinner);

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(profile_page.this, android.R.layout.simple_dropdown_item_1line, gender);
        genderSpinner.setAdapter(genderAdapter);

        ArrayAdapter<String> jobTitleAdapter = new ArrayAdapter<String>(profile_page.this, android.R.layout.simple_dropdown_item_1line,jobTitleArray);
        jobTitleSpinner.setAdapter(jobTitleAdapter);
    }
}
