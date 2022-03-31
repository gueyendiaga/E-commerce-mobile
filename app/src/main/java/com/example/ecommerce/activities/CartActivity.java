package com.example.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ecommerce.R;
import com.example.ecommerce.adapter.CartItemRecyclerAdapter;
import com.example.ecommerce.adapter.ProductRecyclerAdapter;
import com.example.ecommerce.datasource.SessionManager;
import com.example.ecommerce.models.Cart;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    RecyclerView cartItemRecyclerview;
    ImageView btn_retour;
    SessionManager sessionManager;
    ArrayList<Cart> listCarts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        sessionManager = new SessionManager(this);
        listCarts = (ArrayList<Cart>) sessionManager.getSavedListCart();

        bindViews();

        getItemCarts();

        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getItemCarts() {
        if (listCarts != null && listCarts.size() > 0) {
            CartItemRecyclerAdapter cartItemRecyclerAdapter = new CartItemRecyclerAdapter(listCarts, this);
            cartItemRecyclerview.setNestedScrollingEnabled(false);
            cartItemRecyclerview.setAdapter(cartItemRecyclerAdapter);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            cartItemRecyclerview.setLayoutManager(layoutManager);
        }
    }

    private void bindViews() {
        btn_retour = findViewById(R.id.btn_retour);
        cartItemRecyclerview = findViewById(R.id.recyclerview_cart_item);
    }
}