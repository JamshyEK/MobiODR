package com.example.mobiodr.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mobiodr.DbManager;
import com.example.mobiodr.ListId;
import com.example.mobiodr.MyAdapter;
import com.example.mobiodr.Order;
import com.example.mobiodr.R;
import com.example.mobiodr.UpdateOrder;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
 ListView lv;
 ArrayList<Order> arrayList;
 MyAdapter myAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DbManager db=new DbManager(getContext());
        arrayList = new ArrayList<>();
        lv=view.findViewById(R.id.listview);

        loaddata();

       /* LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.listview,null);
        TextView t1;
        TextView t2;
        t1=view.findViewById(R.id.textView2);
        t2=view.findViewById(R.id.textView3);
        t2.setText(res.size());*/

/*       lv.setAdapter((ListAdapter) res);*/

       // lv.setAdapter((ListAdapter) res);
        /*db.getdata();*/

        //lv.setClickable(true);






        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                   /*Object object= new Object();
                     object = lv.getItemAtPosition(position);*/
                   //ListId listId=new ListId(33,500,900,"aaa","eeee","dsdsdsd","sdsd","dsdsdds","sdasd","dasd");
                Order itemdtls = arrayList.get(position);
                int id = itemdtls.getId();
                int price = itemdtls.getPrice();
                int sell_price = itemdtls.getSell_price();

                String name =itemdtls.getName();
                String mob_no =itemdtls.getMob_no();
                String product =itemdtls.getProduct();
                String color =itemdtls.getColor();
                String phone_model =itemdtls.getPhone_model();
                String details =itemdtls.getDetails();
                String date =itemdtls.getDate();





                Intent intent=new Intent(getContext(),UpdateOrder.class);
                intent.putExtra("id",id);
                intent.putExtra("price",price);
                intent.putExtra("sell_price",sell_price);
                intent.putExtra("name",name);
                intent.putExtra("mob_no",mob_no);
                intent.putExtra("product",product);
                intent.putExtra("color",color);
                intent.putExtra("phone_model",phone_model);
                intent.putExtra("details",details);
                intent.putExtra("date",date);


                startActivity(intent);
               // String str=(String)o;//As you are using Default String Adapter
            }
        });

    }

    private void loaddata() {
        DbManager db=new DbManager(getContext());
        arrayList = db.getAllData();
        myAdapter = new MyAdapter(getContext(),arrayList);
        lv.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

}