package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class show_theme extends AppCompatActivity implements View.OnClickListener {

    //public Button pb;
    public Button mb;
    public Button nb;
    public   Button adb;
    public Button gsb;
    public Button cb;
    public Button psychiatristb,urologistb,dentistb,podiatristsb,gynecologistb,breast_surgeonb,chest_specialistb,child_specialistb,eye_specialistb,heart_specialistb;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_theme);
        getSupportActionBar().setTitle("    Catagory  ");
        mb=(Button)findViewById(R.id.mid);
        //pb=(Button)findViewById(R.id.pid);
        nb=(Button)findViewById(R.id.nrid);
        gsb=(Button)findViewById(R.id.gid);
        cb=(Button)findViewById(R.id.cid);

        psychiatristb=(Button)findViewById(R.id.psychiatrisid);
        urologistb=(Button)findViewById(R.id.urologistid);
        dentistb=(Button)findViewById(R.id.dentistid);
        podiatristsb=(Button)findViewById(R.id.podiatristsid);
        gynecologistb=(Button)findViewById(R.id.gynecologistid);
        breast_surgeonb=(Button)findViewById(R.id.breast_surgeonid);
        chest_specialistb=(Button)findViewById(R.id.chest_specialistid);
        child_specialistb=(Button)findViewById(R.id.child_specialistid);
        eye_specialistb=(Button)findViewById(R.id.eye_specialistid);
        heart_specialistb=(Button)findViewById(R.id.eye_specialistid);
        adb=(Button)findViewById(R.id.adid);




        mb.setOnClickListener(this);
       // pb.setOnClickListener(this);
        nb.setOnClickListener(this);
        gsb.setOnClickListener(this);
        cb.setOnClickListener(this);
        adb.setOnClickListener(this);
        psychiatristb.setOnClickListener(this);
        urologistb.setOnClickListener(this);
        dentistb.setOnClickListener(this);
        podiatristsb.setOnClickListener(this);
        gynecologistb.setOnClickListener(this);
        breast_surgeonb.setOnClickListener(this);
        chest_specialistb.setOnClickListener(this);
        child_specialistb.setOnClickListener(this);
        eye_specialistb.setOnClickListener(this);
        heart_specialistb.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.mid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "medicine");
                startActivity(intent);
                break;


            case R.id.cid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "cardiologist");
                startActivity(intent);
                break;
            case R.id.nrid:
                Intent intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "neurologist");
                startActivity(intent);
                break;
            case R.id.gid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "general_sergeon");
                startActivity(intent);
                break;

            case R.id.urologistid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "urologist");
                startActivity(intent);
                break;
            case R.id.psychiatrisid:

                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "psychiatris");
                startActivity(intent);
                break;
            case R.id.adid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "alldoctor");
                startActivity(intent);
                break;
            case R.id.dentistid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "dentist");
                startActivity(intent);
                break;
            case R.id.podiatristsid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "podiatrists");
                startActivity(intent);
                break;
            case R.id.gynecologistid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "gynecologist");
                startActivity(intent);
                break;
            case R.id.chest_specialistid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "chest_specialist");
                startActivity(intent);
                break;
            case R.id.child_specialistid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "child_specialist");
                startActivity(intent);
                break;
            case R.id.breast_surgeonid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "breast_specialist");
                startActivity(intent);
                break;
            case R.id.eye_specialistid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "eye_specialist");
                startActivity(intent);
                break;
            case R.id.heart_specialistid:
                intent = new Intent(show_theme.this, division_list.class);
                intent.putExtra("key", "heart_specialist");
                startActivity(intent);
                break;


        }
    }



}
