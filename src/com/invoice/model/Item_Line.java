package com.invoice.model;

public class Item_Line {
    private Invoice_Line invoice_Line;
    
    private String item_Name;
    private double item_Price;
    private int item_Count;

    public Item_Line() {
    }

    public Item_Line(Invoice_Line invoice_Line, String item_Name, double item_Price, int item_Count) {
        this.invoice_Line = invoice_Line;
        this.item_Name = item_Name;
        this.item_Price = item_Price;
        this.item_Count = item_Count;
    }

    public Invoice_Line getInvoice_Line() {
        return invoice_Line;
    }

    public void setInvoice_Line(Invoice_Line invoice_Line) {
        this.invoice_Line = invoice_Line;
    }

    public String getItem_Name() {
        return item_Name;
    }

    public void setItem_Name(String item_Name) {
        this.item_Name = item_Name;
    }

    public double getItem_Price() {
        return item_Price;
    }

    public void setItem_Price(double item_Price) {
        this.item_Price = item_Price;
    }

    public int getItem_Count() {
        return item_Count;
    }

    public void setItem_Count(int item_Count) {
        this.item_Count = item_Count;
    }
    
    public double getItem_Total() {
        return item_Price * item_Count;
    }

    @Override
    public String toString() {
        return invoice_Line.getInvoice_Number() + "," + item_Name + "," + item_Price + "," + item_Count;
    }
}
