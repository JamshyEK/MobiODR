package com.example.mobiodr;

public class ListId {


    /*    private int id;
        private String color;
        private String date;
        private String details;
        private String mob_no;
        private String name;
        private String product;
        private String phone_model;*/
    private int price;
    private String date;
    private int sell_price;

    public ListId(int price, int sell_price,String date) {
        this.price = price;
        this.date=date;
        this.sell_price = sell_price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSell_price() {
        return sell_price;
    }

    public void setSell_price(int sell_price) {
        this.sell_price = sell_price;
    }
}