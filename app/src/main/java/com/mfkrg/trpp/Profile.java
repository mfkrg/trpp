package com.mfkrg.trpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Profile extends AppCompatActivity implements View.OnClickListener{

    ImageButton toProfileFromProfileButton;
    ImageButton toCatalogButtonFromProfile;
    ImageButton toOrdersFromProfileButton;

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.toCatalogButtonFromProfile:
                Intent intentToCatalogFromProfile = new Intent(this, MainActivity.class);
                startActivity(intentToCatalogFromProfile);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        toCatalogButtonFromProfile = (ImageButton) findViewById(R.id.toCatalogButtonFromProfile);
        toCatalogButtonFromProfile.setOnClickListener(this);
    }
}