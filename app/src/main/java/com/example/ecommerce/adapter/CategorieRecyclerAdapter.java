package com.example.ecommerce.adapter;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.R;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.utils.GlideApp;

import java.util.ArrayList;


public class CategorieRecyclerAdapter extends RecyclerView.Adapter<CategorieRecyclerAdapter.RecyclerViewHolder>{

    private final CategorieItemClickListener categorieItemClickListener;
    private ArrayList<Category> arrayList = new ArrayList<Category>();
    private Context ctx;

    public CategorieRecyclerAdapter(ArrayList<Category> arrayList, Context ctx, CategorieItemClickListener categorieItemClickListener){

        this.arrayList = arrayList;
        this.ctx = ctx;
        this.categorieItemClickListener = categorieItemClickListener;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categorie, parent,false);
        return new RecyclerViewHolder(view, ctx);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
        if(arrayList.isEmpty()){
            //Nothing to do
        } else {
            final Category category = arrayList.get(position);
            if(category != null) {

                GlideApp.with(this.ctx).load(category.getUrlPhoto())
                        .placeholder(R.drawable.mode)
                        .into(holder.img_avatar);

                holder.name.setText(category.getName());

                ViewCompat.setTransitionName(holder.img_avatar, "img_avatar");

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        categorieItemClickListener.onCategoryItemClick(holder.getAdapterPosition(), category);
                    }
                });


            }
        }
    }
    

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView img_avatar;
        TextView name;
        Context ctx;

        public RecyclerViewHolder(View view, Context ctx) {

            super(view);
            this.ctx = ctx;
            img_avatar = view.findViewById(R.id.img_categorie);
            name = view.findViewById(R.id.name);
        }

    }

}
