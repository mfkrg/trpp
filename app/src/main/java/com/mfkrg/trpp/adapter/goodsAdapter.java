package com.mfkrg.trpp.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mfkrg.trpp.GoodsPage;
import com.mfkrg.trpp.R;
import com.mfkrg.trpp.model.goods;

import java.util.List;

public class goodsAdapter extends RecyclerView.Adapter<goodsAdapter.GoodsViewHolder> {

    Context context;
    List<goods> GoodsList;

    public goodsAdapter(Context context, List<goods> GoodsList) {
        this.context = context;
        this.GoodsList = GoodsList;
    }

    @NonNull
    @Override
    public GoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.goods_item, parent, false);
        return new goodsAdapter.GoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsViewHolder holder, int position) {

        holder.goodsBg.setBackgroundColor(Color.parseColor(GoodsList.get(position).getColor()));

        int imageId = context.getResources().getIdentifier("ic_" + GoodsList.get(position).getImg(), "drawable", context.getPackageName());
        holder.goodsImage.setImageResource(imageId);

        holder.goodsTitle.setText(GoodsList.get(position).getName());
        holder.goodsCost.setText(GoodsList.get(position).getCost());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToGoodsPage = new Intent(context, GoodsPage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context,
                        new Pair<View, String>(holder.goodsImage, "goodsImageAnim"), new Pair<View, String>(holder.goodsTitle, "TitleAnim"),
                        new Pair<View, String>(holder.goodsCost, "CostAnim"));



                intentToGoodsPage.putExtra("goodsBg", Color.parseColor(GoodsList.get(position).getColor()));
                intentToGoodsPage.putExtra("goodsImage", imageId);
                intentToGoodsPage.putExtra("goodsTitle", GoodsList.get(position).getName());
                intentToGoodsPage.putExtra("goodsCost", GoodsList.get(position).getCost());
                intentToGoodsPage.putExtra("goodsText", GoodsList.get(position).getText());

                context.startActivity(intentToGoodsPage, options.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return GoodsList.size();
    }

    public static final class GoodsViewHolder extends RecyclerView.ViewHolder{

        LinearLayout goodsBg;
        ImageView goodsImage;
        TextView goodsTitle, goodsCost;


        public GoodsViewHolder(@NonNull View itemView) {
            super(itemView);

            goodsBg = itemView.findViewById(R.id.goodsBg);
            goodsImage = itemView.findViewById(R.id.goodsPC1);
            goodsTitle = itemView.findViewById(R.id.goodsTitle);
            goodsCost = itemView.findViewById(R.id.goodsCost);
        }
    }

}
