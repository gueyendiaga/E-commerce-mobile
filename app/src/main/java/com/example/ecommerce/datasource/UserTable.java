package com.example.ecommerce.datasource;

import com.example.ecommerce.R;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.models.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class UserTable {

    public static final ArrayList<Product> allProducts = new ArrayList<>(
            Arrays.asList(
                    new Product("Nutella Biscuits Resealable Bag", "The only cookie with a creamy heart of Nutella, made to share with those you love.", 6000, R.drawable.nutella, 5, "p1","c2", true),
                    new Product("Hamburgers", "Panda Grill draws fans with its fresh burgers, fries, customer-favorite chicken teriyaki and its own special bread.", 3000, R.drawable.hamburgers, 15, "p2","c2", false),
                    new Product("Lunettes de soleil", "Description Lunettes photogray antireflet pour homme et femme", 25000, R.drawable.lunette, 20, "p3","c1",  true),
                    new Product("Omelette for breakfast", "Enjoy an omelette for breakfast, brunch, or dinner - they're so easy to make at home, versatile", 2000, R.drawable.omelette, 8, "p4", "c2",false),
                    new Product("Iphone 13  pro Max", "Apple iPhone 13 to be built by Foxconn and Pegatron, Pro's bigger camera confirmed once more", 1000000, R.drawable.iphone_13, 10, "p5","c3", true),
                    new Product("Chemise Homme Bleue", "chemise homme bleue doublure pied de poule (double retors)", 12000, R.drawable.chemise, 35, "p6","c5", false),
                    new Product("Mac pro 2020", "Apple M1 chip with 8‑core CPU, 8‑core GPU,  13-inch  Magic Keyboard USB 4 ports", 1300000, R.drawable.mac, 35, "p6","c4", false),
                    new Product("Mac pro 2029", "Apple's laptops are comprised of a 13-inch MacBook Air and 13-inch and 16-inch MacBook Pro models. ", 1100000, R.drawable.mac1, 35, "p6","c4", false),
                    new Product("T-Shirt", "Blank Tshirt Pictures | Download Free Images on Unsplash", 5000, R.drawable.tshirt, 5, "p6","c5", false)
            )
    );

    public static final ArrayList<Category> allCategories = new ArrayList<>(
            Arrays.asList(
                    new Category("c1", "Santé && Beauté",R.drawable.health),
                    new Category("c2", "Supermarché",R.drawable.market),
                    new Category("c3","Téléphones",R.drawable.phone),
                    new Category("c4", "Informatique",R.drawable.laptop),
                    new Category("c5", "Mode",R.drawable.mode)
            )
    );
}
