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

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.example.ecom.R;
import com.example.ecom.adapters.CategoryAdapter;
import com.example.ecom.adapters.ProductAdapter;
import com.example.ecom.databinding.ActivityMainBinding;
import com.example.ecom.models.Category;
import com.example.ecom.models.Product;
import com.example.ecom.utilities.Constants;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import android.util.Log;



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
        initSlider();

    }

    private void initSlider() {
     binding.carousel.addData(new CarouselItem("https://cdn.prod.website-files.com/605826c62e8de87de744596e/62b5a9572dab880f81c5d178_ajVzMkY7zNN-cU8hLJlTXR93WXkC09AI_0Dm-VBCfWe-kbHdRAAATBpSlNajuRsW7e0jHYCOVjdcHY1Sf-3X4tAI22KAFbbu31rgYGEmgCSV_WUrLFWhWl09ddXm7EhIITjKG0OggdxALfJeGQ.jpeg","headphones"));
     binding.carousel.addData(new CarouselItem("https://mobirise.com/extensions/commercem4/assets/images/1.jpg","Shoes"));

    }

    void initCategories(){
        categories = new ArrayList<>();

        categoryAdapter = new CategoryAdapter(this, categories);
        getCategories();
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        binding.CategoriesList.setLayoutManager(layoutManager);
        binding.CategoriesList.setAdapter(categoryAdapter);
    }

    void getCategories() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = Constants.GET_CATEGORIES_URL; // Make sure this is defined
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject mainobject =  new JSONObject(response);
                            if(mainobject.getString("status").equals("success")){
                                JSONArray categoriesArray = mainobject.getJSONArray("categories");
                                for (int i =0; i<categoriesArray.length();i++){
                                     JSONObject object = categoriesArray.getJSONObject(i);
                                     Category category = new Category(
                                         object.getString("name"),
                                        object.getString("icon"),
                                        object.getString("color"),
                                        object.getString("brief"),
                                        object.getInt("id")

                                     );
                                     categories.add(category);
                                }
                                categoryAdapter.notifyDataSetChanged();
                            }else{

                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
//                        Log.e("API_RESPONSE", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // Add the request to the RequestQueue
        queue.add(stringRequest);
    }

    void initProducts(){
        products = new ArrayList<>();

            products = new ArrayList<>();
        products.add(new Product("Shirt", "https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcRdY5Yjjgc1WwogercoUYAi94C5U_5PpExQwI_q6BbGzQ7VjdIBPCynvbSj5Y8yvKyvCg6wTTdkC4_XwV4ANvY5VRPMMvukLveIJHrvr0kZAG5qnbE77HCqcQ", "1", 12, 12, 1, 1));
        products.add(new Product("Polo Shirt", "https://media.darveys.com/catalog/product/c/l/clot_080425_99987_1.jpg", "1", 12, 12, 1, 1));
        products.add(new Product("Hoodie", "https://www.mytheresa.com/media/1094/1238/100/53/P00792442.jpg", "1", 12, 12, 1, 1));
        products.add(new Product("Tank Top", "https://image.hm.com/assets/hm/1d/c0/1dc0aa70c9ab49915f0820a4568d21720345f603.jpg?imwidth=1260", "1", 12, 12, 1, 1));
        products.add(new Product("Sweatshirt", "https://www.mytheresa.com/media/1094/1238/100/4a/P01015715.jpg", "1", 12, 12, 1, 1));
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