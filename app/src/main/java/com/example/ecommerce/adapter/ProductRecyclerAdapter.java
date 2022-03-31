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

import com.bumptech.glide.Glide;
import com.example.ecommerce.R;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.utils.GlideApp;

import java.util.ArrayList;


public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.RecyclerViewHolder>{

    private final ProductItemClickListener productItemClickListener;
    private ArrayList<Product> arrayList = new ArrayList<Product>();
    private Context ctx;

    public ProductRecyclerAdapter(ArrayList<Product> arrayList, Context ctx, ProductItemClickListener productItemClickListener){

        this.arrayList = arrayList;
        this.ctx = ctx;
        this.productItemClickListener = productItemClickListener;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent,false);
        return new RecyclerViewHolder(view, ctx);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
        if(arrayList.isEmpty()){
            //Nothing to do
        }else {
            final Product product = arrayList.get(position);
            if(product != null) {

                GlideApp.with(this.ctx)
                        .load(product.getUrlPhoto())
                        .centerCrop()
                        .placeholder(R.drawable.nutella)
                        .into(holder.img_product);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        productItemClickListener.onProductItemClick(holder.getAdapterPosition(), product, holder.detail_product);
                    }
                });

                holder.name.setText(product.getName());
                holder.price.setText(product.getPrice() + " FCFA");
                holder.description.setText(product.getDescription());
                if (product.isInStock()) {
                    holder.is_in_stock.setText("En stock");
                    holder.is_in_stock.setTextColor(ctx.getResources().getColor(R.color.green));
                } else {
                    holder.is_in_stock.setText("Non disponoble");
                    holder.is_in_stock.setTextColor(ctx.getResources().getColor(R.color.colorred));
                }


            }
        }
    }
    

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView img_product;
        TextView is_in_stock;
        TextView price;
        TextView description;
        TextView name;
        View detail_product;
        Context ctx;

        public RecyclerViewHolder(View view, Context ctx) {

            super(view);
            this.ctx = ctx;
            img_product = view.findViewById(R.id.img_product);
            is_in_stock = view.findViewById(R.id.is_in_stock);
            price = view.findViewById(R.id.price);
            description = view.findViewById(R.id.description);
            detail_product = view.findViewById(R.id.detail_product);
            name = view.findViewById(R.id.name);

        }

    }

}
