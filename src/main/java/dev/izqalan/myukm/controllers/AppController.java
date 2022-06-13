/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.izqalan.myukm.controllers;

import dev.izqalan.myukm.models.UserModel;
import dev.izqalan.myukm.views.LoginView;
import dev.izqalan.myukm.views.MainMenu;
import java.util.HashMap;

/**
 *
 * @author Izqalan, Peggy, Lam
 */
public class AppController {

    UserModel user = new UserModel();
    public static HashMap<String, UserModel> usersList = new HashMap<>();
    
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        AppController.seed();
        loginView.run();
    }
    
    
    public static void seed(){
        String email = "admin";
        String password = "admin";
        UserModel permaUser = new UserModel(email, password);
        usersList.put(email, permaUser);
    }

    /**
     * @param email
     * @param password
     * @return true if login success else false
     */
    public boolean login(String email, String password) {
        try{
            if (usersList.containsKey(email) && usersList.get(email).getPassword().equals(password)){
                user.setCurrentUser(new UserModel(email, password));
            }
        } catch (Error e){
            return false;
        }
        return true;
    }

    /**
     * @param email
     * @param password
     * @return true if registration successful else false
     */
    public boolean register(String email, String password) {
        try {
            user.setEmail(email);
            user.setPassword(password);
            // save user in local memory
            usersList.put(email, user);
        } catch (Error e){
            return false;
        }
        return true;
    }
    
    public void viewMainMenu(){
        new MainMenu();
    }
}
