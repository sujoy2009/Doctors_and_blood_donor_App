package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
 import android.view.inputmethod.InputConnection;

import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class detail extends AppCompatActivity  {

    private ListView lv;
   // public static Context context;

    DatabaseReference databaseReference;

    private ArrayList<doctor> doctorList;

    private customadapter ca;
    public String nameup;
    public  String id;
    public int flag=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khulna);







        lv = (ListView) findViewById(R.id.lkid);
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
            if(ctg.equalsIgnoreCase("bmdc")){
                getSupportActionBar().setTitle("Your profie ");

            }
            else if(ctg.equalsIgnoreCase("alldoctor")){
                getSupportActionBar().setTitle(" Alldoctors of "+LC);

            }
            else{
                getSupportActionBar().setTitle(ctg+" Doctors, "+LC);

            }


        //Toast.makeText(getApplicationContext(),"cata:  "+ctg+ "  location "+LC,Toast.LENGTH_SHORT).show();
        checkcoon();
        if(ctg.equalsIgnoreCase("bmdc")){
            if(flag==1){
                Toasty.info(this,"please wait a moment",Toast.LENGTH_SHORT).show();
                Toasty.info(this,"Long press on your detail to update",Toast.LENGTH_LONG).show();

            }


        }
            try {


                if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineKhulna");

                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){
                               // Toast.makeText(getApplicationContext(),"কোন ডাক্তার এখনো রেজিষ্ট্রেশন করে নি এখানে",Toast.LENGTH_SHORT).show();
                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                    //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                    lv = (ListView) findViewById(R.id.lkid);
                    lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                        @Override
                        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                            doctor dc = doctorList.get(i);
                            showUpdateDeleteDialog(dc.getId(),dc.getName(),dc.getPin());
                            nameup=dc.getName();
                            id=dc.getId();

                            return false;
                        }
                    });


                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){
                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);






                } else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);





                } else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicinePabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }

                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }

                else if (ctg.equalsIgnoreCase("medicine") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);






                } else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);





                } else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }

                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }

                else if (ctg.equalsIgnoreCase("cardiologist") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("cardiologistSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }

                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);






                } else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                } else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("neurologist") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("neurologistSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);
                    if(ca.isEmpty()){

                        Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                    }





                } else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                } else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){
                               // Toast.makeText(getApplicationContext(),"কোন ডাক্তার এখনো রেজিষ্ট্রেশন করে নি এখানে",Toast.LENGTH_SHORT).show();
                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }


                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }

                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("general_sergeon") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("general_sergeonSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatrisKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                } else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                } else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("psychiatrist") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("psychiatristSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);





                } else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                } else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("urologist") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("urologistSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);





                } else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                } else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();   doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("dentist") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("dentistSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);





                } else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            if(ca.isEmpty()){

                                Toast.makeText(getApplicationContext(),"No doctor is registered in this scope yet",Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                } else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("podiatrists") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("podiatristsSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);





                } else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                } else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("gynecologist") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("gynecologistSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);





                } else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                } else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("breast_surgeon") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("breast_surgeonSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }

                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);
                            doctorList = new ArrayList<>();
                            ca = new customadapter(detail.this, doctorList);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                } else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                } else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }

                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }

                else if (ctg.equalsIgnoreCase("chest_specialist") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("chest_specialistSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                } else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                } else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }

                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }

                else if (ctg.equalsIgnoreCase("child_specialist") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("child_specialistSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                } else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                } else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }

                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }

                else if (ctg.equalsIgnoreCase("eye_specialist") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("eye_specialistSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }


                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Khulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Dhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);




                } else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Rajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);



                } else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Chattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);


                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Kushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Satkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Jessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Jhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Faridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Gopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Tangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Narsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Shariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Narayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Madaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Gazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Kishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Bogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Natore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Pabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Bandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Noakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Rangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Cox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }

                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Rangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }

                else if (ctg.equalsIgnoreCase("alldoctor") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("location")
                            .equalTo("Sylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                }
                if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Khulna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistKhulna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                    //databaseReference2= FirebaseDatabase.getInstance().getReference("doctorss");
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);

                    lv = (ListView) findViewById(R.id.lkid);
                    lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                        @Override
                        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                            doctor dc = doctorList.get(i);
                            showUpdateDeleteDialog(dc.getId(),dc.getName(),dc.getPin());
                            nameup=dc.getName();
                            id=dc.getId();

                            return false;
                        }
                    });


                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Dhaka")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistDhaka");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();




                } else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Rajshahi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistRajshahi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();



                } else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Chattogram")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistChattogram");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();


                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Kushtia")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistKushtia");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Satkhira")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistSatkhira");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Jessore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistJessore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Jhenaidah")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistJhenaidah");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Faridpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistFaridpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Gopalgonj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistGopalgonj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Tangail")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistTangail");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Narsingdi")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistNarsingdi");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Shariatpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistShariatpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Narayanganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistNarayanganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Madaripur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistMadaripur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Gazipur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistGazipur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Kishoreganj")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistKishoreganj");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Bogura")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistBogura");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Natore")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistNatore");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Pabna")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistPabna");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Bandorbon")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineBandorbon");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);


                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Noakhali")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineNoakhali");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Rangamati")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("medicineRangamati");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Cox.s_Bazar")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistCox.s_Bazar");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }

                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Rangpur")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistRangpur");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }

                else if (ctg.equalsIgnoreCase("heart_specialist") && LC.equalsIgnoreCase("Sylhet")) {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("all")
                            .equalTo("heart_specialistSylhet");
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();

                }
                else if (ctg.equalsIgnoreCase("bmdc"))  {


                    query = FirebaseDatabase.getInstance().getReference("doctors")
                            .orderByChild("bmdc")
                            .equalTo(B);
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            doctorList.clear();
                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                doctor dc = dataSnapshot1.getValue(doctor.class);
                                doctorList.add(dc);
                            }
                            lv.setAdapter(ca);

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    super.onStart();
                    doctorList = new ArrayList<>();
                    ca = new customadapter(detail.this, doctorList);
                    lv = (ListView) findViewById(R.id.lkid);
                    lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                        @Override
                        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                            doctor dc = doctorList.get(i);
                            showUpdateDeleteDialog(dc.getId(),dc.getName(),dc.getPin());
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
            Toasty.warning(this,"No internet connection",Toast.LENGTH_SHORT).show();
             flag=0;

        }
        else {
           // Toast.makeText(this,"Please wait a moment",Toast.LENGTH_LONG).show();
            Toasty.warning(this,"Please wait a moment",Toast.LENGTH_SHORT).show();





        }

    }






    private void showUpdateDeleteDialog(final String id, final String name,final String oldpin) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update, null);
        dialogBuilder.setView(dialogView);

        final Spinner loc = (Spinner) dialogView.findViewById(R.id.uplocationid);
        final Spinner cata = (Spinner) dialogView.findViewById(R.id.upcatagoryid);
        final EditText editTextcontact = (EditText) dialogView.findViewById(R.id.upcontactid);
        final EditText about = (EditText) dialogView.findViewById(R.id.upaboutid);
        final EditText newhospital = (EditText) dialogView.findViewById(R.id.uphospitalid);
        final EditText pin = (EditText) dialogView.findViewById(R.id.uppinid);
        final EditText newbmdc = (EditText) dialogView.findViewById(R.id.upbmdcid);


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
                String bmdced=newbmdc.getText().toString();
                String hsp=newhospital.getText().toString();
                String ctg=cata.getSelectedItem().toString();

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
        Intent inttt=new Intent(detail.this,profile.class);
        startActivity(inttt);
        return true;
    }
    /*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.searchid);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<doctor> dct=new ArrayList<>();
                for(doctor x:doctorList){
                    if(x.getName().contains(s));
                    dct.add(x);
                    ((customadapter) lv.getAdapter()).updater(dct);
                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }*/

}

