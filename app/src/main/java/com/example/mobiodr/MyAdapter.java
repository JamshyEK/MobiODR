package com.example.mobiodr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Order> arraylist;

    public MyAdapter(Context context, ArrayList<Order> arraylist) {
        this.context = context;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return this.arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return arraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.listview,null);
        TextView t1,t2,t3,t4;

        ImageView imageViewprdt,imageViewcolor;

        imageViewprdt=convertView.findViewById(R.id.picimageView);
        imageViewcolor=convertView.findViewById(R.id.colorimageView);
        //imageView.setImageResource(R.mipmap.ic_launcher);
        t1=convertView.findViewById(R.id.name);
        t2=convertView.findViewById(R.id.product);
        t3=convertView.findViewById(R.id.phone_model);
        t4=convertView.findViewById(R.id.details);
        Order order= arraylist.get(position);
    switch (order.getColor()) {
            case "White":
                imageViewcolor.setImageResource(R.color.white);
                break;
            case "Black":
                imageViewcolor.setImageResource(R.color.black);
                break;
            case "Blue":
                imageViewcolor.setImageResource(R.color.blue);
                break;
            case "Green":
                imageViewcolor.setImageResource(R.color.green);
                break;
            case "Yellow":
                imageViewcolor.setImageResource(R.color.yellow);
                break;
            case "Gold":
                imageViewcolor.setImageResource(R.color.gold);
                break;
            case "Orange":
                imageViewcolor.setImageResource(R.color.orange);
                break;
            case "Brown":
                imageViewcolor.setImageResource(R.color.brown);
                break;
            case "Red":
                imageViewcolor.setImageResource(R.color.red);
                break;
            case "Rose":
                imageViewcolor.setImageResource(R.color.rose);
                break;
            case "Pink":
                imageViewcolor.setImageResource(R.color.pink);
                break;
            case "Violet":
                imageViewcolor.setImageResource(R.color.violet);
                break;
            case "Silver":
                imageViewcolor.setImageResource(R.color.silver);
                break;
            case "Gray":
                imageViewcolor.setImageResource(R.color.gray);
                break;
            default:
                imageViewcolor.setImageResource(R.drawable.other1);
                break;
        }


        switch (order.getProduct()) {
            case "Glass guard":
                imageViewprdt.setImageResource(R.drawable.glass1);
                break;
            case "Back cover":
                imageViewprdt.setImageResource(R.drawable.backcover1);
                break;
             case "Back cover ladies":
                imageViewprdt.setImageResource(R.drawable.ladiesbackcover1);
                break;
            case "Headset":
                imageViewprdt.setImageResource(R.drawable.headset1);
                break;
            case "Neckband":
                imageViewprdt.setImageResource(R.drawable.neckband1);
                break;
            case "Airpods":
                imageViewprdt.setImageResource(R.drawable.airpods);
                break;
            case "Charger":
                imageViewprdt.setImageResource(R.drawable.charger1);
                break;
            case "Bluetooth speaker":
                imageViewprdt.setImageResource(R.drawable.bluetoothspkr1);
                break;
            case "Powerbank":
                imageViewprdt.setImageResource(R.drawable.powerbank1);
                break;
            case "Data cable":
                imageViewprdt.setImageResource(R.drawable.datacable1);
                break;
            case "Pendrive":
                imageViewprdt.setImageResource(R.drawable.pendrive1);
                break;
            case "Memory card":
                imageViewprdt.setImageResource(R.drawable.memory1);
                break;
            case "Mobile stand":
                imageViewprdt.setImageResource(R.drawable.stand1);
                break;
            default:
                imageViewprdt.setImageResource(R.drawable.mobaccs1);
                break;
        }




  /*      if(order.getName().equals("Jamshy Ek")){
            imageView.setImageResource(R.drawable.fb);
            imageViewcolor.setImageResource(R.color.colorAccent);




          //  DrawableCompat.setTint(imageViewcolor.getDrawable(), ContextCompat.getColor(context, R.color.colorPrimaryDark));

        }
        else {
            imageView.setImageResource(R.drawable.backcover);
            imageViewcolor.setImageResource(R.color.colorPrimary);
           // DrawableCompat.setTint(imageView1.getDrawable(), ContextCompat.getColor(context, R.color.colorPrimaryDark2));

        }*/
        t1.setText(order.getName());
        t2.setText(order.getProduct());
        t3.setText(order.getPhone_model());
        t4.setText(order.getDetails());

      //  t1.setText(String.valueOf(order.getId()));
        return convertView;
    }
}
