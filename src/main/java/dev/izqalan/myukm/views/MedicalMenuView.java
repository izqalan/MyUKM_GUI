package dev.izqalan.myukm.views;

import dev.izqalan.myukm.controllers.AppController;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MedicalMenuView extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    static AppController controller;
    /**
     * Create the frame.
     */
    public MedicalMenuView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 261);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("Make Medical Appointment");
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.ServiceScreenShow();
                controller.MedicalMenuScreenDispose();
            }
        });
        //btnNewButton.setBackground(Color.decode("#44a6c6"));
        //btnNewButton.setForeground(Color.decode("#44a6c6"));
        btnNewButton.setBounds(93, 57, 233, 34);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Cancel Medical Appointment");
        btnNewButton_1.setForeground(Color.BLACK);
        //btnNewButton_1.setBackground(Color.decode("#ff8a66"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.appoinmentHistoryShow();
                controller.MedicalMenuScreenDispose();
            }
        });
        btnNewButton_1.setBounds(93, 116, 233, 34);
        panel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Main Menu");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.MedicalMenuScreenDispose();
            }
        });
        //btnNewButton_2.setBackground(Color.decode("#6dfc93"));
        btnNewButton_2.setBounds(151, 192, 110, 34);
        panel.add(btnNewButton_2);
    }
}
