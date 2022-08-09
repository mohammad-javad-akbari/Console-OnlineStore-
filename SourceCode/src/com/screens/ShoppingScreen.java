package com.screens;

import com.database.ProductDatabase;
import com.models.Product;

import java.util.List;

public class ShoppingScreen {

    public static void main(String[] args) {
        ProductDatabase productDatabase = new ProductDatabase();

        List<Product> products = productDatabase.getAll();

        System.out.println(products);

    }

}
