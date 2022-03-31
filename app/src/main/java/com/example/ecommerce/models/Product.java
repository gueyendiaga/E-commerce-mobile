package com.example.ecommerce.models;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String description;
    private int price;
    private int urlPhoto;
    private int qty;
    private String uid;
    private String categorieId;
    private boolean isInStock;

    public Product(String name, String description, int price, int urlPhoto, int qty, String uid,  String categorieId, boolean isInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.urlPhoto = urlPhoto;
        this.qty = qty;
        this.uid = uid;
        this.categorieId = categorieId;
        this.isInStock = isInStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(int urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public String getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(String categorieId) {
        this.categorieId = categorieId;
    }
}
