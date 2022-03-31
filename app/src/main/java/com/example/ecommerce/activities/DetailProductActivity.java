package com.example.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecommerce.R;
import com.example.ecommerce.datasource.SessionManager;
import com.example.ecommerce.models.Cart;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.utils.GlideApp;

import java.util.ArrayList;
import java.util.UUID;

public class DetailProductActivity extends AppCompatActivity {

    private Product product;
    ImageView img_product, ic_btn_retour;
    TextView is_in_stock;
    TextView price;
    TextView description;
    TextView name;
    View detail_product;
    TextView counter;
    View minus, plus;
    int cmpt = 1;
    int totalPrice = 0;
    ArrayList<Cart> listCarts = new ArrayList<>();
    SessionManager sessionManager;
    Button btn_save_item_cart, btn_view_item_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        bindViews();

        sessionManager = new SessionManager(this);
        listCarts = (ArrayList<Cart>) sessionManager.getSavedListCart();

        ic_btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent extras = getIntent();
        product = (Product) extras.getSerializableExtra("product");
        totalPrice = product.getPrice();
        setInfos();
        counterItemCart();

        btn_save_item_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveItemCart();
            }
        });
        btn_view_item_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProductActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setInfos() {
        if(product != null) {
            GlideApp.with(this)
                    .load(product.getUrlPhoto())
                    .centerCrop()
                    .placeholder(R.drawable.nutella)
                    .into(img_product);

            counter.setText(cmpt + "");
            name.setText(product.getName());
            price.setText(product.getPrice() + " FCFA");
            description.setText(product.getDescription());
            /*if (product.isInStock()) {
                is_in_stock.setText("En stock");
                is_in_stock.setTextColor(getResources().getColor(R.color.green));
            } else {
                is_in_stock.setText("Non disponoble");
                is_in_stock.setTextColor(getResources().getColor(R.color.colorred));
            }*/


        }
    }

    private void bindViews() {
        img_product = findViewById(R.id.img_product);
        ic_btn_retour = findViewById(R.id.ic_btn_retour);
        is_in_stock = findViewById(R.id.is_in_stock);
        price = findViewById(R.id.price);
        description = findViewById(R.id.description);
        detail_product = findViewById(R.id.detail_product);
        name = findViewById(R.id.name);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        counter = findViewById(R.id.counter);
        btn_save_item_cart = findViewById(R.id.btn_save_item_cart);
        btn_view_item_cart = findViewById(R.id.btn_view_item_cart);
    }

    private void counterItemCart() {
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cmpt >= 1) {
                    cmpt = cmpt - 1;
                    totalPrice = product.getPrice() * cmpt;
                    price.setText(totalPrice + "");
                    counter.setText(cmpt + "");
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cmpt = cmpt + 1;
                totalPrice = product.getPrice() * cmpt;
                price.setText(totalPrice + "");
                counter.setText(cmpt + "");
            }
        });
    }

    private void saveItemCart() {
        Cart itemCart = new Cart(product.getUid(), product.getName(), totalPrice, cmpt, product.getUrlPhoto());
        if (listCarts == null) {
            listCarts = new ArrayList<>();
        }
        listCarts.add(itemCart);
        sessionManager.saveCartList(listCarts);
        btn_save_item_cart.setVisibility(View.GONE);
        btn_view_item_cart.setVisibility(View.VISIBLE);
    }
}