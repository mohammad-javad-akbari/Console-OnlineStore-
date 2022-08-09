package com.database;

import com.models.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDatabase extends DatabaseAccess<Category>{

    public CategoryDatabase() {
        super();
    }

    @Override
    public boolean save(Category category) {
        return false;
    }

    @Override
    public Category get(int id) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    public List<Category> getCategoriesByProductId(int productId) {
        List<Category> categories = new ArrayList<>();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM online_store.category where cat_product_id='%s' order by id asc;";
            query = String.format(query,productId+"");

            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                //get index of column in table resultSet
                int idIndex = resultSet.findColumn("id");
                //get content of id
                int id = resultSet.getInt(idIndex);

                String title = resultSet.getString(resultSet.findColumn("title"));

                int cat_product_id = resultSet.getInt(resultSet.findColumn("cat_product_id"));

                categories.add(new Category(id,title,cat_product_id));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return categories;
    }

}
