package com.example.ecommerce.activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ecommerce.R;
import com.example.ecommerce.adapter.ProductItemClickListener;
import com.example.ecommerce.adapter.ProductRecyclerAdapter;
import com.example.ecommerce.datasource.UserTable;
import com.example.ecommerce.models.Product;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements ProductItemClickListener {
    private DrawerLayout mDrawer;
    public Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private RecyclerView productRecyclerView;
    private ArrayList<Product> listProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        drawerToggle = setupDrawerToggle();
        setupDrawerContent(nvDrawer);

        // Setup toggle to display hamburger icon with nice animation
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);

        listProducts = UserTable.allProducts;
        getProducts();
    }

    private void getProducts() {
        ProductRecyclerAdapter productRecyclerAdapter = new ProductRecyclerAdapter(listProducts, this, this);
        productRecyclerView.setNestedScrollingEnabled(false);
        productRecyclerView.setAdapter(productRecyclerAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        productRecyclerView.setLayoutManager(layoutManager);
        //productRecyclerAdapter.notifyDataSetChanged();
    }

    private void bindViews() {
        productRecyclerView = findViewById(R.id.recyclerview_product);
        toolbar =  findViewById(R.id.my_toolbar);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_top, menu);


        return true;
    }



    @Override
    public void onProductItemClick(int pos, Product product, View view) {
        Intent intent = new Intent(MainActivity.this, DetailProductActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_login_fragment:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_about_fragment:
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
                break;
        }
        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_cart) {
            startActivity(new Intent(MainActivity.this, CartActivity.class));
        }
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}