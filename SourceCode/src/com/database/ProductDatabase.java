package com.database;

import com.models.Category;
import com.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase extends DatabaseAccess<Product> {

    public ProductDatabase() {
        super();
    }

    @Override
    public boolean save(Product product) {
        return false;
    }

    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        CategoryDatabase categoryDatabase = new CategoryDatabase();

        //get connection from super class
        Connection connection = getConnection();
        try {
            //create statement from connection
            Statement statement = connection.createStatement();

            //select products from database
            String query = "SELECT * FROM online_store.product;";
            ResultSet resultSet = statement.executeQuery(query);

            //get products from ResultSet and put them into List Of Product
            List<Product> products = new ArrayList<>();

            while (resultSet.next()) {
                int columnIdIndex = resultSet.findColumn("id");
                int id = resultSet.getInt(columnIdIndex);

                int columnNameIndex = resultSet.findColumn("name");
                String name = resultSet.getString(columnNameIndex);

                int productCode = resultSet.getInt(resultSet.findColumn("product_code"));

                double price = resultSet.getDouble(resultSet.findColumn("price"));
                String color = resultSet.getString(resultSet.findColumn("color"));
                String brand = resultSet.getString(resultSet.findColumn("brand"));
                double priceInOff = resultSet.getDouble(resultSet.findColumn("price_in_off"));
                String product_description = resultSet.getString(resultSet.findColumn("product_description"));

                List<Category> categories = categoryDatabase.getCategoriesByProductId(id);

                products.add(new Product(id,productCode,price,priceInOff,color,brand,name,categories,product_description));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

}