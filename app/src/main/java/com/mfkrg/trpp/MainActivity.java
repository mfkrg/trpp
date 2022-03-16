package com.mfkrg.trpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton homeButtonFromCatalog;
    ImageButton toOrdersFromCatalogButton;
    ImageButton toProfileFromCatalogButton;

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.toProfileFromCatalogButton:
                Intent intentToProfileFromCatalog = new Intent(this, Profile.class);
                startActivity(intentToProfileFromCatalog);
                break;
            case R.id.toOrdersFromCatalogButton:
                Intent intentToOrdersFromCatalog = new Intent(this, Orders.class);
                startActivity(intentToOrdersFromCatalog);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toProfileFromCatalogButton = (ImageButton) findViewById(R.id.toProfileFromCatalogButton);
        toProfileFromCatalogButton.setOnClickListener(this);
        toOrdersFromCatalogButton = (ImageButton) findViewById(R.id.toOrdersFromCatalogButton);
        toOrdersFromCatalogButton.setOnClickListener(this);
    }
}