package com.example.ecommerce.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ecommerce.models.Cart;
import com.example.ecommerce.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SessionManager {
    int PRIVATE_MODE = 0;
    Context _context;
    SharedPreferences.Editor editor;
    SharedPreferences pref;

    public SessionManager(Context paramContext)
    {
        this._context = paramContext;
        this.pref = this._context.getSharedPreferences("EcomPref", this.PRIVATE_MODE);
        this.editor = this.pref.edit();
    }

    public void saveUser(User user){
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString("user", json);
        editor.commit();
    }

    public User getSavedUser(){
        Gson gson = new Gson();
        String json = pref.getString("user", null);
        return gson.fromJson(json, User.class);
    }

    public void saveCartList(ArrayList<Cart> tags){
        Gson gson = new Gson();
        Type type = new TypeToken<List<Cart>>(){}.getType();
        String json = gson.toJson(tags, type);
        editor.putString("cart", json);
        editor.commit();
    }

    public List<Cart> getSavedListCart(){
        Gson gson = new Gson();
        String json = pref.getString("cart", null);
        Type type = new TypeToken<List<Cart>>(){}.getType();
        return gson.fromJson(json, type);
    }
}
