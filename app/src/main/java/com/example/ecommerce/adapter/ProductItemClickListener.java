package com.example.ecommerce.adapter;

import android.view.View;

import com.example.ecommerce.models.Product;

public interface ProductItemClickListener {
    void onProductItemClick(int pos, Product product, View view);
}