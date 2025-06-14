package com.example.ecom.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecom.R;
import com.example.ecom.databinding.ItemCartBinding;
import com.example.ecom.models.Product;

import java.util.ArrayList;

//4 extends RecyclerView.Adapter<CartAdapter.CartViewholder> right click to implements methods
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewholder> {

    //5
    Context context;
    //6
    ArrayList<Product> products;

    //7
    public CartAdapter(Context context,ArrayList<Product> products){
         this.context = context;
         this.products = products;;
    }

    @NonNull
    @Override
    //9
    public CartViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartViewholder(LayoutInflater.from(context).inflate(R.layout.item_cart,parent,false));
    }

    @Override
    //10
    public void onBindViewHolder(@NonNull CartViewholder holder, int position) {

        Product product = products.get(position);
        Glide.with(context)
                .load(product.getImage())
                .into(holder.binding.image);
        holder.binding.name.setText(product.getName());
        holder.binding.price.setText("Rs"+product.getPrice());
    }

    //8
    @Override
    public int getItemCount() {
        return products.size();
    }

    //1
    public  class CartViewholder extends RecyclerView.ViewHolder{

        //2
        ItemCartBinding binding;
        public CartViewholder(@NonNull View itemView) {
            super(itemView);
         //3
            binding = ItemCartBinding.bind(itemView);
        }
    }
}
