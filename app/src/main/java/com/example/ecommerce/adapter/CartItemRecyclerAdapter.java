package com.example.ecommerce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.R;
import com.example.ecommerce.models.Cart;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.utils.GlideApp;

import java.util.ArrayList;


public class CartItemRecyclerAdapter extends RecyclerView.Adapter<CartItemRecyclerAdapter.RecyclerViewHolder>{

    private ArrayList<Cart> arrayList = new ArrayList<Cart>();
    private Context ctx;

    public CartItemRecyclerAdapter(ArrayList<Cart> arrayList, Context ctx){

        this.arrayList = arrayList;
        this.ctx = ctx;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent,false);
        return new RecyclerViewHolder(view, ctx);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
        if(arrayList.isEmpty()){
            //Nothing to do
        } else {
            final Cart itemCart = arrayList.get(position);
            if(itemCart != null) {

                GlideApp.with(this.ctx).load(itemCart.getUrlPhoto())
                        .placeholder(R.drawable.mode)
                        .into(holder.img_product);

                holder.name.setText(itemCart.getProductName());
                holder.price.setText(itemCart.getPrix() + " FCFA");
                holder.counter.setText(itemCart.getCount() + "");

            }
        }
    }
    

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView img_product;
        TextView name;
        TextView price;
        TextView counter;
        View minus, plus;
        Context ctx;

        public RecyclerViewHolder(View view, Context ctx) {

            super(view);
            this.ctx = ctx;
            img_product = view.findViewById(R.id.img_product);
            name = view.findViewById(R.id.name);
            price = view.findViewById(R.id.price);
            counter = view.findViewById(R.id.counter);
            minus = view.findViewById(R.id.minus);
            plus = view.findViewById(R.id.plus);
        }

    }

}
