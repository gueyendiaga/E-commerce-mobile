package com.example.ecommerce.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerce.R;
import com.example.ecommerce.activities.DetailProductActivity;
import com.example.ecommerce.adapter.ProductItemClickListener;
import com.example.ecommerce.adapter.ProductRecyclerAdapter;
import com.example.ecommerce.datasource.UserTable;
import com.example.ecommerce.models.Product;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements ProductItemClickListener {
    private RecyclerView productRecyclerView;
    private ArrayList<Product> listProducts;
    private View view;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

 

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        listProducts = UserTable.allProducts;
        bindViews();
        getProducts();
        return view;
    }

    private void getProducts() {
        ProductRecyclerAdapter productRecyclerAdapter = new ProductRecyclerAdapter(listProducts, getActivity(), this);
        productRecyclerView.setNestedScrollingEnabled(false);
        productRecyclerView.setAdapter(productRecyclerAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        productRecyclerView.setLayoutManager(layoutManager);
        //productRecyclerAdapter.notifyDataSetChanged();
    }

    private void bindViews() {
        productRecyclerView = view.findViewById(R.id.recyclerview_product);
    }

    @Override
    public void onProductItemClick(int pos, Product product, View view) {
        Intent intent = new Intent(getActivity(), DetailProductActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }
}