package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class dooner extends AppCompatActivity {

    private ListView lv;
    // public static Context context;

    DatabaseReference databaseReference;

    private ArrayList<doctor> doctorList;

    private myadd ma;
    public String nameup;
    public  String id;
    public int flag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dooner);



        lv = (ListView) findViewById(R.id.lkkid);
        databaseReference = FirebaseDatabase.getInstance().getReference("doctors");
        Bundle bundle=new Bundle();
        bundle= getIntent().getExtras();
        String ctg=new String() ;
        String LC=new String();
        String B=new String();





        Query query = FirebaseDatabase.getInstance().getReference("doctors");


        ctg = bundle.getString("key");
        LC=bundle.getString("key2");
        B=bundle.getString("real");
        getSupportActionBar().setTitle(ctg+" dooners, "+LC);
        //Toast.makeText(getApplicationContext(),ctg+ B,Toast.LENGTH_SHORT).show();

        checkcoon();
        if(ctg.equalsIgnoreCase("update")){
            if(flag==1){
                Toasty.info(this,"please wait a moment",Toast.LENGTH_SHORT).show();
                Toasty.info(this,"Long press on your detail to update",Toast.LENGTH_LONG).show();

            }


        }
        try {



            if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Khulna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Khulna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Dhaka")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Dhaka");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Kushtia")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Kushtia");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Satkhira")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Satkhira");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Jessore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Jessore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Jhenaidah")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Jhenaidah");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Faridpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Faridpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Gopalgonj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Gopalgonj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Tangail")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Tangail");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Narsingdi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Narsingdi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Shariatpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Shariatpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Narayanganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Narayanganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Madaripur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Madaripur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Gazipur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Gazipur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Kishoreganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Kishoreganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Rajshahi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Rajshahi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Bogura")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Bogura");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Natore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Natore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Pabna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Pabna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Chattogram")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Chattogram");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Bandorbon")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Bandorbon");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Noakhali")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Noakhali");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Rangamati")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Rangamati");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Cox.s_Bazar");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Rangpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Rangpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Sylhet")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B+Sylhet");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if(ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Khulna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Khulna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Dhaka")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Dhaka");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Kushtia")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Kushtia");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Satkhira")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Satkhira");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Jessore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Jessore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Jhenaidah")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Jhenaidah");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Faridpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Faridpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Gopalgonj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Gopalgonj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Tangail")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Tangail");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Narsingdi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Narsingdi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Shariatpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Shariatpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Narayanganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Narayanganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Madaripur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Madaripur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Gazipur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Gazipur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Kishoreganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Kishoreganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Rajshahi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Rajshahi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Bogura")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Bogura");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Natore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Natore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Pabna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Pabna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Chattogram")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Chattogram");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Bandorbon")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Bandorbon");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Noakhali")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Noakhali");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Rangamati")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Rangamati");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Cox.s_Bazar");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Rangpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Rangpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B-") && LC.equalsIgnoreCase("Sylhet")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("B-Sylhet");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if(ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Khulna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Khulna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Dhaka")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Dhaka");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Kushtia")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Kushtia");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Satkhira")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Satkhira");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Jessore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Jessore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Jhenaidah")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Jhenaidah");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Faridpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Faridpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Gopalgonj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Gopalgonj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Tangail")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Tangail");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Narsingdi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Narsingdi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Shariatpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Shariatpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Narayanganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Narayanganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Madaripur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Madaripur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Gazipur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Gazipur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Kishoreganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Kishoreganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Rajshahi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Rajshahi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Bogura")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Bogura");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Natore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Natore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Pabna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Pabna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Chattogram")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Chattogram");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Bandorbon")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Bandorbon");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Noakhali")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Noakhali");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Rangamati")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Rangamati");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Cox.s_Bazar");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Rangpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Rangpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A+") && LC.equalsIgnoreCase("Sylhet")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A+Sylhet");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if(ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Khulna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Khulna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Dhaka")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Dhaka");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Kushtia")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Kushtia");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Satkhira")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Satkhira");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Jessore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Jessore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Jhenaidah")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Jhenaidah");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Faridpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Faridpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Gopalgonj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Gopalgonj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Tangail")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Tangail");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Narsingdi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Narsingdi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Shariatpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Shariatpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Narayanganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Narayanganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Madaripur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Madaripur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Gazipur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Gazipur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Kishoreganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Kishoreganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Rajshahi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Rajshahi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Bogura")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Bogura");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Natore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Natore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Pabna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Pabna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Chattogram")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Chattogram");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Bandorbon")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Bandorbon");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Noakhali")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Noakhali");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Rangamati")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Rangamati");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Cox.s_Bazar");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Rangpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Rangpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("A-") && LC.equalsIgnoreCase("Sylhet")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("A-Sylhet");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if(ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Khulna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Khulna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Dhaka")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Dhaka");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Kushtia")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Kushtia");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Satkhira")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Satkhira");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Jessore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Jessore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Jhenaidah")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Jhenaidah");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Faridpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Faridpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Gopalgonj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Gopalgonj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Tangail")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Tangail");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Narsingdi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Narsingdi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Shariatpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Shariatpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Narayanganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Narayanganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Madaripur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Madaripur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Gazipur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Gazipur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Kishoreganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Kishoreganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Rajshahi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Rajshahi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Bogura")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Bogura");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Natore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Natore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Pabna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Pabna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Chattogram")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Chattogram");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Bandorbon")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Bandorbon");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Noakhali")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Noakhali");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Rangamati")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Rangamati");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Cox.s_Bazar");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Rangpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Rangpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O+") && LC.equalsIgnoreCase("Sylhet")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O+Sylhet");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if(ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Khulna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Khulna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Dhaka")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Dhaka");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Kushtia")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Kushtia");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Satkhira")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Satkhira");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Jessore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Jessore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Jhenaidah")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Jhenaidah");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Faridpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Faridpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("B+") && LC.equalsIgnoreCase("Gopalgonj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Gopalgonj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Tangail")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Tangail");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Narsingdi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Narsingdi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Shariatpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Shariatpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Narayanganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Narayanganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Madaripur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Madaripur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Gazipur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Gazipur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Kishoreganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Kishoreganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Rajshahi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Rajshahi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Bogura")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Bogura");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Natore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Natore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Pabna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Pabna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Chattogram")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Chattogram");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Bandorbon")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Bandorbon");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Noakhali")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Noakhali");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Rangamati")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Rangamati");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Cox.s_Bazar");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Rangpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Rangpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("O-") && LC.equalsIgnoreCase("Sylhet")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("O-Sylhet");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if(ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Khulna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Khulna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Dhaka")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Dhaka");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Kushtia")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Kushtia");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Satkhira")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Satkhira");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Jessore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Jessore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Jhenaidah")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Jhenaidah");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Faridpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Faridpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Gopalgonj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Gopalgonj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Tangail")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Tangail");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Narsingdi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Narsingdi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Shariatpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Shariatpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Narayanganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Narayanganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Madaripur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Madaripur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Gazipur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Gazipur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Kishoreganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Kishoreganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Rajshahi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Rajshahi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Bogura")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Bogura");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Natore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Natore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Pabna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Pabna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Chattogram")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Chattogram");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Bandorbon")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Bandorbon");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Noakhali")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Noakhali");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Rangamati")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Rangamati");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Cox.s_Bazar");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Rangpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Rangpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB+") && LC.equalsIgnoreCase("Sylhet")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB+Sylhet");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if(ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Khulna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Khulna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }

            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Dhaka")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Dhaka");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Kushtia")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Kushtia");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Satkhira")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Satkhira");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Jessore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Jessore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            } else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Jhenaidah")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Jhenaidah");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Faridpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Faridpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Gopalgonj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Gopalgonj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Tangail")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Tangail");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Narsingdi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Narsingdi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Shariatpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Shariatpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Narayanganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Narayanganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Madaripur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Madaripur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Gazipur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Gazipur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Kishoreganj")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Kishoreganj");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Rajshahi")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Rajshahi");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Bogura")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Bogura");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Natore")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Natore");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Pabna")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Pabna");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Chattogram")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Chattogram");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Bandorbon")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Bandorbon");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Noakhali")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Noakhali");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Rangamati")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Rangamati");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Cox.s_Bazar");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Rangpur")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Rangpur");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }
            else if (ctg.equalsIgnoreCase("AB-") && LC.equalsIgnoreCase("Sylhet")) {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("all")
                        .equalTo("AB-Sylhet");

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);
                        if(ma.isEmpty()){

                            Toast.makeText(getApplicationContext(),"No dooner is registered in this scope yet",Toast.LENGTH_SHORT).show();

                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();

                //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);

            }



            else if (ctg.equalsIgnoreCase("update"))  {


                query = FirebaseDatabase.getInstance().getReference("doctors")
                        .orderByChild("name").equalTo(B);
                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        doctorList.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            doctor dc = dataSnapshot1.getValue(doctor.class);
                            doctorList.add(dc);
                        }
                        lv.setAdapter(ma);

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                super.onStart();
                doctorList = new ArrayList<>();
                ma = new myadd(dooner.this, doctorList);
                lv = (ListView) findViewById(R.id.lkkid);
                lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        doctor dc = doctorList.get(i);
                        showUpdateDeleteDialog(dc.getId(),dc.getName(),dc.getPin(),dc.getCatagory());
                        nameup=dc.getName();
                        id=dc.getId();



                        return false;
                    }
                });


            }


        }
        catch (NullPointerException ignored){

        }


    }
    public void  checkcoon() {
        ConnectivityManager manager=(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork=manager.getActiveNetworkInfo();
        if(null==activeNetwork){
            // Toast.makeText(this,"No internet connection",Toast.LENGTH_LONG).show();
            Toasty.warning(this,"No internet connection", Toast.LENGTH_SHORT).show();
            flag=0;

        }
        else {
            // Toast.makeText(this,"Please wait a moment",Toast.LENGTH_LONG).show();
            Toasty.warning(this,"Please wait a moment",Toast.LENGTH_SHORT).show();





        }

    }
    private void showUpdateDeleteDialog(final String id, final String name,final String oldpin,final  String catagory) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update2, null);
        dialogBuilder.setView(dialogView);

        final Spinner loc = (Spinner) dialogView.findViewById(R.id.uplocationid);
        //final Spinner cata = (Spinner) dialogView.findViewById(R.id.upcatagoryid);
        final EditText editTextcontact = (EditText) dialogView.findViewById(R.id.upcontactid);
        final EditText about = (EditText) dialogView.findViewById(R.id.upaboutid);
       // final EditText newhospital = (EditText) dialogView.findViewById(R.id.uphospitalid);
        final EditText pin = (EditText) dialogView.findViewById(R.id.uppinid);
       // final EditText newbmdc = (EditText) dialogView.findViewById(R.id.upbmdcid);


        final Button updatebutton = (Button) dialogView.findViewById(R.id.updateitid);

        dialogBuilder.setTitle("editing   " + name+" profile detail");

        final AlertDialog b = dialogBuilder.create();
        b.show();
        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newloc=loc.getSelectedItem().toString();
                String cnt = editTextcontact.getText().toString();
                String abt=about.getText().toString();
                String pinned=pin.getText().toString();
                 String bmdced="A";
               String hsp="A";
                String ctg=catagory;

                if ((!TextUtils.isEmpty(cnt))&&(oldpin.equalsIgnoreCase(pinned))) {
                    updateArtist(id,name,cnt,newloc, abt,ctg,hsp,pinned,bmdced);
                    b.dismiss();
                }
                else if ((!TextUtils.isEmpty(cnt))&&(!(oldpin.equalsIgnoreCase(pinned)))) {
                    Toast.makeText(getApplicationContext(),"Enter the right passward",Toast.LENGTH_SHORT).show();


                    //b.dismiss();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Enter all information avobe",Toast.LENGTH_SHORT).show();
                    // Toasty.warning(this,"Enter all information avobe",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    private boolean updateArtist(String id,String name,String cnt, String newloc,String abt,String ctg,String hsp,String pinned,String bmdc) {
        String all = ctg +newloc ;

        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("doctors").child(id);

        //updating artist
        doctor dc = new doctor(id,name,hsp,newloc,cnt,ctg,abt,all,pinned,bmdc);
        //dR.removeValue();
        dR.setValue(dc);
        //Toast.makeText(getApplicationContext(), "profile Updated", Toast.LENGTH_LONG).show();
        Toasty.warning(this,"profile Updated",Toast.LENGTH_SHORT).show();
        Intent inttt=new Intent(dooner.this,profile.class);
        startActivity(inttt);
        return true;
    }
}
