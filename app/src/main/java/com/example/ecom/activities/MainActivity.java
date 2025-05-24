package com.example.ecom.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.ecom.R;
import com.example.ecom.adapters.CategoryAdapter;
import com.example.ecom.adapters.ProductAdapter;
import com.example.ecom.databinding.ActivityMainBinding;
import com.example.ecom.models.Category;
import com.example.ecom.models.Product;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;
    ProductAdapter productAdapter;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initCategories();
        initProducts();

    }

    void initCategories(){
        categories = new ArrayList<>();
        categories.add(new Category("Electronics", "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9", "#FF5733", "Gadgets and devices", 1));
        categories.add(new Category("Clothing", "https://images.unsplash.com/photo-1521334884684-d80222895322", "#33C1FF", "Men & Women Fashion", 2));
        categories.add(new Category("Books", "https://images.unsplash.com/photo-1512820790803-83ca734da794", "#FFC300", "Fiction, education and more", 3));
        categories.add(new Category("Home & Kitchen", "https://images.unsplash.com/photo-1600585154340-be6161a56a0c?auto=format&fit=crop&w=400&q=80", "#8D33FF", "Furniture, Decor", 4));
        categories.add(new Category("Toys", "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9", "#FF33A6", "Toys for kids", 5));
        categories.add(new Category("Beauty & Care", "https://images.unsplash.com/photo-1521334884684-d80222895322", "#33FFB5", "Beauty & Skincare", 6));

        categoryAdapter = new CategoryAdapter(this, categories);
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        binding.CategoriesList.setLayoutManager(layoutManager);
        binding.CategoriesList.setAdapter(categoryAdapter);
    }

    void initProducts(){
        products = new ArrayList<>();

            products = new ArrayList<>();
        products.add(new Product("Shirt", "https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcRdY5Yjjgc1WwogercoUYAi94C5U_5PpExQwI_q6BbGzQ7VjdIBPCynvbSj5Y8yvKyvCg6wTTdkC4_XwV4ANvY5VRPMMvukLveIJHrvr0kZAG5qnbE77HCqcQ", "1", 12, 12, 1, 1));
        products.add(new Product("Polo Shirt", "https://media.darveys.com/catalog/product/c/l/clot_080425_99987_1.jpg", "1", 12, 12, 1, 1));
        products.add(new Product("Hoodie", "https://www.mytheresa.com/media/1094/1238/100/53/P00792442.jpg", "1", 12, 12, 1, 1));
        products.add(new Product("Tank Top", "https://image.hm.com/assets/hm/1d/c0/1dc0aa70c9ab49915f0820a4568d21720345f603.jpg?imwidth=1260", "1", 12, 12, 1, 1));
        products.add(new Product("Sweatshirt", "https://www.mytheresa.com/media/1094/1238/100/4a/P01015715.jpg", "1", 12, 12, 1, 1));
            productAdapter = new ProductAdapter(this,products);
            GridLayoutManager layoutManager = new GridLayoutManager(this,2);
            binding.productlist.setLayoutManager(layoutManager);
            binding.productlist.setAdapter(productAdapter);




    }
}