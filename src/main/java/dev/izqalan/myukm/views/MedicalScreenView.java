/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.izqalan.myukm.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import dev.izqalan.myukm.controllers.AppController;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MedicalScreenView extends JFrame {
    //public ArrayList<String> appointmentdate=new ArrayList<String>();//create arraylist for appointment
    //public ArrayList<String> appointmenttime=new ArrayList<String>();
    //public ArrayList<String> appointmenttype=new ArrayList<String>();

    static AppController AppController;
    private JPanel contentPane;
    private String selectedTime;
    JPanel panel;
    JFrame frame1, frame, frame2, frame3;
    int checkclickbtn1, checkclickbtn4, checkclickbtn5, checkclickbtn6, checkclickbtn7, checkclickbtn8, checkclickbtn9, checkclickbtn10, checkclickbtn11;
    int checkcolorbtn1, checkcolorbtn4, checkcolorbtn5, checkcolorbtn6, checkcolorbtn7, checkcolorbtn8, checkcolorbtn9, checkcolorbtn10, checkcolorbtn11;

    /**
     * Launch the application.
     */
    //public static void main(String[] args) {
    //EventQueue.invokeLater(new Runnable() {
    public void run() {
        try {

            //serviceScreen service=new serviceScreen();
            //System.out.print("medicalScreen:");
            //AppController.getService();
            MedicalScreenView frame = new MedicalScreenView();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //});
    //}

    /**
     * Create the frame.
     */
    public MedicalScreenView() {

        frame1 = new JFrame("EZ-Book");
        frame1.getContentPane().setLayout(null);
        frame1.getContentPane().setBackground(Color.white);
        setTitle("Medical appointment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 452, 334);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.getCalendarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
            }
        });
        Date today = new Date();
        dateChooser.setMinSelectableDate(today);
        dateChooser.setBounds(120, 30, 185, 20);
        contentPane.add(dateChooser);

        panel = new JPanel();
        panel.setBounds(40, 92, 351, 158);
        contentPane.add(panel);
        panel.setLayout(null);
        panel.setVisible(false);

        JButton btnNewButton_1 = new JButton("09:00");
        btnNewButton_1.setBounds(10, 11, 65, 23);
        panel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("11:00");
        btnNewButton_2.setBounds(141, 11, 65, 23);
        panel.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("10:00");
        btnNewButton_3.setBounds(10, 79, 65, 23);
        panel.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("10:30");
        btnNewButton_4.setBounds(10, 113, 65, 23);
        panel.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("09:30");
        btnNewButton_5.setBounds(10, 45, 65, 23);
        panel.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("11:30");
        btnNewButton_6.setBounds(141, 45, 65, 23);
        panel.add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton("14:00");
        btnNewButton_7.setBounds(141, 79, 65, 23);
        panel.add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("14:30");
        btnNewButton_8.setBounds(141, 113, 65, 23);
        panel.add(btnNewButton_8);

        JButton btnNewButton_9 = new JButton("15:00");
        btnNewButton_9.setBounds(262, 11, 65, 23);
        panel.add(btnNewButton_9);

        JButton btnNewButton_10 = new JButton("15:30");
        btnNewButton_10.setBounds(262, 45, 65, 23);
        panel.add(btnNewButton_10);

        JButton btnNewButton_11 = new JButton("16:00");
        btnNewButton_11.setBounds(262, 79, 65, 23);
        panel.add(btnNewButton_11);

        JButton btnNewButton_12 = new JButton("16:30");
        btnNewButton_12.setBounds(262, 113, 65, 23);
        panel.add(btnNewButton_12);

        JLabel lblNewLabel = new JLabel("Select Date");
        lblNewLabel.setBounds(49, 30, 75, 20);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Select Time");
        lblNewLabel_1.setBounds(49, 76, 77, 14);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Next");
        //btnNewButton.setBackground(Color.decode("#44a6c6"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } //ady select date
                else {
                    ArrayList<Integer> getdateindex = new ArrayList<Integer>();
                    if (AppController.appointmentdate.isEmpty()) //user havent make any appointment yet
                    {
                        checkclickbtn1 = 0;
                        checkclickbtn4 = 0;
                        checkclickbtn5 = 0;
                        checkclickbtn6 = 0;
                        checkclickbtn7 = 0;
                        checkclickbtn8 = 0;
                        checkclickbtn9 = 0;
                        checkclickbtn10 = 0;
                        checkclickbtn11 = 0;
                        checkcolorbtn1 = 0;
                        checkcolorbtn4 = 0;
                        checkcolorbtn5 = 0;
                        checkcolorbtn6 = 0;
                        checkcolorbtn7 = 0;
                        checkcolorbtn8 = 0;
                        checkcolorbtn9 = 0;
                        checkcolorbtn10 = 0;
                        checkcolorbtn11 = 0;
                        //Button color for default
                        btnNewButton_1.setBackground(Color.GREEN);
                        btnNewButton_2.setBackground(Color.RED);
                        btnNewButton_3.setBackground(Color.RED);
                        btnNewButton_4.setBackground(Color.GREEN);
                        btnNewButton_5.setBackground(Color.GREEN);
                        btnNewButton_6.setBackground(Color.GREEN);
                        btnNewButton_7.setBackground(Color.GREEN);
                        btnNewButton_8.setBackground(Color.GREEN);
                        btnNewButton_9.setBackground(Color.GREEN);
                        btnNewButton_10.setBackground(Color.GREEN);
                        btnNewButton_11.setBackground(Color.GREEN);
                        btnNewButton_12.setBackground(Color.RED);
                        panel.setVisible(true);
                    } else //array got appointment
                    {
                        //check appointment made and make the button red
                        //check service then date then time

                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                        String dateOnly = dateFormat.format(dateChooser.getDate()); //user choose
                        for (int i = 0; i < AppController.appointmentdate.size(); i++) {
                            //same service and same date
                            if (AppController.appointmenttype.get(i).equals(AppController.servicetype) && AppController.appointmentdate.get(i).equals(dateOnly)) {
                                getdateindex.add(i);
                            }

                        }

                        //System.out.println(getdateindex);
                        //before havent make same service and date appointment
                        if (getdateindex.isEmpty()) {

                            btnNewButton_1.setBackground(Color.GREEN);
                            btnNewButton_2.setBackground(Color.RED);
                            btnNewButton_3.setBackground(Color.RED);
                            btnNewButton_4.setBackground(Color.GREEN);
                            btnNewButton_5.setBackground(Color.GREEN);
                            btnNewButton_6.setBackground(Color.GREEN);
                            btnNewButton_7.setBackground(Color.GREEN);
                            btnNewButton_8.setBackground(Color.GREEN);
                            btnNewButton_9.setBackground(Color.GREEN);
                            btnNewButton_10.setBackground(Color.GREEN);
                            btnNewButton_11.setBackground(Color.GREEN);
                            btnNewButton_12.setBackground(Color.RED);
                            panel.setVisible(true);
                            checkclickbtn1 = 0;
                            checkclickbtn4 = 0;
                            checkclickbtn5 = 0;
                            checkclickbtn6 = 0;
                            checkclickbtn7 = 0;
                            checkclickbtn8 = 0;
                            checkclickbtn9 = 0;
                            checkclickbtn10 = 0;
                            checkclickbtn11 = 0;
                        } else {
                            btnNewButton_1.setBackground(Color.GREEN);
                            btnNewButton_2.setBackground(Color.RED);
                            btnNewButton_3.setBackground(Color.RED);
                            btnNewButton_4.setBackground(Color.GREEN);
                            btnNewButton_5.setBackground(Color.GREEN);
                            btnNewButton_6.setBackground(Color.GREEN);
                            btnNewButton_7.setBackground(Color.GREEN);
                            btnNewButton_8.setBackground(Color.GREEN);
                            btnNewButton_9.setBackground(Color.GREEN);
                            btnNewButton_10.setBackground(Color.GREEN);
                            btnNewButton_11.setBackground(Color.GREEN);
                            btnNewButton_12.setBackground(Color.RED);
                            panel.setVisible(true);
                            checkclickbtn1 = 0;
                            checkclickbtn4 = 0;
                            checkclickbtn5 = 0;
                            checkclickbtn6 = 0;
                            checkclickbtn7 = 0;
                            checkclickbtn8 = 0;
                            checkclickbtn9 = 0;
                            checkclickbtn10 = 0;
                            checkclickbtn11 = 0;
                            for (int j = 0; j < getdateindex.size(); j++) {
                                panel.setVisible(true);
                                if (AppController.appointmenttime.get(getdateindex.get(j)).equals("09:00")) {
                                    btnNewButton_1.setBackground(Color.RED);
                                    checkclickbtn1 = 1;
                                } else if (AppController.appointmenttime.get(getdateindex.get(j)).equals("09:30")) {
                                    btnNewButton_5.setBackground(Color.RED);
                                    checkclickbtn5 = 1;
                                } else if (AppController.appointmenttime.get(getdateindex.get(j)).equals("10:30")) {
                                    btnNewButton_4.setBackground(Color.RED);
                                    checkclickbtn4 = 1;
                                } else if (AppController.appointmenttime.get(getdateindex.get(j)).equals("11:30")) {
                                    btnNewButton_6.setBackground(Color.RED);
                                    checkclickbtn6 = 1;
                                } else if (AppController.appointmenttime.get(getdateindex.get(j)).equals("14:00")) {
                                    btnNewButton_7.setBackground(Color.RED);
                                    checkclickbtn7 = 1;
                                } else if (AppController.appointmenttime.get(getdateindex.get(j)).equals("14:30")) {
                                    btnNewButton_8.setBackground(Color.RED);
                                    checkclickbtn8 = 1;
                                } else if (AppController.appointmenttime.get(getdateindex.get(j)).equals("15:00")) {
                                    btnNewButton_9.setBackground(Color.RED);
                                    checkclickbtn9 = 1;
                                } else if (AppController.appointmenttime.get(getdateindex.get(j)).equals("15:30")) {
                                    btnNewButton_10.setBackground(Color.RED);
                                    checkclickbtn10 = 1;
                                } else if (AppController.appointmenttime.get(getdateindex.get(j)).equals("16:00")) {
                                    btnNewButton_11.setBackground(Color.RED);
                                    checkclickbtn11 = 1;
                                }

                            }
                        }

                    }

                }

            }
        });
        btnNewButton.setBounds(328, 27, 75, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_13 = new JButton("Medical Menu");
        //btnNewButton_13.setBackground(Color.decode("#6dfc93"));
        btnNewButton_13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dateChooser.setCalendar(null);
                panel.setVisible(false);
                AppController.MedicalMenuScreenShow();
                AppController.MedicalScreenDispose();
            }
        });
        btnNewButton_13.setBounds(145, 261, 140, 23);
        contentPane.add(btnNewButton_13);

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } else {
                    btnNewButton_1.setOpaque(true);
                    selectedTime = "09:00";
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                    String dateOnly = dateFormat.format(dateChooser.getDate());

                    if (checkclickbtn1 == 0) {
                        btnNewButton_1.setBackground(Color.ORANGE);
                        int n = JOptionPane.showConfirmDialog(frame1, "You have selected " + selectedTime + " on " + dateOnly + ".", "You have selected " + selectedTime + " on " + dateOnly + ".", JOptionPane.YES_NO_OPTION);

                        if (n == JOptionPane.YES_OPTION) {
                            frame1.dispose();
                            AppController.addDateArray(dateOnly);
                            AppController.addTimeArray(selectedTime);
                            AppController.addServiceArray(AppController.servicetype);
                            JOptionPane.showMessageDialog(null, "Your appointment details : \n Service Type: " + AppController.servicetype + "\n Date: " + dateOnly + "\n Time: " + selectedTime);
                            checkclickbtn1++;
                            btnNewButton_1.setBackground(Color.RED);
                            //display arraylist

                        } else if (n == JOptionPane.NO_OPTION) {

                            btnNewButton_1.setBackground(Color.GREEN);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select another available time");
                    }

                }

            }
        });

        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select another available time");
                }
            }
        });

        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select another available time");
                }
            }
        });

        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } else {
                    if (checkclickbtn4 == 0) {
                        btnNewButton_4.setBackground(Color.ORANGE);
                        btnNewButton_4.setOpaque(true);
                        selectedTime = "10:30";
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                        String dateOnly = dateFormat.format(dateChooser.getDate());
                        int n = JOptionPane.showConfirmDialog(frame1, "You have selected " + selectedTime + " on " + dateOnly + ".", "You have selected " + selectedTime + " on " + dateOnly + ".", JOptionPane.YES_NO_OPTION);

                        if (n == JOptionPane.YES_OPTION) {
                            frame1.dispose();
                            AppController.addDateArray(dateOnly);
                            AppController.addTimeArray(selectedTime);
                            AppController.addServiceArray(AppController.servicetype);
                            JOptionPane.showMessageDialog(null, "Your appointment details : \n Service Type: " + AppController.servicetype + "\n Date: " + dateOnly + "\n Time: " + selectedTime);
                            /*System.out.println("Using For Loop\n ");
						      for (int i = 0; i < appointmentlist.size();i++) 
						      { 		      
						          System.out.println(appointmentlist.get(i)); 		
						      } */
                            btnNewButton_4.setBackground(Color.RED);
                            checkclickbtn4++;
                        } else if (n == JOptionPane.NO_OPTION) {

                            btnNewButton_4.setBackground(Color.GREEN);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select another available time");
                    }

                }
            }
        });

        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } else {
                    if (checkclickbtn5 == 0) {
                        btnNewButton_5.setBackground(Color.ORANGE);
                        btnNewButton_5.setOpaque(true);
                        selectedTime = "09:30";
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                        String dateOnly = dateFormat.format(dateChooser.getDate());
                        int n = JOptionPane.showConfirmDialog(frame1, "You have selected " + selectedTime + " on " + dateOnly + ".", "You have selected " + selectedTime + " on " + dateOnly + ".", JOptionPane.YES_NO_OPTION);

                        if (n == JOptionPane.YES_OPTION) {
                            frame1.dispose();
                            AppController.addDateArray(dateOnly);
                            AppController.addTimeArray(selectedTime);
                            AppController.addServiceArray(AppController.servicetype);
                            JOptionPane.showMessageDialog(null, "Your appointment details : \n Service Type: " + AppController.servicetype + "\n Date: " + dateOnly + "\n Time: " + selectedTime);
                            btnNewButton_5.setBackground(Color.RED);
                            checkclickbtn5++;
                        } else if (n == JOptionPane.NO_OPTION) {

                            btnNewButton_5.setBackground(Color.GREEN);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select another available time");
                    }

                }
            }
        });

        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } else {
                    if (checkclickbtn6 == 0) {
                        btnNewButton_6.setBackground(Color.ORANGE);
                        btnNewButton_6.setOpaque(true);
                        selectedTime = "11:30";
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                        String dateOnly = dateFormat.format(dateChooser.getDate());
                        int n = JOptionPane.showConfirmDialog(frame1, "You have selected " + selectedTime + " on " + dateOnly + ".", "You have selected " + selectedTime + " on " + dateOnly + ".", JOptionPane.YES_NO_OPTION);

                        if (n == JOptionPane.YES_OPTION) {
                            frame1.dispose();
                            AppController.addDateArray(dateOnly);
                            AppController.addTimeArray(selectedTime);
                            AppController.addServiceArray(AppController.servicetype);
                            JOptionPane.showMessageDialog(null, "Your appointment details : \n Service Type: " + AppController.servicetype + "\n Date: " + dateOnly + "\n Time: " + selectedTime);
                            btnNewButton_6.setBackground(Color.RED);
                            checkclickbtn6++;
                        } else if (n == JOptionPane.NO_OPTION) {

                            btnNewButton_6.setBackground(Color.GREEN);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select another available time");
                    }

                }

            }
        });

        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } else {
                    if (checkclickbtn7 == 0) {
                        btnNewButton_7.setBackground(Color.ORANGE);
                        btnNewButton_7.setOpaque(true);
                        selectedTime = "14:00";
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                        String dateOnly = dateFormat.format(dateChooser.getDate());
                        int n = JOptionPane.showConfirmDialog(frame1, "You have selected " + selectedTime + " on " + dateOnly + ".", "You have selected " + selectedTime + " on " + dateOnly + ".", JOptionPane.YES_NO_OPTION);

                        if (n == JOptionPane.YES_OPTION) {
                            frame1.dispose();
                            AppController.addDateArray(dateOnly);
                            AppController.addTimeArray(selectedTime);
                            AppController.addServiceArray(AppController.servicetype);
                            JOptionPane.showMessageDialog(null, "Your appointment details : \n Service Type: " + AppController.servicetype + "\n Date: " + dateOnly + "\n Time: " + selectedTime);
                            btnNewButton_7.setBackground(Color.RED);
                            checkclickbtn7++;
                        } else if (n == JOptionPane.NO_OPTION) {

                            btnNewButton_7.setBackground(Color.GREEN);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select another available time");
                    }

                }
            }
        });

        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } else {
                    if (checkclickbtn8 == 0) {
                        btnNewButton_8.setBackground(Color.ORANGE);
                        btnNewButton_8.setOpaque(true);
                        selectedTime = "14:30";
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                        String dateOnly = dateFormat.format(dateChooser.getDate());
                        int n = JOptionPane.showConfirmDialog(frame1, "You have selected " + selectedTime + " on " + dateOnly + ".", "You have selected " + selectedTime + " on " + dateOnly + ".", JOptionPane.YES_NO_OPTION);

                        if (n == JOptionPane.YES_OPTION) {
                            frame1.dispose();
                            AppController.addDateArray(dateOnly);
                            AppController.addTimeArray(selectedTime);
                            AppController.addServiceArray(AppController.servicetype);
                            JOptionPane.showMessageDialog(null, "Your appointment details : \n Service Type: " + AppController.servicetype + "\n Date: " + dateOnly + "\n Time: " + selectedTime);
                            btnNewButton_8.setBackground(Color.RED);
                            checkclickbtn8++;
                        } else if (n == JOptionPane.NO_OPTION) {

                            btnNewButton_8.setBackground(Color.GREEN);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select another available time");
                    }

                }
            }
        });

        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } else {
                    if (checkclickbtn9 == 0) {
                        btnNewButton_9.setBackground(Color.ORANGE);
                        btnNewButton_9.setOpaque(true);
                        selectedTime = "15:00";
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                        String dateOnly = dateFormat.format(dateChooser.getDate());
                        int n = JOptionPane.showConfirmDialog(frame1, "You have selected " + selectedTime + " on " + dateOnly + ".", "You have selected " + selectedTime + " on " + dateOnly + ".", JOptionPane.YES_NO_OPTION);

                        if (n == JOptionPane.YES_OPTION) {
                            frame1.dispose();
                            JOptionPane.showMessageDialog(null, "Your appointment details : \n Service Type: " + AppController.servicetype + "\n Date: " + dateOnly + "\n Time: " + selectedTime);
                            AppController.addDateArray(dateOnly);
                            AppController.addTimeArray(selectedTime);
                            AppController.addServiceArray(AppController.servicetype);
                            btnNewButton_9.setBackground(Color.RED);
                            checkclickbtn9++;
                        } else if (n == JOptionPane.NO_OPTION) {

                            btnNewButton_9.setBackground(Color.GREEN);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select another available time");
                    }

                }
            }
        });

        btnNewButton_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } else {
                    if (checkclickbtn10 == 0) {
                        btnNewButton_10.setBackground(Color.ORANGE);
                        btnNewButton_10.setOpaque(true);
                        selectedTime = "15:30";
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                        String dateOnly = dateFormat.format(dateChooser.getDate());
                        int n = JOptionPane.showConfirmDialog(frame1, "You have selected " + selectedTime + " on " + dateOnly + ".", "You have selected " + selectedTime + " on " + dateOnly + ".", JOptionPane.YES_NO_OPTION);

                        if (n == JOptionPane.YES_OPTION) {
                            frame1.dispose();
                            AppController.addDateArray(dateOnly);
                            AppController.addTimeArray(selectedTime);
                            AppController.addServiceArray(AppController.servicetype);
                            JOptionPane.showMessageDialog(null, "Your appointment details : \n Service Type: " + AppController.servicetype + "\n Date: " + dateOnly + "\n Time: " + selectedTime);
                            btnNewButton_10.setBackground(Color.RED);
                            checkclickbtn10++;
                        } else if (n == JOptionPane.NO_OPTION) {

                            btnNewButton_10.setBackground(Color.GREEN);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select another available time");
                    }

                }
            }
        });

        btnNewButton_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } else {

                    if (checkclickbtn11 == 0) {
                        btnNewButton_11.setBackground(Color.ORANGE);
                        btnNewButton_11.setOpaque(true);
                        selectedTime = "16:00";
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                        String dateOnly = dateFormat.format(dateChooser.getDate());
                        int n = JOptionPane.showConfirmDialog(frame1, "You have selected " + selectedTime + " on " + dateOnly + ".", "You have selected " + selectedTime + " on " + dateOnly + ".", JOptionPane.YES_NO_OPTION);

                        if (n == JOptionPane.YES_OPTION) {
                            frame1.dispose();
                            AppController.addDateArray(dateOnly);
                            AppController.addTimeArray(selectedTime);
                            AppController.addServiceArray(AppController.servicetype);
                            JOptionPane.showMessageDialog(null, "Your appointment details : \n Service Type: " + AppController.servicetype + "\n Date: " + dateOnly + "\n Time: " + selectedTime);
                            btnNewButton_11.setBackground(Color.RED);
                            checkclickbtn11++;
                        } else if (n == JOptionPane.NO_OPTION) {

                            btnNewButton_11.setBackground(Color.GREEN);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select another available time");
                    }

                }
            }
        });

        btnNewButton_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Please select the date first.");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select another available time");
                }
            }
        });

    }

    public ArrayList<String> getDateList() {
        return AppController.appointmentdate;
    }

    public ArrayList<String> getServiceList() {
        return AppController.appointmenttype;
    }

    public ArrayList<String> getTimeList() {
        return AppController.appointmenttime;
    }
}
