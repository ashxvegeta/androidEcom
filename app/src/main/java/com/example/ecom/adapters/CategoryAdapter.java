package com.example.ecom.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecom.R;
import com.example.ecom.databinding.ItemCategoriesBinding;
import com.example.ecom.models.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    ArrayList<Category> categories;

     // 1
    public  CategoryAdapter(Context context,ArrayList<Category> categories){
       this.context = context;
       this.categories = categories;
    }


     //3
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_categories,parent,false));
    }


    //4
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
      Category category = categories.get(position);
      holder.binding.label.setText(category.getName());
      Glide.with(context).load(category.getIcon()).into(holder.binding.image);

        Color Color = null;
//        for parsing the string color name into integer
        holder.binding.image.setBackgroundColor(Color.parseColor(category.getColor()));
    }

    //    2
    @Override
    public int getItemCount() {
        return categories.size();
    }

    //3.2
    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        ItemCategoriesBinding binding;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemCategoriesBinding.bind(itemView);

        }
    }

}
