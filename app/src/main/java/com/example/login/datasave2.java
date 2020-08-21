package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import es.dmoral.toasty.Toasty;

public class datasave2 extends AppCompatActivity {
    private Button saving;
    private EditText naming,contacting,about,pin;
    private Spinner catag,locationing;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datasave2);

        naming=(EditText)findViewById(R.id.nameid);
        pin=(EditText)findViewById(R.id.pinid);
       // bmdc=(EditText)findViewById(R.id.bmdcid);
        locationing=(Spinner)findViewById(R.id.locationid);
        contacting=(EditText)findViewById(R.id.contactid);
        about=(EditText)findViewById(R.id.aboutid) ;
        //hos=(EditText)findViewById(R.id.hospitalid);
        catag=(Spinner)findViewById(R.id.catagoryid);
        catag.setPrompt("Catagory");
        locationing.setPrompt("Location");
        saving=(Button)findViewById(R.id.saveitid);
        getSupportActionBar().setTitle(" Registration form");







        naming.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                naming.setHint("");
                return false;
            }
        });
        naming.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    naming.setHint("  Enter name");
                }
            }
        });
        pin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pin.setHint("");
                return false;
            }
        });
        pin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    pin.setHint("  Enter a pin");
                }
            }
        });

        contacting.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                contacting.setHint("");
                return false;
            }
        });
        contacting.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    contacting.setHint("  Enter contect number");
                }
            }
        });
        about.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                about.setHint("");
                return false;
            }
        });
        about.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    about.setHint("  Enter contect number");
                }
            }
        });




        databaseReference= FirebaseDatabase.getInstance().getReference("doctors");
        saving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkcoon();
                //savefunction();

            }
        });
    }


    private void savefunction() {


        String name=naming.getText().toString().toLowerCase().trim();

        //String location=locationing.getText().toString().trim();
        String contact=contacting.getText().toString().trim();
        String hospital_name="A";
        String pin_num=pin.getText().toString().trim();
        String bmdc_num="A";
        String catagory=catag.getSelectedItem().toString();
        String location=locationing.getSelectedItem().toString();


        String abt=about.getText().toString().trim();
        String all=catagory+location;
        String key=databaseReference.push().getKey();
        if(name.isEmpty() || hospital_name.isEmpty() ||contact.isEmpty() || pin_num.isEmpty() || bmdc_num.isEmpty() || catagory.isEmpty() || location.isEmpty()){

            Toasty.warning(this,"Please enter all information above",Toast.LENGTH_LONG).show();
        }
        else {
            if(pin_num.length()<4)
            {
                //Toast.makeText(getApplicationContext(), "BMDC number is Invalid", Toast.LENGTH_SHORT).show();
                Toasty.error(this,"pin number must be at least 4 digit",Toast.LENGTH_LONG).show();
            }
            else {
                doctor dc = new doctor(key, name, hospital_name, location, contact, catagory, abt, all, pin_num, bmdc_num);
                databaseReference.child(key).setValue(dc);

                // Toast.makeText(getApplicationContext(), "Registration successfull", Toast.LENGTH_SHORT).show();
                Toasty.success(this,"Registration successfull",Toast.LENGTH_SHORT).show();
               // hos.setText("");
                naming.setText("");
                about.setText("");
                contacting.setText("");
                pin.setText("");
               // bmdc.setText("");



            }




            // hos.setText("");
            //  about.setText("");
            ///contacting.setText("");
            // pin.setText("");
            // bmdc.setText("");
        }



    }

    public void  checkcoon() {
        ConnectivityManager manager=(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork=manager.getActiveNetworkInfo();
        if(null==activeNetwork){

            Toasty.warning(this,"No internet connection",Toast.LENGTH_LONG).show();

        }
        else {
            savefunction();

        }

    }



}
