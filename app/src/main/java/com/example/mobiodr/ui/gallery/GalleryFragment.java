package com.example.mobiodr.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mobiodr.DbManager;
import com.example.mobiodr.MyAdapter;
import com.example.mobiodr.Order;
import com.example.mobiodr.R;

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

    }

    private void loaddata() {
        DbManager db=new DbManager(getContext());
        arrayList = db.getAllData();
        myAdapter = new MyAdapter(getContext(),arrayList);
        lv.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

}