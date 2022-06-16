/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.izqalan.myukm.models;

import dev.izqalan.myukm.controllers.AppController;
import java.util.ArrayList;

public class MedicalModel {
    //get medical service from first screen
    //return medical service to medicalScreen

    private String servicetype;

    public void setService(String serviceType) {
        servicetype = serviceType;
    }

    public String getService() {
        return servicetype;
    }

    public void addDateArray(String datevalue) {
        AppController.appointmentdate.add(datevalue);
    }

    public void addTimeArray(String timevalue) {
        AppController.appointmenttime.add(timevalue);
    }

    public void addServiceArray(String servicevalue) {
        AppController.appointmenttype.add(servicevalue);
    }

    public ArrayList<String> getDate() {
        return AppController.appointmentdate;
    }

    public ArrayList<String> getTime() {
        return AppController.appointmenttime;
    }
    //setDate

    //setTime
}
