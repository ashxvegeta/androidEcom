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
            productAdapter = new ProductAdapter(this,products);
            getRecentProducts();
            GridLayoutManager layoutManager = new GridLayoutManager(this,2);
            binding.productlist.setLayoutManager(layoutManager);
            binding.productlist.setAdapter(productAdapter);

    }

    void getRecentProducts() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = Constants.GET_PRODUCTS_URL + "?count=10";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                             if(object.getString("status").equals("success")){
                                 JSONArray productsArray = object.getJSONArray("products");
                                 for(int i = 0 ; i<productsArray.length();i++){
                                    JSONObject  childobject = productsArray.getJSONObject(i);
                                    Product product =  new Product(
                                            childobject.getString("name"),
                                            childobject.getString("image"),
                                            childobject.getString("status"),
                                            childobject.getDouble("price"),
                                            childobject.getDouble("pricediscount"),
                                            childobject.getInt("stock"),
                                            childobject.getInt("id")
                                    );
                                    products.add(product);
                                 }
                                 productAdapter.notifyDataSetChanged();
                             }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        // Handle successful response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                }
        );

        // Add the request to the RequestQueue
        queue.add(stringRequest);
    }

}