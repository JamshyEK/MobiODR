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

        ImageView imageView,imageView1;

        imageView=convertView.findViewById(R.id.picimageView);
        imageView1=convertView.findViewById(R.id.colorimageView);
        //imageView.setImageResource(R.mipmap.ic_launcher);
        t1=convertView.findViewById(R.id.name);
        t2=convertView.findViewById(R.id.product);
        t3=convertView.findViewById(R.id.phone_model);
        t4=convertView.findViewById(R.id.details);
        Order order= arraylist.get(position);
        if(order.getName().equals("Jamshy Ek")){
            imageView.setImageResource(R.drawable.fb);
            imageView1.setImageResource(R.color.colorAccent);




          //  DrawableCompat.setTint(imageView1.getDrawable(), ContextCompat.getColor(context, R.color.colorPrimaryDark));

        }
        else {
            imageView.setImageResource(R.drawable.addd);
            imageView1.setImageResource(R.color.colorPrimary);
           // DrawableCompat.setTint(imageView1.getDrawable(), ContextCompat.getColor(context, R.color.colorPrimaryDark2));

        }
        t1.setText(order.getName());
        t2.setText(order.getProduct());
        t3.setText(order.getPhone_model());
        t4.setText(order.getDetails());

      //  t1.setText(String.valueOf(order.getId()));
        return convertView;
    }
}
