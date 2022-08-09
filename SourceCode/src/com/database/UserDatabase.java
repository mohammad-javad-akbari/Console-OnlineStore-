package com.database;

import com.models.User;
import com.models.UserAuthentication;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDatabase extends DatabaseAccess<User> {

    public UserDatabase() {
        super();
    }

    @Override
    public boolean save(User user) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO `online_store`.`user`(`apiToken`,`name`,`family`,`email`,`phone`)VALUES('%s','%s','%s','%s','%s');";
            query = String.format(query,user.getApi_token(),user.getName(),user.getFamily(),user.getEmail(),user.getPhone());

            boolean executedSuccessfully = statement.executeUpdate(query) == 1;
            return executedSuccessfully;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

//    public User getUser(UserAuthentication userAuthentication) {
//
//        try {
//            Statement statement = getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT ");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
