package com.example.mobiodr.ui.slideshow;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.mobiodr.Datemap;
import com.example.mobiodr.DbManager;
import com.example.mobiodr.ListId;
import com.example.mobiodr.Monthprice;
import com.example.mobiodr.Monthpricefull;
import com.example.mobiodr.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class SlideshowFragment extends Fragment {
    @Nullable
    BarChart barChart;
    PieChart pieChart;
    TextView crtv,detv,prtv,pramttv;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_slideshow,null);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      //  BarChart barChart = (BarChart) findViewById(R.id.barchart);


        crtv=view.findViewById(R.id.creditamt);
        detv=view.findViewById(R.id.debitamt);
        prtv=view.findViewById(R.id.profitlbl);
        pramttv=view.findViewById(R.id.profitamt);

        DbManager db=new DbManager(getContext());


        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -123);
        Date today123 = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String start = format.format(today123);
        String end=format.format(today);

        ArrayList<ListId> arraylist = db.getdata(start,end);

//get month from date to arraylist
        ArrayList<Datemap> arrayList2=new ArrayList<>();
        for (int j=0;j<arraylist.size();j++){
        ListId listId=arraylist.get(j);
        String sdate=listId.getDate();
        Date d = null;
        try {
            d = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar call = Calendar.getInstance();
        call.setTime(d);
        String monthName = new SimpleDateFormat("MMMM").format(call.getTime());
        int price=listId.getPrice();
        int sell_price=listId.getSell_price();
        Datemap dtmp = new Datemap(price,sdate,monthName,sell_price);
        arrayList2.add(dtmp);
    }

//mapped by month name
        Map<String, List<Datemap>> monthname_map = arrayList2.stream().collect(Collectors.groupingBy(w -> w.getMonth()));







        String monthp,monthpp,monthppp;
        Calendar c = Calendar.getInstance();
        String[]monthName={"January","February","March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
        String month=monthName[c.get(Calendar.MONTH)];
        switch (month) {
            case "January":
                monthp = "December";
                monthpp = "November";
                monthppp = "September";
                break;
            case "February":
                monthp = "January";
                monthpp = "December";
                monthppp = "November";
                break;
            case "March":
                monthp = "February";
                monthpp = "January";
                monthppp = "December";
                break;
            default:
                monthp = monthName[c.get(Calendar.MONTH) - 1];
                monthpp = monthName[c.get(Calendar.MONTH) - 2];
                monthppp = monthName[c.get(Calendar.MONTH) - 3];
                break;
        }

        ArrayList<String> labels = new ArrayList<String>();
        labels.add(monthppp);
        labels.add(monthpp);
        labels.add(monthp);
        labels.add(month);




        ArrayList<Monthpricefull> monthprices1=new ArrayList<>();
        Map<String, List<Integer>> tttt = new HashMap<String,List<Integer>>();
        for (String rrr:labels) {
            List<Integer> prices = new ArrayList<>();
            if (monthname_map.get(rrr) != null) {
                Integer price = 0;
                Integer sell_price = 0;
                for (Datemap mm : monthname_map.get(rrr)) {
                    price = price + mm.getPrice();
                    sell_price = sell_price + mm.getSell_price();
                }

                Monthpricefull monthpricefull = new Monthpricefull(rrr, price, sell_price);
                monthprices1.add(monthpricefull);
                prices.add(price);
                prices.add(sell_price);
                tttt.put(rrr, prices);
            } else {
                int price = 0;
                int sell_price = 0;
                Monthpricefull monthpricefull = new Monthpricefull(rrr, price, sell_price);
                monthprices1.add(monthpricefull);
                prices.add(0);
                prices.add(0);
                tttt.put(rrr, prices);
            }
        }



/*

        Map<String, List<Monthpricefull>> studlistGrouped3 = monthprices1.stream().collect(Collectors.groupingBy(w -> w.getMonth()));
       ArrayList<Monthprice> monthpricesnew=new ArrayList<>();
        for (Map.Entry<String, List<Monthpricefull>> me : studlistGrouped3.entrySet()) {
            String key = me.getKey();
            List<Monthpricefull> valueList = me.getValue();
            //  valueList.get(2);
            System.out.println("Key: " + key);
            System.out.print("Values: ");
            int ioi=0;
            int qqq=0;
            for (Monthpricefull s : valueList) {
                int qw = s.getPrice();
                qqq=qqq+qw;

                int  iu=  s.getSell_price();
                ioi=ioi+iu;
            }
            Monthprice monthprice=new Monthprice(key,qqq,ioi);
            monthpricesnew.add(monthprice);
        }

*/
        Monthpricefull first = monthprices1.get(0);
      /*      first.getMonth();
            first.getPrice();
            first.getSell_price();*/
        int profit1 = first.getSell_price() - first.getPrice();

        Monthpricefull second = monthprices1.get(1);
           /* second.getMonth();
            second.getPrice();
            second.getSell_price();*/
        int profit2 = second.getSell_price() - second.getPrice();

        Monthpricefull third = monthprices1.get(2);
          /*  third.getMonth();
            third.getPrice();
            third.getSell_price();*/
        int profit3 = third.getSell_price() - third.getPrice();

        Monthpricefull fourth = monthprices1.get(3);
            fourth.getMonth();
            fourth.getPrice();
            fourth.getSell_price();
        int profit4 = fourth.getSell_price() - fourth.getPrice();






 /*       Map<String, Integer> sum = arrayList2.stream().collect(
                Collectors.groupingBy(arrayList2::get, Collectors.summingInt(Item::getQty)));*/
/*        for (String rr:month1
             ) {
*//*            Map<String, List<Monthprice>> studlistGrouped1 = arrayList2.stream().collect(Collectors.groupingBy(w -> w.getMonth()));
            //String ee = rr;
            Map<String, List<Datemap>> studlistGrouped1 = arrayList2.stream().collect(Collectors.groupingBy(w -> w.getMonth()));*//*
        }*/


        int price=0;
        int sell_price=0;
        for(int i=0 ; i<arraylist.size() ; i++){
            ListId listId=arraylist.get(i);
            int tprice=listId.getPrice();
            int tsell=listId.getSell_price();
            price=price+tprice;
            sell_price=sell_price+tsell;
        }
        int profit=fourth.getSell_price()-fourth.getPrice();
        String ssprice=Integer.toString(fourth.getSell_price());
        String sprice=Integer.toString(fourth.getPrice());
        String sprofit=Integer.toString(profit);

        crtv.setText(ssprice);
        detv.setText(sprice);

        if(profit<0){
            prtv.setText("LOSS");
            pramttv.setText(sprofit);
        }else {
            pramttv.setText(sprofit);
        }




        barChart=view.findViewById(R.id.barchart);
        pieChart=view.findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);

        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        yvalues.add(new Entry(sell_price, 0));
        yvalues.add(new Entry(price, 1));
      /*  yvalues.add(new Entry(profit, 2));*/

        PieDataSet dataSet = new PieDataSet(yvalues, null);

        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add("Credit"); //amt to me
        xVals.add("Debit"); //amt to others
        /*xVals.add("Profit");*/


        dataSet.setColors(ColorTemplate.LIBERTY_COLORS);


        PieData data1 = new PieData(xVals, dataSet);
        data1.setValueFormatter(new PercentFormatter());
        if(price>sell_price){
            pieChart.setDescription("BUSINESS IS FALLING");
        }else {
            pieChart.setDescription("BUSINESS IS RISING");
        }
        pieChart.setData(data1);




/*


        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MM");
        String month_name = month_date.format(cal.getTime());

        int ww=6;//Integer.parseInt(month_name);
        int ff=ww+15;
       int j= ff-4;
        ArrayList<String> labels = new ArrayList<String>();
            for (int i = ff; i > j; i--) {

            switch (i){
                case 13:
                    String qq="oct";
                    labels.add(0,qq);
                    break;
                case 14:
                    String www="nov";
                    labels.add(0,www);
                    break;
                case 15:
                    String eee="dec";
                    labels.add(0,eee);
                    break;
                case 16:
                    String aaa="Jan";
                    labels.add(0,aaa);
                    break;
                case 17:
                    String bbb="feb";
                    labels.add(0,bbb);
                    break;
                case 18:
                    String ccc="mar";
                    labels.add(0,ccc);
                    break;
                case 19:
                    String ddd="apr";
                    labels.add(0,ddd);
                    break;
                case 20:
                    String hhh="may";
                    labels.add(0,hhh);
                    break;
                case 21:
                    String pp="june";
                    labels.add(0,pp);
                    break;
                case 22:
                    String ss="jul";
                    labels.add(0,ss);
                    break;
                case 23:
                    String sd="aug";
                    labels.add(0,sd);
                    break;
                case 24:
                    String fd="sep";
                    labels.add(0,fd);
                    break;
                case 25:
                    String qw="oct";
                    labels.add(0,qw);
                    break;
                case 26:
                    String yu="nov";
                    labels.add(0,yu);
                    break;
                case 27:
                    String ty="dec";
                    labels.add(0,ty);
                    break;

            }
                //labels1.add(i);

            }*/




      /*  int a=10;
        float f= (float) a;*/
        ArrayList<BarEntry> bargroup1 = new ArrayList<>();
        bargroup1.add(new BarEntry(profit1, 0));
        bargroup1.add(new BarEntry(profit2, 1));
        bargroup1.add(new BarEntry(profit3, 2));
        bargroup1.add(new BarEntry(profit4, 3));
        BarDataSet bardataset = new BarDataSet(bargroup1, null);
        BarData data = new BarData(labels, bardataset);
        bardataset.setColors(ColorTemplate.LIBERTY_COLORS);
        barChart.setData(data);

        barChart.setDescription("");
    }
}