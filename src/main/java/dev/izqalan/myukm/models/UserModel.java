/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.izqalan.myukm.models;

/**
 *
 * @author Izqalan
 */
public class UserModel {
    
    private String email;
    private String password;
    private UserModel currentUser;
    private double balance;

    public UserModel() {
        this.balance = 0.00;
    }
    
    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
        this.balance = 0.00;
    }
    
    public UserModel(String email, String password, double balance) {
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public UserModel getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserModel currentUser) {
        this.currentUser = currentUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    
}
