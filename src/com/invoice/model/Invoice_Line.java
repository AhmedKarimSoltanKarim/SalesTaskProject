package com.invoice.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Invoice_Line {
    private int invoice_Number;
    private String customer;
    private Date date;
    private ArrayList<Item_Line> item_Line;
    private DateFormat date_Format = new SimpleDateFormat("dd-MM-yyyy");

    public Invoice_Line() {
    }

    public Invoice_Line(int invoice_Number, String customer, Date date) {
        this.invoice_Number = invoice_Number;
        this.customer = customer;
        this.date = date;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getInvoice_Number() {
        return invoice_Number;
    }

    public void setInvoice_Number(int invoice_Number) {
        this.invoice_Number = invoice_Number;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<Item_Line> getItem_Line() {
        if (item_Line == null) {
            item_Line = new ArrayList<>();
        }
        return item_Line;
    }

    public void setItem_Line(ArrayList<Item_Line> item_Line) {
        this.item_Line = item_Line;
    }
    
    public double getInvoice_Total() {
        double total = 0.0;
        
        for (int i = 0; i < getItem_Line().size(); i++) {
            total += getItem_Line().get(i).getItem_Total();
        }
        
        return total;
    }

    @Override
    public String toString() {
        return invoice_Number + "," + date_Format.format(date) + "," + customer;
    }
    
}
