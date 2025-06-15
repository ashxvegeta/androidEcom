package com.example.ecom.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ecom.R;
import com.example.ecom.adapters.CartAdapter;
import com.example.ecom.databinding.ActivityCartBinding;
import com.example.ecom.models.Product;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding binding;
    CartAdapter adapter;
    ArrayList<Product> products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         products = new ArrayList<>();

        products.add(new Product("Product 1", "---", "", 123.00, 45, 45, 45, "ss"));
        products.add(new Product("Product 2", "---", "", 122.00, 45, 45, 45, "ss"));
        products.add(new Product("Product 3", "---", "", 111.00, 45, 45, 45, "ss"));

        adapter = new CartAdapter(this,products);
         LinearLayoutManager layoutManager = new LinearLayoutManager(this);
         DividerItemDecoration itemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
         binding.cartList.setLayoutManager(layoutManager);
         binding.cartList.addItemDecoration(itemDecoration);
         binding.cartList.setAdapter(adapter);
    }
}