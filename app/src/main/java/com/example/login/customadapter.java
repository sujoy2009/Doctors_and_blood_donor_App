package com.example.login;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class customadapter extends ArrayAdapter<doctor> {
    private Activity context;
  //  public List<doctor> doctorList;
    public ArrayList<doctor>doctorList;


    public customadapter(Activity context, ArrayList<doctor> doctorList) {
        super(context, R.layout.sample, doctorList);
        this.context = context;
        this.doctorList = doctorList;
        //this.arrayList=new ArrayList<doctor>();
       // this.arrayList.addAll(doctorList);


    }
    /*
    public void updater(ArrayList<doctor> dct){
        doctorList=new ArrayList<>();
        doctorList.addAll(dct);
        notifyDataSetChanged();
    }*/

    @NonNull
    @Override
    public View getView(int position, View ConvertView, ViewGroup parent) {
        LayoutInflater layoutInflater =context.getLayoutInflater();


        View view=layoutInflater.inflate(R.layout.sample,null,true);
        doctor dc=doctorList.get(position);

        TextView textView1=view.findViewById(R.id.nmid);
        TextView textView2=view.findViewById(R.id.lcid);
        TextView textView3=view.findViewById(R.id.cnid);
        TextView textView4=view.findViewById(R.id.hnid);
        TextView textView5=view.findViewById(R.id.ctid);
        TextView textView6=view.findViewById(R.id.abid);


        textView1.setText("Name: "+dc.getName());
        textView2.setText("Location: "+dc.getLocation());
        textView3.setText("contact: "+dc.getContact());
        textView4.setText("Detail: "+dc.getHospital_name());
        textView5.setText("Catagory: "+dc.getCatagory());
        textView6.setText("Degrees: "+dc.getAbout());




        return view;
    }








    public void filterlist(ArrayList<doctor> doctors) {
        doctorList=doctors;
        notifyDataSetChanged();;
    }
}
