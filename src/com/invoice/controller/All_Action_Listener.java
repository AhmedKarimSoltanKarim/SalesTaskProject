package com.invoice.controller;

import com.invoice.model.Invoice_Line;
import com.invoice.model.Invoice_Line_Model;
import com.invoice.model.Item_Line;
import com.invoice.model.Item_Line_Model;
import com.invoice.view.Main_Form;
import com.invoice.view.Add_Invoice_Dialog;
import com.invoice.view.Add_Item_Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class All_Action_Listener implements ActionListener {
    private Main_Form main_Form;
    private Add_Invoice_Dialog add_Invoice_Dialog;
    private Add_Item_Dialog add_Item_Dialog;

    public All_Action_Listener() {
    }
    public All_Action_Listener(Main_Form main_Form) {
        this.main_Form = main_Form;
    }
    public All_Action_Listener(Add_Invoice_Dialog add_Invoice_Dialog, Add_Item_Dialog add_Item_Dialog) {
        this.add_Invoice_Dialog = add_Invoice_Dialog;
        this.add_Item_Dialog = add_Item_Dialog;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Load File":
                load_File();
                break;
            case "Save File":
                save_File();
                break;
            case "Create New Invoice":
                create_New_Invoice();
                break;
            case "Delete Invoice":
                delete_Invoice();
                break;
            case "Create New Item":
                create_New_Item();
                break;
            case "Delete Item":
                delete_Item();
                break;
            case "Add Invoice":
                add_Invoice();
                break;
            case "Cancel Invoice":
                cancel_Invoice();
                break;
            case "Add Item":
                add_Item();
                break;
            case "Cancel Item":
                cancel_Item();
                break;
        }
    }
    private void load_File() {
        JFileChooser fileChooser = new JFileChooser();
        try {
            int result = fileChooser.showOpenDialog(main_Form);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> invoice_Invoices = Files.readAllLines(headerPath);
                ArrayList<Invoice_Line> invoice_ArrayList = new ArrayList<>();
                for (String invoice_invoice : invoice_Invoices) {
                    String[] arr = invoice_invoice.split(",");
                    String str1 = arr[0];
                    String str2 = arr[1];
                    String str3 = arr[2];
                    int code = Integer.parseInt(str1);
                    Date invoiceDate = Main_Form.date_Format.parse(str2);
                    Invoice_Line invoice = new Invoice_Line(code, str3, invoiceDate);
                    invoice_ArrayList.add(invoice);
                }
                main_Form.setInvoice_Line(invoice_ArrayList);
                result = fileChooser.showOpenDialog(main_Form);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fileChooser.getSelectedFile();
                    Path linePath = Paths.get(lineFile.getAbsolutePath());
                    List<String> item_Items = Files.readAllLines(linePath);
                    for (String item_item : item_Items) {
                        String[] arr = item_item.split(",");
                        String str1 = arr[0];
                        String str2 = arr[1];
                        String str3 = arr[2];
                        String str4 = arr[3];
                        int invCode = Integer.parseInt(str1);
                        double price = Double.parseDouble(str3);
                        int count = Integer.parseInt(str4);
                        Invoice_Line inv = main_Form.getObject(invCode);
                        Item_Line item = new Item_Line(inv, str2, price, count);
                        inv.getItem_Line().add(item);
                    }
                System.out.println("***************************************** Invoices *****************************************");
                for (String invoice_invoice : invoice_Invoices){
                System.out.println(invoice_invoice);
                }
                System.out.println("******************************************* Items ******************************************");
                for (String item_item : item_Items){
                System.out.println(item_item);
                }
                }
                Invoice_Line_Model headerTableModel = new Invoice_Line_Model(invoice_ArrayList);
                main_Form.setInvoice_Line_Model(headerTableModel);
                main_Form.getInvoice_Tabel().setModel(headerTableModel);  
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(main_Form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(main_Form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(main_Form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch(NullPointerException ex) {
            JOptionPane.showMessageDialog(main_Form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void save_File() {
        ArrayList<Invoice_Line> invoicesArray = main_Form.getInvoice_Line();
        JFileChooser fileChooser = new JFileChooser();
        try {
            int result = fileChooser.showSaveDialog(main_Form);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                FileWriter headerFileWriter = new FileWriter(headerFile);
                String headers = "";
                String lines = "";
                for (Invoice_Line header : invoicesArray) {
                    headers += header.toString();
                    headers += "\n";
                    for (Item_Line line : header.getItem_Line()) {
                        lines += line.toString();
                        lines += "\n";
                    }
                }
                headers = headers.substring(0, headers.length()-1);
                lines = lines.substring(0, lines.length()-1);
                result = fileChooser.showSaveDialog(main_Form);
                File lineFile = fileChooser.getSelectedFile();
                FileWriter lineFileWriter = new FileWriter(lineFile);
                headerFileWriter.write(headers);
                lineFileWriter.write(lines);
                headerFileWriter.close();
                lineFileWriter.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(main_Form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 
    private void create_New_Invoice() {
        add_Invoice_Dialog = new Add_Invoice_Dialog(main_Form);
        add_Invoice_Dialog.setVisible(true);
    }
    private void delete_Invoice() {
        int selectedInvoiceIndex = main_Form.getInvoice_Tabel().getSelectedRow();
        if (selectedInvoiceIndex != -1) {
            main_Form.getInvoice_Line().remove(selectedInvoiceIndex);
            main_Form.getInvoice_Line_Model().fireTableDataChanged();
            main_Form.getItem_Table().setModel(new Item_Line_Model(null));
            main_Form.setItem_Line(null);
            main_Form.getCustomer_Label().setText("");
            main_Form.getNumber_Label().setText("");
            main_Form.getTotal_Label().setText("");
            main_Form.getDate_Label().setText("");
        }
    }
    private void create_New_Item() {
        add_Item_Dialog = new Add_Item_Dialog(main_Form);
        add_Item_Dialog.setVisible(true);  
    }
    private void delete_Item() {
        int selectedLineIndex = main_Form.getItem_Table().getSelectedRow();
        int selectedInvoiceIndex = main_Form.getInvoice_Tabel().getSelectedRow();
        if (selectedLineIndex != -1) {
            main_Form.getItem_Line().remove(selectedLineIndex);
            Item_Line_Model lineTableModel = (Item_Line_Model) main_Form.getItem_Table().getModel();
            lineTableModel.fireTableDataChanged();
            main_Form.getTotal_Label().setText("" + main_Form.getInvoice_Line().get(selectedInvoiceIndex).getInvoice_Total());
            main_Form.getInvoice_Line_Model().fireTableDataChanged();
            main_Form.getInvoice_Tabel().setRowSelectionInterval(selectedInvoiceIndex, selectedInvoiceIndex);
        }
    } 
    private void cancel_Invoice() {
        add_Invoice_Dialog.setVisible(false);
        add_Invoice_Dialog.dispose();
        add_Invoice_Dialog = null;
    }
    private void add_Invoice() {
        try {
        add_Invoice_Dialog.setVisible(false);
        String custName = add_Invoice_Dialog.getCustomerField().getText();
        String str = add_Invoice_Dialog.getDateField().getText();
        Date d = new Date();
        try {
            d = Main_Form.date_Format.parse(str);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(main_Form, "Cannot parse date, resetting to today.", "Invalid date format", JOptionPane.ERROR_MESSAGE);
        }
        int invNum = 0;
        for (Invoice_Line inv : main_Form.getInvoice_Line()) {
            if (inv.getInvoice_Number() > invNum) {
                invNum = inv.getInvoice_Number();
            }
        }
        invNum++;
        Invoice_Line newInv = new Invoice_Line(invNum, custName, d);
        main_Form.getInvoice_Line().add(newInv);
        main_Form.getInvoice_Line_Model().fireTableDataChanged();
        add_Invoice_Dialog.dispose();
        add_Invoice_Dialog = null;
        }catch (NullPointerException ex){
            JOptionPane.showMessageDialog(main_Form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void cancel_Item() {
        add_Item_Dialog.setVisible(false);
        add_Item_Dialog.dispose();
        add_Item_Dialog = null;
    }
    private void add_Item() {
        try {
        add_Item_Dialog.setVisible(false);
        String name = add_Item_Dialog.getItemNameField().getText();
        String str1 = add_Item_Dialog.getItemCountField().getText();
        String str2 = add_Item_Dialog.getItemPriceField().getText();
        int count = 1;
        double price = 1;
        try {
            count = Integer.parseInt(str1);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(main_Form, "Cannot convert number", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }
        try {
            price = Double.parseDouble(str2);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(main_Form, "Cannot convert price", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }
        int selectedInvHeader = main_Form.getInvoice_Tabel().getSelectedRow();
        if (selectedInvHeader != -1) {
            Invoice_Line invHeader = main_Form.getInvoice_Line().get(selectedInvHeader);
            Item_Line line = new Item_Line(invHeader,name, price, count);
            //invHeader.getLines().add(line);
            main_Form.getItem_Line().add(line);
            Item_Line_Model lineTableModel = (Item_Line_Model) main_Form.getItem_Table().getModel();
            lineTableModel.fireTableDataChanged();
            main_Form.getInvoice_Line_Model().fireTableDataChanged();
        }
        main_Form.getInvoice_Tabel().setRowSelectionInterval(selectedInvHeader, selectedInvHeader);
        add_Item_Dialog.dispose();
        add_Item_Dialog = null;
        }catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(main_Form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
