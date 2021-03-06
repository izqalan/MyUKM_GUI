/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dev.izqalan.myukm.views;

import dev.izqalan.myukm.controllers.AppController;
import javax.swing.JOptionPane;

/**
 *
 * @author Izqalan
 */
public class AddBalanceView extends javax.swing.JFrame {

    AppController app;

    /**
     * Creates new form AddBalanceView
     */
    public AddBalanceView(AppController controller) {
        this.app = controller;
        initComponents();
        setVisible(true);
        setTitle("Reload");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addFundsField = new javax.swing.JTextField();
        currencyLabel = new javax.swing.JLabel();
        submitFundButton = new javax.swing.JButton();
        gobackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        currencyLabel.setText("RM");

        submitFundButton.setText("Add Funds");
        submitFundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitFundButtonActionPerformed(evt);
            }
        });

        gobackButton.setText("Go Back");
        gobackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gobackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(submitFundButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currencyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addFundsField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gobackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFundsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyLabel))
                .addGap(47, 47, 47)
                .addComponent(submitFundButton)
                .addGap(75, 75, 75)
                .addComponent(gobackButton)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitFundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitFundButtonActionPerformed
        // TODO add your handling code here:
        try {
            double fund = Double.parseDouble(addFundsField.getText());
            boolean response = this.app.addFunds(fund);
            JOptionPane.showMessageDialog(this, "Funds accepted", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Error e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Fail", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitFundButtonActionPerformed

    private void gobackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gobackButtonActionPerformed
        
        app.showEwalletMenu(this, this.app);
    }//GEN-LAST:event_gobackButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addFundsField;
    private javax.swing.JLabel currencyLabel;
    private javax.swing.JButton gobackButton;
    private javax.swing.JButton submitFundButton;
    // End of variables declaration//GEN-END:variables
}
