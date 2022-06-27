package dev.izqalan.myukm.views;

import dev.izqalan.myukm.controllers.AppController;
import dev.izqalan.myukm.controllers.LibraryController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.EventQueue;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;

/*
 * Lam's work
 */

public class SearchBookView extends JFrame {

    private JPanel contentPane;
    public static JTable booktable;
    private JLabel lblNewLabel;
    private JTextField filtertext;

    public static DefaultTableModel model;
    public DefaultTableModel modelR;
    
    private AppController app;

    private JTable Reservetable;
    private JButton btnNewButton_1;

    //controller obj //izqalan see here
    LibraryController LC = new LibraryController();
    String[][] Rlist = new String[3][4];
    //array is use to stock only 3 book 
    //Explaination : The user try to reserve more than 3 book ,then system direct telling the user cannot,instead going to the back end system,save usage
    //hard to move MVC, if move to M ,then our view hard to get the value inside the model

    final String EMT = "";

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    SearchBookView frame = new SearchBookView();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }//end of main

    public SearchBookView(AppController app) {
        this.app = app;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 764, 608);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 694, 182);
        contentPane.add(scrollPane);

        //code start here
        booktable = new JTable(model);
        scrollPane.setViewportView(booktable);
        model = (DefaultTableModel) booktable.getModel();

        //set column name
        model.setColumnIdentifiers(LC.getCname());

        
        //adding data into the table
        String[][] listOfBooks = LC.getBooksData();
        
        for(int i = 0; i < listOfBooks.length; i++){
            model.addRow(listOfBooks[i]);
        }

        lblNewLabel = new JLabel("Please search your book using the the textbox below");
        lblNewLabel.setBounds(10, 217, 536, 14);
        contentPane.add(lblNewLabel);

        filtertext = new JTextField(); //use to search book
        filtertext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String query = filtertext.getText();

                filter(LC.getquery(query));
            }
        });
        filtertext.setBounds(10, 242, 169, 20);
        contentPane.add(filtertext);
        filtertext.setColumns(10);

        JButton btnNewButton = new JButton("Reserve");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) booktable.getModel();

                if (booktable.getSelectedRow() != -1)//check if the user selected anything 
                {

                    Vector Vectorbookselect = new Vector();// it become new every time it run
                    Vectorbookselect = model.getDataVector().elementAt(booktable.convertRowIndexToModel(booktable.getSelectedRow()));

                    String testvalid = Vectorbookselect.get(4).toString(); //check the 5th column which is the avaibalibility
                    if (testvalid == "Yes") {
                        if (Rlist[0][0] == null) {

                            Rlist[0][0] = Vectorbookselect.get(0).toString();
                            Rlist[0][1] = Vectorbookselect.get(1).toString();
                            Rlist[0][2] = Vectorbookselect.get(2).toString();
                            Rlist[0][3] = Vectorbookselect.get(3).toString();

                            Reserveraction(Rlist[0][0], Rlist[0][1], Rlist[0][2], Rlist[0][3]);
                            JOptionPane.showMessageDialog(null, "The book " + Rlist[0][1] + " is reserve successfully");

                            filtertext.setText(EMT); // change textfield to empty

                            String query = filtertext.getText(); //change the table back to normal form
                            filter(LC.getquery(query));

                            String Ava = Vectorbookselect.get(0).toString();
                            int rowR = Integer.parseInt(Ava);
                            booktable.setValueAt("No", rowR - 1, booktable.getColumn("Availability").getModelIndex()); // change to no on that book

                        } else if (Rlist[1][0] == null) {

                            Rlist[1][0] = Vectorbookselect.get(0).toString();
                            Rlist[1][1] = Vectorbookselect.get(1).toString();
                            Rlist[1][2] = Vectorbookselect.get(2).toString();
                            Rlist[1][3] = Vectorbookselect.get(3).toString();
                            Reserveraction(Rlist[1][0], Rlist[1][1], Rlist[1][2], Rlist[1][3]);
                            JOptionPane.showMessageDialog(null, "The book " + Rlist[1][1] + " is reserve successfully");

                            filtertext.setText(EMT);

                            String query = filtertext.getText();
                            filter(LC.getquery(query));

                            String Ava = Vectorbookselect.get(0).toString();
                            int rowR = Integer.parseInt(Ava);
                            booktable.setValueAt("No", rowR - 1, booktable.getColumn("Availability").getModelIndex());
                        } else if (Rlist[2][0] == null) {

                            Rlist[2][0] = Vectorbookselect.get(0).toString();
                            Rlist[2][1] = Vectorbookselect.get(1).toString();
                            Rlist[2][2] = Vectorbookselect.get(2).toString();
                            Rlist[2][3] = Vectorbookselect.get(3).toString();
                            Reserveraction(Rlist[2][0], Rlist[2][1], Rlist[2][2], Rlist[2][3]);
                            JOptionPane.showMessageDialog(null, "The book " + Rlist[2][1] + " is reserve successfully");

                            filtertext.setText(EMT); //change to empty

                            String query = filtertext.getText(); // renew the table 
                            filter(LC.getquery(query));

                            String Ava = Vectorbookselect.get(0).toString();
                            int rowR = Integer.parseInt(Ava);
                            booktable.setValueAt("No", rowR - 1, booktable.getColumn("Availability").getModelIndex()); //change the avaibality to No
                        } else //display if full of size, 3
                        {
                            JOptionPane.showMessageDialog(null, "You can only reserve 3 book at one time");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "The book is not available at the moment");
                    }//display if not avaiblable

                }//end of the checking selected row
                else {
                    JOptionPane.showMessageDialog(null, "Please select value inside the table first");
                }
            } //end of action perform
        });//end of button action

        btnNewButton.setBounds(10, 306, 89, 23);
        contentPane.add(btnNewButton);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 404, 728, 73);
        contentPane.add(scrollPane_1);

        Reservetable = new JTable(modelR);
        scrollPane_1.setViewportView(Reservetable);
        modelR = (DefaultTableModel) Reservetable.getModel();

        modelR.setColumnIdentifiers(LC.returnshortC());

        JLabel lblNewLabel_1 = new JLabel("Your Reservation List");
        lblNewLabel_1.setBounds(10, 379, 248, 14);
        contentPane.add(lblNewLabel_1);

        btnNewButton_1 = new JButton("Cancel Reservation");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the reservation?", "Confirmation Reservation Cancenlation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION) // use to remove selected row from the resercation jtable 
                {

                    if (Reservetable.getSelectedRow() != -1)//check if the user selected anything 
                    {

                        int removeindex = Reservetable.getSelectedRow();

                        String remove = ""; //reset the remove string for next new input
                        remove = modelR.getValueAt(removeindex, 0).toString(); //read the ID 

                        if (Rlist[0][0] == remove) // compare ID to remove the selected array 
                        {
                            Rlist[0][0] = null;
                        } else if (Rlist[1][0] == remove) {
                            Rlist[1][0] = null;
                        } else if (Rlist[2][0] == remove) {
                            Rlist[2][0] = null;
                        }

                        modelR.removeRow(Reservetable.getSelectedRow()); //remove the selected row in Revervation table

                        filtertext.setText(EMT); // change textfield to empty

                        String query = filtertext.getText(); //change the table back to normal form
                        filter(LC.getquery(query));

                        String Ava = remove; // read the removed ID
                        int rowR = Integer.parseInt(Ava);
                        booktable.setValueAt("Yes", rowR - 1, booktable.getColumn("Availability").getModelIndex()); // change to no on that book
                        JOptionPane.showMessageDialog(null, "The reservation is cancel successfully");

                    }//end of checking selected any row
                    else {
                        JOptionPane.showMessageDialog(null, "Please select value inside the table first");
                    }

                }//end of YES if 

            }
        });
        btnNewButton_1.setBounds(10, 519, 145, 23);
        contentPane.add(btnNewButton_1);

        JButton backMainmenu = new JButton("Main Menu");
        backMainmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                //izqalan see here
                goBack(evt);
                //put the main menu button method here
            }
        });
        backMainmenu.setBounds(590, 519, 135, 23);
        contentPane.add(backMainmenu);
        setVisible(true);

    } //end of search book constructor
    
    private void goBack(ActionEvent evt){
        LC.viewMainMenu(this, app);
    }

    private void Reserveraction(String ID, String name, String ISBN, String Author) // same as below ,hard to MVC
    {
        String[] rowdata = {ID, name, ISBN, Author};
        modelR.addRow(rowdata);
    }

    private void filter(String query) // hard MVC this thing, the JTable is in this frame,if move it to model,  then a lot complicated.
    // because from model hard to edit the thing inside view especailly when the thing is in the JTable.
    //if we do so ,it will create another new jtable not as same as we see on the view
    {
        TableRowSorter<DefaultTableModel> filterbook = new TableRowSorter<DefaultTableModel>(model);
        booktable.setRowSorter(filterbook);
        filterbook.setRowFilter(RowFilter.regexFilter(query));
    }

}//end of class

/* testing code here
 
 */
