package com.invoice.view;

import com.invoice.controller.All_Action_Listener;
import com.invoice.controller.Selection_Listener;
import com.invoice.model.Invoice_Line;
import com.invoice.model.Invoice_Line_Model;
import com.invoice.model.Item_Line;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

public class Main_Form extends javax.swing.JFrame {
    public Main_Form() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoice_Tabel = new javax.swing.JTable();
        createInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        customer_Label = new javax.swing.JLabel();
        date_Label = new javax.swing.JLabel();
        number_Label = new javax.swing.JLabel();
        total_Label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Item_Table = new javax.swing.JTable();
        createLineButton = new javax.swing.JButton();
        deleteLineButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(250, 150));
        setSize(new java.awt.Dimension(900, 600));

        invoice_Tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invoice_Tabel.getSelectionModel().addListSelectionListener(selection_Listener);
        jScrollPane1.setViewportView(invoice_Tabel);

        createInvoiceButton.setText("Create New Invoice");
        createInvoiceButton.addActionListener(all_Action_Listener);

        deleteInvoiceButton.setText("Delete Invoice");
        deleteInvoiceButton.addActionListener(all_Action_Listener);

        jLabel1.setText("Invoice No.");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");

        Item_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Item_Table);

        createLineButton.setText("Create New Item");
        createLineButton.addActionListener(all_Action_Listener);

        deleteLineButton.setText("Delete Item");
        deleteLineButton.addActionListener(all_Action_Listener);

        jMenu1.setText("File");

        loadMenuItem.setText("Load File");
        loadMenuItem.addActionListener(all_Action_Listener);
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save File");
        saveMenuItem.addActionListener(all_Action_Listener);
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(createInvoiceButton)
                .addGap(67, 67, 67)
                .addComponent(deleteInvoiceButton)
                .addGap(131, 131, 131)
                .addComponent(createLineButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteLineButton)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total_Label)
                            .addComponent(number_Label)
                            .addComponent(date_Label)
                            .addComponent(customer_Label))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(number_Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(date_Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(customer_Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(total_Label))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvoiceButton)
                    .addComponent(deleteInvoiceButton)
                    .addComponent(createLineButton)
                    .addComponent(deleteLineButton))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Form().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Item_Table;
    private javax.swing.JButton createInvoiceButton;
    private javax.swing.JButton createLineButton;
    private javax.swing.JLabel customer_Label;
    private javax.swing.JLabel date_Label;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteLineButton;
    private javax.swing.JTable invoice_Tabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JLabel number_Label;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JLabel total_Label;
    // End of variables declaration//GEN-END:variables
    public static SimpleDateFormat date_Format = new SimpleDateFormat("dd-MM-yyyy");
    private Selection_Listener selection_Listener = new Selection_Listener(this);
    private All_Action_Listener all_Action_Listener = new All_Action_Listener(this);
    private ArrayList<Invoice_Line> invoice_Line;
    private ArrayList<Item_Line> item_Line;
    private Invoice_Line_Model invoice_Line_Model;
     
    public All_Action_Listener getAll_Action_Listener() {
        return all_Action_Listener;
    }
   
    public void setInvoice_Line(ArrayList<Invoice_Line> invoice_Line) {
        this.invoice_Line = invoice_Line;
    }
    public ArrayList<Invoice_Line> getInvoice_Line() {
        return invoice_Line;
    }
    
    public ArrayList<Item_Line> getItem_Line() {
        return item_Line;
    }
    public void setItem_Line(ArrayList<Item_Line> item_Line) {
        this.item_Line = item_Line;
    }
   
    public Invoice_Line_Model getInvoice_Line_Model() {
        return invoice_Line_Model;
    }
    public void setInvoice_Line_Model(Invoice_Line_Model invoice_Line_Model) {
        this.invoice_Line_Model = invoice_Line_Model;
    }

    public Invoice_Line getObject(int number) {
        for (Invoice_Line header : invoice_Line) {
            if (header.getInvoice_Number() == number) {
                return header;
            }
        }
        return null;
    }
    public JTable getInvoice_Tabel() {
        return invoice_Tabel;
    }
    public JTable getItem_Table() {
        return Item_Table;
    }
    public JLabel getCustomer_Label() {
        return customer_Label;
    }
    public JLabel getDate_Label() {
        return date_Label;
    }
    public JLabel getNumber_Label() {
        return number_Label;
    }
    public JLabel getTotal_Label() {
        return total_Label;
    }
}
