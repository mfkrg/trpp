package com.mfkrg.trpp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.mfkrg.trpp.adapter.goodsAdapter;
import com.mfkrg.trpp.model.goods;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView rcView;
    goodsAdapter goodsAdapter;
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


        List<goods> GoodsList = new ArrayList<>();
        GoodsList.add(new goods(1,"Custom case #2", "399", "java", "#00000040"));
        GoodsList.add(new goods(2,"Custom case #3", "499","java", "#00000040"));

        setGoodsRecycler(GoodsList);



        toProfileFromCatalogButton = (ImageButton) findViewById(R.id.toProfileFromCatalogButton);
        toProfileFromCatalogButton.setOnClickListener(this);
        toOrdersFromCatalogButton = (ImageButton) findViewById(R.id.toOrdersFromCatalogButton);
        toOrdersFromCatalogButton.setOnClickListener(this);
    }

    private void setGoodsRecycler(List<goods> GoodsList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);

        rcView = findViewById(R.id.rcView);
        rcView.setLayoutManager(layoutManager);

        goodsAdapter = new goodsAdapter(this, GoodsList);
        rcView.setAdapter(goodsAdapter);

    }
}