package com.mfkrg.trpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.mfkrg.trpp.model.Order;

public class Orders extends AppCompatActivity implements View.OnClickListener {

    ImageButton returnFromOrdersToCatalog;
    ImageButton placeyourorder;

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.returnFromOrdersToCatalog:
                Intent intentFromOrdersToCatalog = new Intent(this, MainActivity.class);
                startActivity(intentFromOrdersToCatalog);
                break;
            case R.id.placeyourorder:
                Intent intentplaceyourorder = new Intent(this, Congrats.class);
                startActivity(intentplaceyourorder);
            default:
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        returnFromOrdersToCatalog = (ImageButton) findViewById(R.id.returnFromOrdersToCatalog);
        returnFromOrdersToCatalog.setOnClickListener(this);
        placeyourorder = (ImageButton) findViewById(R.id.placeyourorder);
        placeyourorder.setOnClickListener(this);

        ListView goods_list = findViewById(R.id.goods_list);

        //goods_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Order.goods_id.toArray()));
        goods_list.setAdapter(new ArrayAdapter<>(this, R.layout.text_color_layout, Order.goods_id.toArray()));
    }
}