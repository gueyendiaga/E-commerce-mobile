package com.example.ecommerce.models;

import java.io.Serializable;

public class Category implements Serializable {
    private String uid;
    private String name;
    private int urlPhoto;

    public Category(String uid, String name, int urlPhoto) {
        this.uid = uid;
        this.name = name;
        this.urlPhoto = urlPhoto;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(int urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
