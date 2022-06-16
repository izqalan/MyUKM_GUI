/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.izqalan.myukm.controllers;

import dev.izqalan.myukm.models.MedicalModel;
import dev.izqalan.myukm.models.UserModel;
import dev.izqalan.myukm.views.AppointmentHistoryView;
import dev.izqalan.myukm.views.EwalletView;
import dev.izqalan.myukm.views.LoginView;
import dev.izqalan.myukm.views.MainMenu;
import dev.izqalan.myukm.views.MedicalMenuView;
import dev.izqalan.myukm.views.MedicalScreenView;
import dev.izqalan.myukm.views.ServiceScreenView;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;

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

    public static void seed() {
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
        try {
            if (usersList.containsKey(email) && usersList.get(email).getPassword().equals(password)) {
                user.setCurrentUser(new UserModel(email, password));
            }
        } catch (Error e) {
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
        } catch (Error e) {
            return false;
        }
        return true;
    }

    public void viewMainMenu(JFrame currentFrame) {
        currentFrame.dispose();
        new MainMenu();
    }
    
    public void viewEwalletMenu(JFrame currentFrame) {
        currentFrame.dispose();
        new EwalletView(this);
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
}
