package com.mfkrg.trpp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mfkrg.trpp.model.goods;

import java.util.List;

public class goodsAdapter extends RecyclerView.Adapter<goodsAdapter.goodsViewHolder> {

    Context context;
    List<goods> goodsList;

    @NonNull
    @Override
    public goodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull goodsAdapter.goodsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    public static final class goodsViewHolder extends RecyclerView.ViewHolder{

        public goodsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
