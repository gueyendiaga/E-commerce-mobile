package com.example.ecommerce.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerce.R;
import com.example.ecommerce.activities.DetailProductActivity;
import com.example.ecommerce.adapter.CategorieItemClickListener;
import com.example.ecommerce.adapter.CategorieRecyclerAdapter;
import com.example.ecommerce.adapter.ProductRecyclerAdapter;
import com.example.ecommerce.datasource.UserTable;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.models.Product;

import java.util.ArrayList;


public class CategorieFragment extends Fragment implements CategorieItemClickListener {
    private RecyclerView catyegorieRecyclerView;
    private ArrayList<Category> listCategories;
    private View view;

    public CategorieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_categorie, container, false);

        listCategories = UserTable.allCategories;
        bindViews();
        getCategories();
        return view;
    }

    private void getCategories() {
        CategorieRecyclerAdapter categorieRecyclerAdapter = new CategorieRecyclerAdapter(listCategories, getActivity(), this);
        catyegorieRecyclerView.setNestedScrollingEnabled(false);
        catyegorieRecyclerView.setAdapter(categorieRecyclerAdapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        catyegorieRecyclerView.setLayoutManager(layoutManager);
        //productRecyclerAdapter.notifyDataSetChanged();
    }

    private void bindViews() {
        catyegorieRecyclerView = view.findViewById(R.id.recyclerview_category);
    }

    @Override
    public void onCategoryItemClick(int pos, Category category) {
        Intent intent = new Intent(getActivity(), DetailProductActivity.class);
        intent.putExtra("categorie", category);
        startActivity(intent);
    }
}