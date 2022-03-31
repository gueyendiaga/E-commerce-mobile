package com.example.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ecommerce.R;

public class GestionProductActivity extends AppCompatActivity {

    private ImageView btn_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_product);
        btn_retour = findViewById(R.id.btn_retour);

        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GestionProductActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}