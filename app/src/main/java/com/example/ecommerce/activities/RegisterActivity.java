package com.example.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

public class RegisterActivity extends AppCompatActivity {

    private TextView txt_email;
    private TextView txt_name;
    private TextView txt_password;
    private SessionManager sessionManager;
    private Button btn_register;
    private ImageView btn_retour;
    private View to_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sessionManager = new SessionManager(this);

        bindViews();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bindViews() {
        txt_name = findViewById(R.id.txt_name);
        txt_email = findViewById(R.id.txt_email);
        txt_password = findViewById(R.id.txt_password);
        btn_register = findViewById(R.id.btn_register);
        btn_retour = findViewById(R.id.ic_btn_retour);
        to_login = findViewById(R.id.to_login);
    }

    private void signUp() {
        String name = txt_name.getText().toString();
        String email = txt_email.getText().toString().trim();
        String password = txt_password.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            txt_name.setError("Ce champ est obligatoire");
        } else if (TextUtils.isEmpty(email)) {
            txt_email.setError("Ce champ est obligatoire");
        } else if (TextUtils.isEmpty(password)) {
            txt_password.setError("Ce champ est obligatoire");
        } else {
            User user = sessionManager.getSavedUser();
            if (user != null && email.equalsIgnoreCase(user.getEmail()) && password.equalsIgnoreCase(user.getPassword())) {
                Toast.makeText(RegisterActivity.this, "Cet utilisateur existe en base", Toast.LENGTH_SHORT).show();
            } else {
                User newUser = new User(UUID.randomUUID().toString(), email, password, name);
                sessionManager.saveUser(newUser);
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                    }
                }, 500);

            }
        }
    }
}