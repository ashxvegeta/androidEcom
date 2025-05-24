package com.example.ecom.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecom.R;
import com.example.ecom.databinding.ItemProductBinding;
import com.example.ecom.models.Product;

import java.util.ArrayList;


//2
public class ProductAdapter extends  RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    Context context;
    ArrayList<Product> products;

    public ProductAdapter (Context context,ArrayList<Product> products){
       this.context = context;
       this.products = products;;
    }

    //3 all three method will be implement later using alt enter
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.item_product,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
      Product product = products.get(position);
      //set the image
      Glide.with(context).load(product.getImage()).into(holder.binding.image);
//       set the image
        holder.binding.label.setText(product.getName());
//       set the price
        holder.binding.price.setText("INR "+product.getPrice());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    //   1
    public  class ProductViewHolder extends RecyclerView.ViewHolder{

        ItemProductBinding binding;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemProductBinding.bind(itemView);
        }
    }

}
