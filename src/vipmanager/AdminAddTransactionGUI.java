/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipmanager;

import java.time.LocalDate;
import java.util.LinkedList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author liufangyang
 */
public class AdminAddTransactionGUI extends javax.swing.JFrame {

    /**
     * Creates new form AdminImportTransactionUI
     */
    public AdminAddTransactionGUI() {
        initComponents();
        LinkedList<Vip> vipList = VipSystem.getVipList();
        LinkedList<Product> productList = VipSystem.getProductList();
        LinkedList<Coupon> couponList = VipSystem.getCouponList();
        jTextField1.setText(LocalDate.now().toString());
        jTextField1.setEnabled(false);
        choice1.add("Select Vip");
        choice2.add("Select Product");
        choice3.add("Select Coupon");
        choice3.add("No Coupon");
        for (int i = 0; i < vipList.size(); i++) {
            if (vipList.get(i) != null) {
                choice1.add(vipList.get(i).getFullName());
            }
        }
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) != null) {
                choice2.add(productList.get(i).getProductName());
            }
        }
        choice1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                
                String name = choice1.getSelectedItem();
                for (int i = 0; i < couponList.size(); i++) {
                    if (name.equals(couponList.get(i).getVip().getFullName())) {
                        choice3.add(couponList.get(i).getCouponName());
                    }
                    
                }
            }
        });
        choice2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String productName = choice2.getSelectedItem();
                Product p1 = VipSystem.searchProductByName(productName);
                double price = p1.getPrice();
                jTextField7.setText(String.valueOf(price));
            }
        });
        
        choice3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (choice3.getSelectedItem().equals("No Coupon")) {
                    String name = choice1.getSelectedItem();
                    Vip vip = VipSystem.searchVipByName(name);
                    double levelDiscountRate = Vip.getDiscountRateByLevel(vip.getVipLevel());
                    
                    double discountRate = levelDiscountRate;
                    jTextField4.setText(String.valueOf(discountRate));
                    double paidAmount = Double.parseDouble(jTextField7.getText()) * (1 - Double.parseDouble(jTextField4.getText())) * Integer.parseInt(jTextField2.getText());
                    jTextField8.setText(String.valueOf(paidAmount));
                    double bounusPointEarned = paidAmount;
                    jTextField6.setText(String.valueOf(bounusPointEarned));
                } else {
                    String couponName = choice3.getSelectedItem();
                    boolean d = VipSystem.searchCouponByName(couponName) instanceof DiscountCoupon;
                    if (d) {
                        String name = choice1.getSelectedItem();
                        Vip vip = VipSystem.searchVipByName(name);
                        double levelDiscountRate = Vip.getDiscountRateByLevel(vip.getVipLevel());
                        
                        DiscountCoupon dc1 = (DiscountCoupon) VipSystem.searchCouponByName(couponName);
                        double discountRate = dc1.getDiscountRate() + levelDiscountRate;
                        jTextField4.setText(String.valueOf(discountRate));
                        double paidAmount = Double.parseDouble(jTextField7.getText()) * (1 - Double.parseDouble(jTextField4.getText())) * Integer.parseInt(jTextField2.getText());
                        jTextField8.setText(String.valueOf(paidAmount));
                        double bounusPointEarned = paidAmount;
                        jTextField6.setText(String.valueOf(bounusPointEarned));
                    } else {
                        String name = choice1.getSelectedItem();
                        Vip vip = VipSystem.searchVipByName(name);
                        double levelDiscountRate = Vip.getDiscountRateByLevel(vip.getVipLevel());
                        
                        String productName = choice2.getSelectedItem();
                        Product p1 = VipSystem.searchProductByName(productName);
                        FreeDrinkCoupon fdc = (FreeDrinkCoupon) VipSystem.searchCouponByName(couponName);
                        
                        if (p1.getType() == fdc.getProductType()) {
                            double discountRate = 1.0 + levelDiscountRate;
                            jTextField4.setText(String.valueOf(discountRate));
                            double paidAmount = Double.parseDouble(jTextField7.getText()) * (1 - Double.parseDouble(jTextField4.getText())) * Integer.parseInt(jTextField2.getText());
                            jTextField8.setText(String.valueOf(paidAmount));
                            double bounusPointEarned = paidAmount;
                            jTextField6.setText(String.valueOf(bounusPointEarned));
                        } else {
                            double discountRate = 0.0 + levelDiscountRate;
                            jTextField4.setText(String.valueOf(discountRate));
                            double paidAmount = Double.parseDouble(jTextField7.getText()) * (1 - Double.parseDouble(jTextField4.getText())) * Integer.parseInt(jTextField2.getText());
                            jTextField8.setText(String.valueOf(paidAmount));
                            double bounusPointEarned = paidAmount;
                            jTextField6.setText(String.valueOf(bounusPointEarned));
                        }
                    }
                }
            }
        });
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        choice1 = new java.awt.Choice();
        choice2 = new java.awt.Choice();
        choice3 = new java.awt.Choice();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Add Transaction Record");

        jLabel2.setText("Date:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Product Name:");

        jLabel4.setText("Quantity:");

        jLabel5.setText("Discount Rate:");

        jLabel6.setText("Available coupon:");

        jLabel7.setText("Bonus Point Earned:");

        jLabel8.setText("Paid Amount:");

        jLabel9.setText("Deposit Point Used:");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Vip name:");

        jLabel11.setText("Price:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField6)
                            .addComponent(jTextField2)
                            .addComponent(jTextField7)
                            .addComponent(jTextField1)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jTextField8)
                            .addComponent(choice3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(167, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(choice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(28, 28, 28))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(choice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // LocalDate date,Vip vip,Product product,Coupon coupon,int quantity,double depositPointUsed,double bonusPointEarned
        LocalDate d1 = LocalDate.now();
        Vip v1 = VipSystem.searchVipByName(choice1.getSelectedItem());
        Product p1 = VipSystem.searchProductByName(choice2.getSelectedItem());
        Coupon c1 = VipSystem.searchCouponByName(choice3.getSelectedItem());
        int q = Integer.parseInt(jTextField2.getText());
        double dpu = Double.parseDouble(jTextField3.getText());
        double bpe = Double.parseDouble(jTextField6.getText());
        v1.setBonusPoint(bpe);
        TransactionRecord tr = new TransactionRecord(d1, v1, p1, c1, q, dpu, bpe);
        VipSystem.addToTransactionRecordList(tr);
        Random r = new Random();
        int a = r.nextInt(5);
        int b = r.nextInt(5);
        if (a == b) {
            DiscountCoupon discountCoupon = new DiscountCoupon("Lucyky Coupon", 10, "random coupon added", Math.random());
            VipSystem.addToCouponList(discountCoupon);
            discountCoupon.assignCoupon(v1);
            JOptionPane.showMessageDialog(null, "transaction record added sucessfully You got a coupon check it out");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "transaction record added sucessfully you almost get a coupon");
            this.dispose();
        }
        p1.setQuantityBeenSold(q);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminAddTransactionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAddTransactionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAddTransactionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAddTransactionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAddTransactionGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice1;
    private java.awt.Choice choice2;
    private java.awt.Choice choice3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
