/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import util.Koneksi;

/**
 *
 * @author Rizki Pratama
 */
public class ViewCariBarang extends javax.swing.JFrame {

    Koneksi koneksi = new Koneksi();
    
    /**
     * Creates new form ViewCariBarang
     */
    public ViewCariBarang() {
        initComponents();
        dataTable();
        CenterForm();
    }

    private void CenterForm() {
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (ScreenSize.width - frameSize.width)/2,
        (ScreenSize.height - frameSize.height)/2);
    }
    
    private void dataTable(){
        koneksi.koneksidatabase();
        
        DefaultTableModel tabel = new DefaultTableModel();
        
        tabel.addColumn("ID");
        tabel.addColumn("Nama");
        tabel.addColumn("Jenis");
        tabel.addColumn("Jumlah");
        
        jTableCariBarang.setModel(tabel);
        try {
            String sql = "select * from tbl_barang";
            
            ResultSet res = koneksi.state.executeQuery(sql);
            while (res.next()) {
                tabel.addRow(new Object[]{
                    res.getString("id"),
                    res.getString("nama"),
                    res.getString("jenis"),
                    res.getString("jumlah")
                });
                jTableCariBarang.setModel(tabel);
            }
        } catch (Exception eer) {
            System.err.println("SQLException:" + eer.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCariBarang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cari Barang :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 34, -1, 10));

        jTextFieldCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCariKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 150, 30));

        jTableCariBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableCariBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCariBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCariBarang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 560, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableCariBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCariBarangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableCariBarangMouseClicked

    private void jTextFieldCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCariKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCariKeyPressed

    private void jTextFieldCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCariKeyReleased
        // TODO add your handling code here:
        koneksi.koneksidatabase();
        String nama = jTextFieldCari.getText();
        
        DefaultTableModel tabel = new DefaultTableModel();
        
        tabel.addColumn("ID");
        tabel.addColumn("Nama");
        tabel.addColumn("Jenis");
        tabel.addColumn("Jumlah");
        
        jTableCariBarang.setModel(tabel);
        try {
            String sql = "select * from tbl_barang where nama like '%"+nama+"%'";
            
            ResultSet res = koneksi.state.executeQuery(sql);
            while (res.next()) {
                tabel.addRow(new Object[]{
                    res.getString("id"),
                    res.getString("nama"),
                    res.getString("jenis"),
                    res.getString("jumlah")
                });
                jTableCariBarang.setModel(tabel);
            }
        } catch (Exception eer) {
            System.err.println("SQLException:" + eer.getMessage());
        }
    }//GEN-LAST:event_jTextFieldCariKeyReleased

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
            java.util.logging.Logger.getLogger(ViewCariBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCariBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCariBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCariBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCariBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCariBarang;
    private javax.swing.JTextField jTextFieldCari;
    // End of variables declaration//GEN-END:variables
}
