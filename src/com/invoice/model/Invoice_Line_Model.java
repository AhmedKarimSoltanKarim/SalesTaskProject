package com.invoice.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import com.invoice.view.Main_Form;

public class Invoice_Line_Model extends AbstractTableModel {
    private ArrayList<Invoice_Line> invoice_Line_ArrayList;
    private String[] table_Labels = {"No.", "Date", "Customer", "Total"};

    public Invoice_Line_Model(ArrayList<Invoice_Line> invoice_Line_ArrayList) {
        this.invoice_Line_ArrayList = invoice_Line_ArrayList;
    }
    @Override
    public int getRowCount() {
        return invoice_Line_ArrayList.size();
    }
    @Override
    public int getColumnCount() {
        return table_Labels.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice_Line invoice_Line = invoice_Line_ArrayList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return invoice_Line.getInvoice_Number();
            case 1:
                return Main_Form.date_Format.format(invoice_Line.getDate());
            case 2:
                return invoice_Line.getCustomer();
            case 3:
                return invoice_Line.getInvoice_Total();

        }
        return null;
    }
    @Override
    public String getColumnName(int label) {
        return table_Labels[label];
    }
}
