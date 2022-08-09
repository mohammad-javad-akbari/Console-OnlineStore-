package com.models;

import java.util.List;

public class Product {
    private int id;
    private int productCode;
    private double price;
    private double priceInOff;
    private String color;
    private String brand;
    private String name;
    private String productDescription;
    private List<Category> categories;

    public Product(int id, int productCode, double price, double priceInOff, String color, String brand, String name,List<Category> categories,String productDescription) {
        this.id = id;
        this.productCode = productCode;
        this.price = price;
        this.priceInOff = priceInOff;
        this.color = color;
        this.brand = brand;
        this.name = name;
        this.categories = categories;
        this.productDescription = productDescription;
    }

    public Product(int productCode, double price, double priceInOff, String color, String brand, String name,List<Category> categories,String productDescription) {
        this.productCode = productCode;
        this.price = price;
        this.priceInOff = priceInOff;
        this.color = color;
        this.brand = brand;
        this.name = name;
        this.categories = categories;
        this.productDescription = productDescription;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceInOff() {
        return priceInOff;
    }

    public void setPriceInOff(double priceInOff) {
        this.priceInOff = priceInOff;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode=" + productCode +
                ", price=" + price +
                ", priceInOff=" + priceInOff +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", categories=" + categories +
                '}';
    }
}
