package com.example.mobiodr;

public class Datemap {
    private int price;
    private String date;
    private  String month;
    private int sell_price;



    public Datemap(String month, int price,int sell_price) {
        this.month = month;
        this.price = price;
        this.sell_price = sell_price;



    }

    public Datemap(int price, String date, String month, int sell_price) {
        this.price = price;
        this.date = date;
        this.month = month;
        this.sell_price = sell_price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSell_price() {
        return sell_price;
    }

    public void setSell_price(int sell_price) {
        this.sell_price = sell_price;
    }
}
