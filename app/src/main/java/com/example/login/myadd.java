package com.example.login;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class myadd extends ArrayAdapter <doctor>{
    private Activity context;
    //  public List<doctor> doctorList;
    public ArrayList<doctor> doctorList;


    public myadd(Activity context, ArrayList<doctor> doctorList) {
        super(context, R.layout.sample2, doctorList);
        this.context = context;
        this.doctorList = doctorList;
        //this.arrayList=new ArrayList<doctor>();
        // this.arrayList.addAll(doctorList);


    }
    @NonNull
    @Override
    public View getView(int position, View ConvertView, ViewGroup parent) {
        LayoutInflater layoutInflater =context.getLayoutInflater();


        View view=layoutInflater.inflate(R.layout.sample2,null,true);
        doctor dc=doctorList.get(position);

        TextView textView4=view.findViewById(R.id.nmid);
        TextView textView2=view.findViewById(R.id.lcid);
        TextView textView3=view.findViewById(R.id.cnid);

        TextView textView5=view.findViewById(R.id.hnid);




        textView4.setText("Name: "+dc.getName());
        textView2.setText("Location: "+dc.getLocation());
        textView3.setText("contact: "+dc.getContact());

        textView5.setText("Last blood doonated: "+dc.getAbout());





        return view;
    }

}
