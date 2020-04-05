package com.example.mobiodr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateOrder extends AppCompatActivity {
    Button button1,button2;
    ImageView imageView;
    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8,editText9;
   /* ArrayList<Order> arraylist;*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateorder);
        final Intent intent=getIntent();
        final int id = intent.getIntExtra("id", 0);
        final String strI = String.valueOf(id);
        int price = intent.getIntExtra("price", 0);
        final String s_price=String.valueOf(price);
        int sell_price = intent.getIntExtra("sell_price", 0);
        final String s_sell_price=String.valueOf(sell_price);
        final String name = intent.getStringExtra("name");
        String mob_no = intent.getStringExtra("mob_no");
        final String product = intent.getStringExtra("product");
        final String color = intent.getStringExtra("color");
        String phone_model = intent.getStringExtra("phone_model");
        final String details = intent.getStringExtra("details");
        String date = intent.getStringExtra("date");
        imageView=findViewById(R.id.imageView);
        editText1=findViewById(R.id.name);
        editText2=findViewById(R.id.product);
        editText3=findViewById(R.id.color);
        editText4=findViewById(R.id.phone_model);
        editText5=findViewById(R.id.mob_no);
        editText6=findViewById(R.id.order_date);
        editText7=findViewById(R.id.details);
        editText8=findViewById(R.id.price);
        editText9=findViewById(R.id.sell_price);
        button1=findViewById(R.id.update);
        button2=findViewById(R.id.reset);

        editText1.setText(name);
        editText1.setEnabled(false);
        editText2.setText(product);
        editText2.setEnabled(false);
        editText3.setText(color);
        editText3.setEnabled(false);
        editText4.setText(phone_model);
        editText4.setEnabled(false);
        editText5.setText(mob_no);
        editText5.setEnabled(false);
        editText6.setText(date);
        editText6.setEnabled(false);
        editText7.setText(details);
        editText7.setEnabled(false);
        if(s_price.equals("0"))
            editText8.setText("");
        else
            editText8.setText(s_price);
        if(s_sell_price.equals("0"))
            editText9.setText("");
        else
            editText9.setText(s_sell_price);


        switch (product) {
            case "Glass guard":
                imageView.setImageResource(R.drawable.glass);
                break;
            case "Back cover":
                imageView.setImageResource(R.drawable.backcover);
                break;
            case "Back cover ladies":
                imageView.setImageResource(R.drawable.ladiesbackcover);
                break;
            case "Headset":
                imageView.setImageResource(R.drawable.headset);
                break;
            case "Neckband":
                imageView.setImageResource(R.drawable.neckband);
                break;
            case "Airpods":
                imageView.setImageResource(R.drawable.airpods);
                break;
            case "Charger":
                imageView.setImageResource(R.drawable.charger);
                break;
            case "Bluetooth speaker":
                imageView.setImageResource(R.drawable.bluetoothspkr);
                break;
            case "Powerbank":
                imageView.setImageResource(R.drawable.powerbank);
                break;
            case "Data cable":
                imageView.setImageResource(R.drawable.datacable);
                break;
            case "Pendrive":
                imageView.setImageResource(R.drawable.pendrive);
                break;
            case "Memory card":
                imageView.setImageResource(R.drawable.memory);
                break;
            case "Mobile stand":
                imageView.setImageResource(R.drawable.stand);
                break;
            default:
                imageView.setImageResource(R.drawable.mobaccs);
                break;
        }


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable a=editText8.getText();
                Editable b=editText9.getText();
                String str2 = String.valueOf(a);
                String str3 = String.valueOf(b);



                DbManager db=new DbManager(getApplicationContext());
                String res = db.updaterecord(strI, str2, str3);
                Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),NavActivity.class);
                startActivity(intent);
                /*Intent intent1 = new Intent(android.content.Intent.ACTION_CALL, Uri.parse("tel: +911234567890"));
                startActivity(intent1);*/


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s_price.equals("0"))
                    editText8.setText("");
                else
                    editText8.setText(s_price);
                if(s_sell_price.equals("0"))
                    editText9.setText("");
                else
                    editText9.setText(s_sell_price);

                editText9.clearFocus();
            }
        });







        // String a=String.valueOf(id);
     //  Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
       // DbManager db=new DbManager(getApplicationContext());
        //Order order= new Order();
//        Order order= arraylist.get();
        //db.getSingleData(id);

      //  String a =order.getName();
      //  String B =order.getColor();






    }
}
