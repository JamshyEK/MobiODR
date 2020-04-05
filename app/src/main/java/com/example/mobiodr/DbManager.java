package com.example.mobiodr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbname = "mobiodr.db";
    public DbManager(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="CREATE TABLE order_tbl(cus_id INTEGER PRIMARY KEY AUTOINCREMENT,cus_name TEXT NOT NULL,mob_no TEXT,product TEXT NOT NULL,color TEXT,phone_model TEXT,details TEXT,date TEXT,price int,sell_price int)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS order_tbl");
        onCreate(db);

    }
    public String addrecord(String name,String mob_no,String product,String color,String phone,String details,String date){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("cus_name",name);
        cv.put("mob_no",mob_no);
        cv.put("product",product);
        cv.put("color",color);
        cv.put("phone_model",phone);
        cv.put("details",details);
        cv.put("date",date);
        long res=db.insert("order_tbl",null,cv);
        if(res==-1)
            return "Order failed";
        else
            return "Order Success";
    }


    public String updaterecord(String str1,String str2,String str3){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        int id=Integer.parseInt(str1);

        int  price = 0;
        int sell_price = 0;

        if(str2.equals("") && str3.equals("")){
            sell_price=0;
            price=0;
        }else {
            if (str2.equals("")) {
                sell_price = sell_price + Integer.parseInt(str3);
            } else if (str3.equals("")) {
                price = price + Integer.parseInt(str2);
            } else {
                price = price + Integer.parseInt(str2);
                sell_price = sell_price + Integer.parseInt(str3);
            }
        }

        cv.put("price",price);
        cv.put("sell_price",sell_price);
        long res=db.update("order_tbl",cv, "cus_id="+id, null);
        if(res==-1)
            return "Update failed";
        else
            return "Update Success";
    }

 /*   public String[] getdata() {

        final String TABLE_NAME = "order_tbl";

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String[] data      = null;


        String x= null;

        if (cursor.moveToFirst()) {
            do {
                ArrayList<String> mylist = new ArrayList<String>();
                //String[] data = cursor.getString(cursor.getColumnIndex("data"));
                x=cursor.getString(1);

                mylist.add(x); //this adds an element to the list.

                //data=add(x);

               // data = cursor.toString(cursor.getColumnIndex("name"));
                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
      //  return  x;
        return data;

    }*/



 public  ArrayList<Order> getAllData(){
    // final String TABLE_NAME = "order_tbl";
     String selectQuery = "SELECT  * FROM order_tbl ORDER BY cus_id DESC";   /* + TABLE_NAME;*/
     ArrayList<Order> arrayList = new ArrayList<>();
     SQLiteDatabase db  = this.getReadableDatabase();
     Cursor cursor=db.rawQuery(selectQuery,null);
     while (cursor.moveToNext()){
         int id=cursor.getInt(0);
         String name =cursor.getString(1);
         String mob_no =cursor.getString(2);
         String product =cursor.getString(3);
         String color =cursor.getString(4);
         String phone_model =cursor.getString(5);
         String details =cursor.getString(6);
         String date =cursor.getString(7);
         int price =cursor.getInt(8);
         int sell_price =cursor.getInt(9);
         Order order = new Order(id,name,mob_no,product,color,phone_model,details,date,price,sell_price);
         arrayList.add(order);
     }
     return arrayList;
 }


public ArrayList<ListId> getdata(String startdate,String enddate){
   // String selectQuery = "SELECT  * FROM order_tbl ORDER BY cus_id DESC";
    String selectQuery = "SELECT * FROM order_tbl WHERE date >= '" +startdate+ "' AND date <= '" +enddate+ "'";
   // String selectQuery = "SELECT * FROM  order_tbl WHERE date BETWEEN '" + startdate + "' AND '" + enddate + "'";
    ArrayList<ListId> arrayList = new ArrayList<>();
    SQLiteDatabase db  = this.getReadableDatabase();
    Cursor cursor=db.rawQuery(selectQuery,null);
    while (cursor.moveToNext()){
/*        int id=cursor.getInt(0);
        String name =cursor.getString(1);
        String mob_no =cursor.getString(2);
        String product =cursor.getString(3);
        String color =cursor.getString(4);
        String phone_model =cursor.getString(5);
        String details =cursor.getString(6);*/
        String date =cursor.getString(7);
        int price =cursor.getInt(8);
        int sell_price =cursor.getInt(9);
        ListId listId = new ListId(price,sell_price,date);
        arrayList.add(listId);
    }
    return arrayList;
}



}
