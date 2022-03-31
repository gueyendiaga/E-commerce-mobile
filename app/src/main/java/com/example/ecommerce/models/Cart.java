package com.example.ecommerce.models;

import java.io.Serializable;

public class Cart implements Serializable {
    private String productUid;
    private String productName;
    private int prix;
    private int count;
    private int urlPhoto;

    public Cart(String productUid, String productName, int prix, int count, int urlPhoto) {
        this.productUid = productUid;
        this.productName = productName;
        this.prix = prix;
        this.count = count;
        this.urlPhoto = urlPhoto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getProductUid() {
        return productUid;
    }

    public void setProductUid(String productUid) {
        this.productUid = productUid;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(int urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
