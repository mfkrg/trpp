package com.mfkrg.trpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Congrats extends AppCompatActivity implements View.OnClickListener{

    ImageButton fromCongratsToProfile;
    ImageButton toCatalogFromCongrats;

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.fromCongratsToProfile:
                Intent intentCongratsToProfile = new Intent(this, Profile.class);
                startActivity(intentCongratsToProfile);
                break;
            case R.id.toCatalogFromCongrats:
                Intent intenttoCatalogFromCongrats = new Intent(this, MainActivity.class);
                startActivity(intenttoCatalogFromCongrats);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        fromCongratsToProfile = (ImageButton) findViewById(R.id.fromCongratsToProfile);
        fromCongratsToProfile.setOnClickListener(this);
        toCatalogFromCongrats = (ImageButton) findViewById(R.id.toCatalogFromCongrats);
        toCatalogFromCongrats.setOnClickListener(this);
    }
}