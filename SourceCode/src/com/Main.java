package com;

import com.database.UserAuthenticationDatabase;
import com.database.UserDatabase;
import com.models.Cart;
import com.models.Product;
import com.models.User;
import com.models.UserAuthentication;
import com.screens.CartScreen;
import com.screens.FavoriteScreen;
import com.screens.SearchScreen;
import com.screens.ShoppingScreen;

import java.util.Random;
import java.util.Scanner;

public class Main {

    UserAuthenticationDatabase userAuthenticationDatabase;

    private UserAuthentication loginAuthentication;

    public static void main(String[] args) {
        /*Main main = new Main();
        Scanner scanner = new Scanner(System.in); //for get input from user
        UserDatabase userDatabase = new UserDatabase(); // communication with user table in database
        main.userAuthenticationDatabase = new UserAuthenticationDatabase(); // for authentication operation in database

        System.out.println("welcome to my store ");

        System.out.println("enter your userName:");
        String userName = scanner.next();

        System.out.println("enter your password:");
        String password = scanner.next();

        //check that is there this userName and password in database ?
        UserAuthentication userAuthentication = main.userAuthenticationDatabase.getUserAuthentication(userName, password);

        //register
        if (userAuthentication == null) {
            System.out.println("there is no user with this userName and password.\nplease register first");

            boolean allSavingSuccessfully = true;

            //1.get user info from user
            User user = main.getUserInfo();
            //2.add userAuthentication into database
            UserAuthentication userAuthentication1 = new UserAuthentication(userName,password,user.getApi_token());
            boolean savedSuccessfully__userAuthentication = main.userAuthenticationDatabase.save(userAuthentication1);
            if (savedSuccessfully__userAuthentication == false) {
                System.out.println("error while user authentication saving.");
                allSavingSuccessfully = !savedSuccessfully__userAuthentication ? false : true;
            }
            //3.add user into database
            boolean savedSuccessfully = userDatabase.save(user);
            if (savedSuccessfully == false) {
                System.out.println("error while saving user into db.");
                allSavingSuccessfully = !savedSuccessfully ? false : true;
            }

            if (!allSavingSuccessfully) {
                System.out.println("we are so sorry for you.\n\tan error accord while saving data into database");
            } else {
                System.out.println("saving successfully done");
                System.out.println("user:\t"+userAuthentication1+"\n"+user);
            }

            //4.login app => login app means saving authentication info(id,apiToken)
            main.loginAuthentication = main.userAuthenticationDatabase.getUserAuthentication(userAuthentication1.getUserName(),userAuthentication1.getPassword());
        }
        //login
        else {
            //save authentication info => save id and apiToken
            main.loginAuthentication = userAuthentication;
        }

        System.out.println("what is operation who wanna do?");
        System.out.println("1. Order or add to your favorite list a product => Navigate to ShoppingScreen\n" +
                "2. Search from products in shop => Navigate to SearchScreen\n" +
                "3. View Products in Cart => Navigate to CartScreen\n" +
                "4. View Products in Favorite List => Navigate to FavoriteScreen\n");
        int itemNo = main.getNumber(1,4);
        switch (itemNo) {
            case 1:
                ShoppingScreen.main(args);
                break;

            case 2:
                SearchScreen.main(args);
                break;

            case 3:
                CartScreen.main(args);
                break;

            case 4:
                FavoriteScreen.main(args);
                break;
        }
*/


    }



    private boolean isRegexCorrect(String inputValue, String regex) {
        return inputValue.matches(regex);
    }

    private User getUserInfo() {
        Scanner scanner = new Scanner(System.in);

        String name = "";
        do {
            System.out.println("enter your name: ");
            name = scanner.next();
        } while (!isRegexCorrect(name, "[a-zA-Z]*"));

        String family = "";
        do {
            System.out.println("enter your family: ");
            family = scanner.next();
        } while (!isRegexCorrect(family, "[a-zA-Z]*"));

        String email = "";
        do {
            System.out.println("enter your email: ");
            email = scanner.next();
        } while (!isRegexCorrect(email, "[a-zA-Z0-9 .@_]*"));

        String phone = "";
        do {
            System.out.println("enter your phone: ");
            phone = scanner.next();
        } while (!isRegexCorrect(phone, "[0-9+]*"));


        String apiToken = getApiToken();
        return new User(apiToken,name,family,email,phone);
    }

    private String getApiToken() {
        Random random = new Random();
        char[] allowedChars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '@', '#', '$', '%', '^', '&',
                '*', '(', ')', '_', '-'};
        String apiToken = "";

        boolean isApiTokenUnique = false;
        while (isApiTokenUnique == false) {
            for (int i = 0; i < 20; i++) {
                int randomIndex = random.nextInt(allowedChars.length);
                apiToken = apiToken + allowedChars[randomIndex];
            }

            isApiTokenUnique = userAuthenticationDatabase.apiTokenValidation(apiToken);
        }
        return apiToken;
    }

    private int getNumber(int min,int max) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            number = scanner.nextInt();

            if (number < min || number > max) {
                System.out.println("Enter your number in range. ");
            }

        }while (number < min || number > max);

        return number;
    }

}