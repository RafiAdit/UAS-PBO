/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package adithfrozen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo - GK
 */
public class History extends javax.swing.JFrame {

    /**
     * Creates new form History
     */
    
    private Connection con;
    private Statement stat;
    private ResultSet res;
    
    public History() {
        initComponents();
        tabel();
    }
    
    private void tabel() {
        con = koneksi.getConnection();
        DefaultTableModel tb = (DefaultTableModel) table.getModel();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tb.setRowCount(0);

        try {
            stat = con.createStatement();
            String sql = "SELECT * FROM tborder "
                    + "JOIN barang ON tborder.id_barang = barang.id_barang "
                    + "WHERE id_user = " + Login.IDU;
            res = stat.executeQuery(sql);
            while (res.next()) {
                tb.addRow(new Object[]{
                    res.getInt("id_order"),
                    res.getString("merk"),
                    res.getString("nama"),
                    res.getString("tgl_order"),
                    res.getInt("jumlah"),
                    res.getInt("harga") * res.getInt("jumlah")
                });
            }
            res.close();
            stat.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setBackground(new java.awt.Color(153, 153, 153));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Order", "Merk Barang", "Nama Barang", "Tanggal Order", "Jumlah Barang", "Total Harga"
            }
        ));
        jScrollPane1.setViewportView(table);

        jMenu1.setText("Home");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        MenuUser MU = new MenuUser();
        MU.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
