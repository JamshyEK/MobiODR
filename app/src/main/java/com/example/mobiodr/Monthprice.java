package com.example.mobiodr;

public class Monthprice {
    private String month;
    private int Price;
    private  int sell_price;

    public Monthprice(String month, int price, int sell_price) {
        this.month = month;
        Price = price;
        this.sell_price = sell_price;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getSell_price() {
        return sell_price;
    }

    public void setSell_price(int sell_price) {
        this.sell_price = sell_price;
    }
}
