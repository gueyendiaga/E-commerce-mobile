package com.example.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.R;
import com.example.ecommerce.datasource.SessionManager;
import com.example.ecommerce.models.User;

import java.util.UUID;

public class LoginActivity extends AppCompatActivity {

    private TextView txt_name;
    private TextView txt_email;
    private TextView txt_password;
    private SessionManager sessionManager;
    private ImageView btn_retour;
    private View to_register;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        bindViews();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bindViews() {
        txt_name = findViewById(R.id.txt_name);
        txt_email = findViewById(R.id.txt_email);
        txt_password = findViewById(R.id.txt_password);
        btn_retour = findViewById(R.id.ic_btn_retour);
        to_register = findViewById(R.id.to_register);
        btn_login = findViewById(R.id.btn_login);
    }

    private void signIn() {
        String email = txt_email.getText().toString().trim();
        String password = txt_password.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            txt_email.setError("Ce champ est obligatoire");
        } else if (TextUtils.isEmpty(password)) {
            txt_password.setError("Ce champ est obligatoire");
        } else {
            User user = sessionManager.getSavedUser();
            Log.e("USER_STORE", ""+user);
            if (user != null && user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
                Intent intent = new Intent(LoginActivity.this, GestionProductActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Cet utilisateur n'existe pas en base", Toast.LENGTH_SHORT).show();
            }
        }
    }
}