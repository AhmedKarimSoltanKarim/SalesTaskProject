package com.invoice.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Item_Line_Model extends AbstractTableModel {

    private ArrayList<Item_Line> item_Line_ArrayList;
    private String[] table_Labels = {"Item Name", "Item Price", "Count", "Item Total"};

    public Item_Line_Model(ArrayList<Item_Line> linesArray) {
        this.item_Line_ArrayList = linesArray;
    }
    @Override
    public int getRowCount() {
        return item_Line_ArrayList == null ? 0 : item_Line_ArrayList.size();
    }
    @Override
    public int getColumnCount() {
        return table_Labels.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (item_Line_ArrayList == null) {
            return null;
        } else {
            Item_Line line = item_Line_ArrayList.get(rowIndex);
            
            switch (columnIndex) {
                case 0:
                  return  line.getItem_Name();
                case 1:
                   return line.getItem_Price();
                case 2:
                   return line.getItem_Count();
                case 3:
                   return line.getItem_Total();
                
            };
        }return null;
    }
    @Override
    public String getColumnName(int label) {
        return table_Labels[label];
    }

}
