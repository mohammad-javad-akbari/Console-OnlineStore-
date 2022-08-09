package com.database;

import com.models.Cart;

import java.util.List;

public class CartDatabase extends DatabaseAccess<Cart> {

    public CartDatabase() {
        super();
    }

    @Override
    public boolean save(Cart cart) {
        return false;
    }

    @Override
    public Cart get(int id) {
        return null;
    }

    @Override
    public List<Cart> getAll() {
        return null;
    }
}
