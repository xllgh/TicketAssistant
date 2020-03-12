package com.yly.trainsystem.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yly.trainsystem.R;
import com.yly.trainsystem.databinding.ItemAddBinding;

import java.util.ArrayList;

public class AdRecyclerAdapter extends RecyclerView.Adapter {

    private ArrayList<String> adList;
    private Context context;

    public AdRecyclerAdapter(@NonNull ArrayList<String> adList, @NonNull Context context) {
        this.adList = adList;
        this.context = context;
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.get().load(url).error(R.drawable.ic_launcher_background).into(view);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ItemAddBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_add, parent, false);
        return new AdViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String imgUrl = adList.get(position);
        AdViewModel adViewModel = new AdViewModel();
        adViewModel.imageUrl.set(imgUrl);
        ((AdViewHolder)holder).binding.setAdViewModel(adViewModel);
    }

    @Override
    public int getItemCount() {
        return adList.size();
    }

    static class AdViewHolder extends RecyclerView.ViewHolder {
        ItemAddBinding binding;

         AdViewHolder(@NonNull  ItemAddBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
