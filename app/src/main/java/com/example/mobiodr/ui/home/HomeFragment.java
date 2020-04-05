package com.example.mobiodr.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mobiodr.DbManager;
import com.example.mobiodr.R;
import com.example.mobiodr.UpdateOrder;
import com.example.mobiodr.ui.slideshow.SlideshowFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeFragment extends Fragment {



    EditText edtname,edtmobno,edtphone,edtdtls;
    Button btnsbmt,btnrst;
    Spinner spinnercolor,spinnerproduct;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtname=view.findViewById(R.id.name);
        edtmobno=view.findViewById(R.id.mob_no);
        edtphone=view.findViewById(R.id.Phone_model);
        edtdtls=view.findViewById(R.id.details);
        btnsbmt=view.findViewById(R.id.submit);
        btnrst=view.findViewById(R.id.reset);
        spinnerproduct=view.findViewById(R.id.Product_spinner);
        spinnercolor=view.findViewById(R.id.colorspinner);
        spinnerproduct.setSelection(0, true);
        spinnercolor.setSelection(0, true);
        View v = spinnerproduct.getSelectedView();
        View x = spinnercolor.getSelectedView();
        int clr=getResources().getColor(android.R.color.darker_gray);
        ((TextView)v).setTextColor(clr);
        ((TextView)x).setTextColor(clr);

/*
        final ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.product, android.R.layout.simple_spinner_item);
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerproduct.setAdapter(staticAdapter);
*/






        //submit button
        btnsbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtname.getText().toString();
                String mobno = edtmobno.getText().toString();
                String phone = edtphone.getText().toString();
                String details = edtdtls.getText().toString();
                String product=spinnerproduct.getSelectedItem().toString();
                String color=spinnercolor.getSelectedItem().toString();

                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
                String formattedDate = df.format(c);

                DbManager db=new DbManager(getContext());
                if(name.equals("") || spinnerproduct.getSelectedItem().toString().equals("Choose any product")){
                    if(name.equals("")){
                        Toast.makeText(getActivity(),"Enter your name", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(getActivity(),"Choose any product", Toast.LENGTH_SHORT).show();
                }else {
                    String res = db.addrecord(name, mobno, product, color, phone, details, formattedDate);
                    Toast.makeText(getActivity(), res, Toast.LENGTH_SHORT).show();
                    reset();
                }

            }
        });


        //Reset button

        btnrst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    //Reset function
    private  void reset(){
        edtname.setText("");
        edtmobno.setText("");
        edtphone.setText("");
        edtdtls.setText("");

        spinnerproduct.setSelection(0, true);
        spinnercolor.setSelection(0, true);
        View y = spinnerproduct.getSelectedView();
        View x = spinnercolor.getSelectedView();
        int clr=getResources().getColor(android.R.color.darker_gray);
        ((TextView)y).setTextColor(clr);
        ((TextView)x).setTextColor(clr);
        edtmobno.clearFocus();
        edtphone.clearFocus();
        edtdtls.clearFocus();



    }
}
