/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.izqalan.myukm.views;

import dev.izqalan.myukm.controllers.AppController;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServiceScreenView extends JFrame {

    private JPanel contentPane;
    public String test;
    public static ServiceScreenView frame;
    static AppController controller;
    //private String getService;

    public ServiceScreenView(AppController controller) {
        //Controller controller=new Controller();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(24, 26, 370, 207);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Select service type");
        lblNewLabel.setBounds(34, 18, 100, 46);
        panel.add(lblNewLabel);

        Choice choice = new Choice();
        choice.setBounds(152, 33, 187, 20);
        choice.add("General");
        choice.add("Dental");
        choice.add("Specialist");
        panel.add(choice);

        JButton btnNewButton = new JButton("Next");
        //btnNewButton.setBackground(Color.decode("#44a6c6"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AppController.setService(choice.getSelectedItem());
                //test=choice.getSelectedItem();
                //controller.getService(choice.getSelectedItem());
                //System.out.print(choice.getSelectedItem());
                AppController.runMedical();
                AppController.ServiceScreenDispose();
            }
        });
        btnNewButton.setBounds(203, 87, 89, 23);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Back");
        //btnNewButton_1.setBackground(Color.decode("#ff8a66"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AppController.MedicalMenuScreenShow();
                AppController.ServiceScreenDispose();
            }
        });
        btnNewButton_1.setBounds(53, 87, 89, 23);
        panel.add(btnNewButton_1);
    }

    /**
     * Launch the application.
     */
    //public static void main(String[] args) {
    //EventQueue.invokeLater(new Runnable() {
    public void run() {
        try {

            frame = new ServiceScreenView(controller);
            //medicalScreens test=new medicalScreens(frame);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //	});
    //}
}
