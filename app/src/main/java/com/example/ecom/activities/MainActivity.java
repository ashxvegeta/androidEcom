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
import com.example.ecom.databinding.ActivityMainBinding;
import com.example.ecom.models.Category;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        categories = new ArrayList<>();
        categories.add(new Category("Sports & Outdoor", "https://picsum.photos/seed/picsum/200/300", "#18ab4e", "Some description", 1));
        categories.add(new Category("Sports & Outdoor", "https://picsum.photos/seed/picsum/200/300", "#18ab4e", "Some description", 1));
        categories.add(new Category("Sports & Outdoor", "https://picsum.photos/seed/picsum/200/300", "#18ab4e", "Some description", 1));
        categories.add(new Category("Sports & Outdoor", "https://picsum.photos/seed/picsum/200/300", "#18ab4e", "Some description", 1));
        categories.add(new Category("Sports & Outdoor", "https://picsum.photos/seed/picsum/200/300", "#18ab4e", "Some description", 1));
        categories.add(new Category("Sports & Outdoor", "https://picsum.photos/seed/picsum/200/300", "#18ab4e", "Some description", 1));

        categoryAdapter = new CategoryAdapter(this, categories);
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        binding.CategoriesList.setLayoutManager(layoutManager);
        binding.CategoriesList.setAdapter(categoryAdapter);


    }
}