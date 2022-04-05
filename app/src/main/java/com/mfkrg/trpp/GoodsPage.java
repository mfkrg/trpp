package com.mfkrg.trpp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mfkrg.trpp.model.Order;

import org.w3c.dom.Text;

public class GoodsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_page);

        ImageView goodsImage = findViewById(R.id.goodsPageImage);
        TextView goodsPageCost = findViewById(R.id.goodsPageCost);
        TextView goodsPageTitle = findViewById(R.id.goodsPageTitle);
        TextView goodsPageText = findViewById(R.id.goodsPageText);

        goodsImage.setImageResource(getIntent().getIntExtra("goodsImage", 0));
        goodsPageTitle.setText(getIntent().getStringExtra("goodsTitle"));
        goodsPageCost.setText(getIntent().getStringExtra("goodsCost"));
        goodsPageText.setText(getIntent().getStringExtra("goodsText"));

    }

    public void addToTheCart(View v){
        String good_id = getIntent().getStringExtra("goodsTitle");
        Order.goods_id.add(good_id);
        Toast.makeText(this, "Added!", Toast.LENGTH_LONG).show();
    }

}