package com.example.mobiodr;

public class Order {
    int id,price,sell_price;
    String name,mob_no,product,color,phone_model,details,date;


    public Order(int id, String name, String mob_no, String product, String color, String phone_model, String details, String date, int price, int sell_price) {
        this.id = id;
        this.price = price;
        this.sell_price = sell_price;
        this.name = name;
        this.mob_no = mob_no;
        this.product = product;
        this.color = color;
        this.phone_model = phone_model;
        this.details = details;
        this.date = date;
    }


    public Order(){

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

    public String getMob_no() {
        return mob_no;
    }

    public void setMob_no(String mob_no) {
        this.mob_no = mob_no;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPhone_model() {
        return phone_model;
    }

    public void setPhone_model(String phone_model) {
        this.phone_model = phone_model;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
