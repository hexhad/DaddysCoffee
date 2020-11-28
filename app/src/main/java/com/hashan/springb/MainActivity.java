package com.hashan.springb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.hashan.springb.adapter.RecyclerViewAdapter;
import com.hashan.springb.model.Coffee;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "http://192.168.8.100:8088/api";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Coffee> coffees;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coffees = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleview);


        JSONRequest();
    }

    private void JSONRequest() {
        request= new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {




                JSONObject jsonObject = null;

                for (int i = 0; i < response.length() ; i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        Coffee coffee = new Coffee();
                        coffee.setDesc(jsonObject.getString("desc"));
                        coffee.setImg(jsonObject.getString("img"));
                        coffee.setName(jsonObject.getString("name"));
                        coffee.setId(jsonObject.getInt("id"));
                        coffee.setPrice(jsonObject.getInt("price"));
                        coffee.setOrder(jsonObject.getInt("order"));

                        coffees.add(coffee);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                setupRecyclerView(coffees);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }



    private void setupRecyclerView(List<Coffee> coffees) {

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,coffees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
    }

}