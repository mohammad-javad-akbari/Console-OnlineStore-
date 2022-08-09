package com.models;

public class Category {
    private int id;
    private String title;
    private int cat_productId;

    public Category(int id, String title, int cat_productId) {
        this.id = id;
        this.title = title;
        this.cat_productId = cat_productId;
    }

    public Category(String title, int cat_productId) {
        this.title = title;
        this.cat_productId = cat_productId;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCat_productId() {
        return cat_productId;
    }

    public void setCat_productId(int cat_productId) {
        this.cat_productId = cat_productId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cat_productId=" + cat_productId +
                '}';
    }
}
