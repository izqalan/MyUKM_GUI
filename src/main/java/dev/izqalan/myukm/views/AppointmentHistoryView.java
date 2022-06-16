/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dev.izqalan.myukm.views;

import dev.izqalan.myukm.controllers.AppController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

/**
 *
 * @author Izqalan
 */
public class AppointmentHistoryView extends javax.swing.JFrame implements ActionListener {

    List<JButton> buttonList = new ArrayList<JButton>();
    JTextArea textArea = new JTextArea();
    private JPanel contentPane;
    static AppController AppController;
    public static AppointmentHistoryView frame;
    int index;

    /**
     * Launch the application.
     */
    //public static void main(String[] args) {
    //EventQueue.invokeLater(new Runnable() {
    public void run() {
        try {

            frame = new AppointmentHistoryView(AppController);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //}
        //});
    }

    /**
     * Creates new form AppointmentHistoryView
     */
    public AppointmentHistoryView(AppController AppController) {
        JButton button;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Appointment History");
        lblNewLabel.setBounds(32, 11, 119, 14);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(32, 36, 319, 165);
        panel.add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel_1.add(scrollPane);
        scrollPane.setColumnHeaderView(textArea);
        textArea.setEditable(false);

        JPanel panel_2 = new JPanel();
        scrollPane.setViewportView(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
        panel_2.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (AppController.getDateArray().isEmpty()) {
            textArea.setText("No Appointment made");
        } else {
            /*ArrayList ArrList2= (ArrayList)AppController.getDateArray().clone();
			Map<String, String> map = new HashMap<String, String>();
			Map<String, String> map1 = new HashMap<String, String>();
			for(int i = 0; i < AppController.getDateArray().size(); i++) {
			  map.put(AppController.getDateArray().get(i), AppController.getTimeArray().get(i));   
			}
			
			for(int i = 0; i < AppController.getDateArray().size(); i++) {
				  map1.put(AppController.getDateArray().get(i), AppController.getServiceArray().get(i));   
				}*/
            //Collections.sort(AppController.getDateArray());
            for (int i = 0; i < AppController.getDateArray().size(); i++) {
                button = new JButton(AppController.getServiceArray().get(i) + " \n " + AppController.getDateArray().get(i) + " \n " + AppController.getTimeArray().get(i));
                buttonList.add(button);
                panel_2.add(button);
                button.setPreferredSize(new Dimension(100, 100));
                //button.setName(String.valueOf(i));
                button.putClientProperty("page", i);
                button.addActionListener(this);
                //textArea.setText(); 		
                //System.out.println(AppController.getDateArray().get(i));
            }
            /*{
				public void actionPerformed(ActisonEvent e) {
					AppController.appointmentdate.remove((Integer)((JButton)e.getSource()).getClientProperty( "page" ));
					AppController.appointmenttime.remove((Integer)((JButton)e.getSource()).getClientProperty( "page" ));
					AppController.appointmenttype.remove((Integer)((JButton)e.getSource()).getClientProperty( "page" ));
				}
			});*/
        }

        JButton btnNewButton = new JButton("Back");
        //btnNewButton.setBackground(Color.decode("#ff8a66"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AppController.appoinmentHistoryDispose();
                AppController.MedicalMenuScreenShow();
            }
        });
        btnNewButton.setBounds(111, 212, 160, 23);
        panel.add(btnNewButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void actionPerformed(ActionEvent evt) {
        Object src = evt.getSource();

        for (int i = 0; i < AppController.getDateArray().size(); i++) {
            if (src == buttonList.get(i)) {
                //First button actions

                int n = JOptionPane.showConfirmDialog(frame, "Are you sure you want to cancel the " + AppController.appointmenttype.get(i) + " appointment " + AppController.appointmenttime.get(i) + " on " + AppController.appointmentdate.get(i) + "?", "Are you sure you want to cancel the" + AppController.appointmenttype.get(i) + " appointment " + AppController.appointmenttime.get(i) + " on " + AppController.appointmentdate.get(i) + "?", JOptionPane.YES_NO_OPTION);

                if (n == JOptionPane.YES_OPTION) {
                    AppController.appointmentdate.remove(i);
                    AppController.appointmenttime.remove(i);
                    AppController.appointmenttype.remove(i);
                    //buttonList.get(i++).putClientProperty("page", i); //change button display name?
                    // System.out.println("size"+AppController.getDateArray().size());
                    //System.out.println("now index"+i);

                    buttonList.get(i).setVisible(false);
                    if (AppController.getDateArray().isEmpty()) {
                        textArea.setText("No Appointment made");
                    }
                    AppController.appoinmentHistoryDispose();
                    AppController.appoinmentHistoryShow();

                }

            }
        }
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

