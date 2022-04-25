package com.invoice.controller;

import com.invoice.model.Invoice_Line;
import com.invoice.model.Item_Line;
import com.invoice.model.Item_Line_Model;
import com.invoice.view.Main_Form;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Selection_Listener implements ListSelectionListener {
    private Main_Form form;
    public Selection_Listener(Main_Form form) {
        this.form = form;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvIndex = form.getInvoice_Tabel().getSelectedRow();
        if (selectedInvIndex != -1) {
            Invoice_Line selectedInv = form.getInvoice_Line().get(selectedInvIndex);
            ArrayList<Item_Line> lines = selectedInv.getItem_Line();
            Item_Line_Model lineTableModel = new Item_Line_Model(lines);
            form.setItem_Line(lines);
            form.getItem_Table().setModel(lineTableModel);
            form.getCustomer_Label().setText(selectedInv.getCustomer());
            form.getNumber_Label().setText("" + selectedInv.getInvoice_Number());
            form.getTotal_Label().setText("" + selectedInv.getInvoice_Total());
            form.getDate_Label().setText(Main_Form.date_Format.format(selectedInv.getDate()));
        }
    }

}
