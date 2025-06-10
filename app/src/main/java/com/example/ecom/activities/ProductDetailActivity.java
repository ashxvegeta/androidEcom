package com.example.ecom.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.ecom.R;
import com.example.ecom.databinding.ActivityProductDetailBinding;

public class ProductDetailActivity extends AppCompatActivity {

    ActivityProductDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String name = getIntent().getStringExtra("name");
        String image = getIntent().getStringExtra("image");
        int id = getIntent().getIntExtra("id",0);
        double price = getIntent().getDoubleExtra("price",0);
        String description = getIntent().getStringExtra("description");
        Log.d("ProductDetail", "Description: " + description);
        Glide.with(this).load(image).into(binding.productImage);

        binding.productName.setText(name);
        binding.productPrice.setText("INR " + price);
        binding.productDescription.setText(description);
        Glide.with(this).load(image).into(binding.productImage);
    }
}