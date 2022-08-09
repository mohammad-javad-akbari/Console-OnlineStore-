package com.database;

import com.models.User;
import com.models.UserAuthentication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserAuthenticationDatabase extends DatabaseAccess<UserAuthentication> {

    public UserAuthenticationDatabase() {
        super();
    }

    @Override
    public boolean save(UserAuthentication userAuthentication) {
        try {
            Statement statement = getConnection().createStatement();
            String query = "INSERT INTO `online_store`.`user_authentication`(`user_name`,`user_password`,`api_token`)VALUES('%s','%s','%s');";
            query = String.format(query,userAuthentication.getUserName(),userAuthentication.getPassword(),userAuthentication.getApi_token());

            return statement.executeUpdate(query) == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public UserAuthentication get(int id) {
        return null;
    }

    @Override
    public List<UserAuthentication> getAll() {
        return null;
    }


    public UserAuthentication getUserAuthentication(String userName,String password) {

        try {
            Statement statement = getConnection().createStatement();

            String query = "select * from online_store.user_authentication where user_name='%s' and user_password='%s'";
            query = String.format(query,userName,password);

            ResultSet resultSet = statement.executeQuery(query);

            UserAuthentication userAuthentication = null;
            if (resultSet.next()) {

                int id = resultSet.getInt(resultSet.findColumn("id"));
                String user_name = resultSet.getString(resultSet.findColumn("user_name"));
                String user_password = resultSet.getString(resultSet.findColumn("user_password"));
                String api_token = resultSet.getString(resultSet.findColumn("api_token"));

                userAuthentication = new UserAuthentication(id,user_name,user_password,api_token);
            }

            return userAuthentication;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean apiTokenValidation(String apiToken) {
        String query = "select api_token from online_store.user_authentication where api_token = '%s'";
        query = String.format(query, apiToken);

        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return !resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

}