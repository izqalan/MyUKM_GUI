/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.izqalan.myukm.controllers;

import dev.izqalan.myukm.models.MedicalModel;
import dev.izqalan.myukm.models.PaymentModel;
import dev.izqalan.myukm.models.UserModel;
import dev.izqalan.myukm.views.AddBalanceView;
import dev.izqalan.myukm.views.AppointmentHistoryView;
import dev.izqalan.myukm.views.EwalletView;
import dev.izqalan.myukm.views.LoginView;
import dev.izqalan.myukm.views.MainMenu;
import dev.izqalan.myukm.views.MedicalMenuView;
import dev.izqalan.myukm.views.MedicalScreenView;
import dev.izqalan.myukm.views.PaymentHistoryView;
import dev.izqalan.myukm.views.PaymentView;
import dev.izqalan.myukm.views.RegisterView;
import dev.izqalan.myukm.views.SearchBookView;
//import dev.izqalan.myukm.views.QRScannerView;
import dev.izqalan.myukm.views.ServiceScreenView;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Izqalan, Peggy, Lam
 */
public class AppController {

    public UserModel user = new UserModel();
    public static HashMap<String, UserModel> usersList = new HashMap<>();
    ArrayList<PaymentModel> transactionList = new ArrayList<>(); 
    
    public static void run() {
        LoginView loginView = new LoginView();
        AppController.seed();
        loginView.run();
    }

    public static void seed() {
        String email = "admin";
        String password = "admin";
        double balance = 21.00;
        UserModel permaUser = new UserModel(email, password, balance);
        usersList.put(email, permaUser);
    }

    /**
     * @param email
     * @param password
     * @return true if login success else false
     */
    public boolean login(String email, String password) {
        try {
            System.out.println(usersList.containsKey(email));
            System.out.println(usersList.get(email).getPassword().equals(password));
            if (usersList.containsKey(email) && usersList.get(email).getPassword().equals(password)) {
                user.setCurrentUser(usersList.get(email));
                return true;
            }
        } catch (Error e) {
            
        }
        return false;
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
        } catch (Error e) {
            return false;
        }
        return true;
    }
    
    public void showRegisterView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new RegisterView(app);
    }
    
    public void showLoginView(JFrame currentFrame, AppController app){
        currentFrame.dispose();
        new LoginView(app);
    }

    public void viewMainMenu(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new MainMenu(app);
    }
    
    public void showLibraryView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new SearchBookView(app);
    }

    public void showEwalletMenu(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new EwalletView(app);
    }

    //medical
    public static ArrayList<String> appointmentdate = new ArrayList<String>();//create arraylist for appointment
    public static ArrayList<String> appointmenttime = new ArrayList<String>();
    public static ArrayList<String> appointmenttype = new ArrayList<String>();
    static MedicalMenuView medicalMenuframe = new MedicalMenuView();
    static AppController controller = new AppController();
    static ServiceScreenView servicescreen = new ServiceScreenView(controller);
    static MedicalScreenView medicalScreen = new MedicalScreenView();
    private static MedicalModel medicalModel = new MedicalModel();
    static AppointmentHistoryView appointmentHistoryScreen = new AppointmentHistoryView(controller);
    public static String servicetype;

    public static void MedicalMenuScreenShow() {
        medicalMenuframe.setVisible(true);
    }

    public static void MedicalMenuScreenDispose() {
        medicalMenuframe.dispose();
    }

    public static void ServiceScreenShow() {
        servicescreen.run();
    }

    public static void ServiceScreenDispose() {
        ServiceScreenView.frame.dispose();
    }

    public static void MedicalScreenDispose() {
        medicalScreen.dispose();
    }

    public static void appoinmentHistoryShow() {
        appointmentHistoryScreen.run();
    }

    public static void appoinmentHistoryDispose() {
        appointmentHistoryScreen.frame.dispose();
    }

    public static void setService(String test) {
        //System.out.println(test);
        medicalModel.setService(test);
        servicetype = test;
        getService();
    }

    public static void getService() {
        System.out.print(medicalModel.getService());
    }

    public static void runMedical() {
        medicalScreen.setVisible(true);
    }

    public static void addDateArray(String dateValue) {
        medicalModel.addDateArray(dateValue);
    }

    public static void addTimeArray(String timeValue) {
        medicalModel.addTimeArray(timeValue);
    }

    public static void addServiceArray(String serviceValue) {
        medicalModel.addServiceArray(serviceValue);
    }

    public static ArrayList<String> getDateArray() {
        return medicalModel.getDate();
        //return medicalScreen.getDateList();
    }

    public static ArrayList<String> getServiceArray() {
        return medicalScreen.getServiceList();
    }

    public static ArrayList<String> getTimeArray() {
        return medicalModel.getTime();
        //return medicalScreen.getTimeList();
    }

    public UserModel getCurrentUser() {
        return user.getCurrentUser();
    }
    
    public void setCurrentUser(UserModel u) {
        user.setCurrentUser(u);
    };

    public void showAddBalanceView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new AddBalanceView(app);
    }

//    public void showQRScannerView(JFrame currentFrame, AppController app, double amount) {
//        currentFrame.dispose();
//        new QRScannerView(app, amount);
//    }

    public void showPaymentView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new PaymentView(app);
    }
    
    public void showTransactionHistoryView(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new PaymentHistoryView(app);
    }

    public boolean deductFunds(double amount, UUID id, String destination, LocalDateTime createdAt){
        try {
            if (user.getCurrentUser().getBalance() >= amount){
                user.setBalance(user.getCurrentUser().getBalance() - amount);
                transactionList.add(new PaymentModel(amount, id, destination, createdAt));
                
            } else {
                throw new Error("Insufficient funds");
            }
            user.setCurrentUser(user);
        } catch (Error e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public boolean addFunds(double amount) {
        try {
            user.setBalance(user.getCurrentUser().getBalance() + amount);
            user.setCurrentUser(user);
        } catch (Error e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public ArrayList getTransactionList() {
        return transactionList;
    }
    
    public Object[] getTransactionDetails(){
        Object[] data = this.transactionList.toArray();
        return data;
    }
    public void loadTransactionList(DefaultTableModel model){
        for(int i = 0; i < this.transactionList.size(); i++){
            System.out.println(this.transactionList.get(i).getPrice());
            UUID id = this.transactionList.get(i).getId();
            double amount = this.transactionList.get(i).getPrice();
            String to = this.transactionList.get(i).getToWhom();
            String createdAt = this.transactionList.get(i).getCreatedAt().toString();
            
            Object[] rowData = {id, amount, to, createdAt};
            model.addRow(rowData);
        }
    }
}
