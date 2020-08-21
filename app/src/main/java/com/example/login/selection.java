package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class selection extends AppCompatActivity {
    private Spinner catag,locationing;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        catag=(Spinner)findViewById(R.id.catagoryid);
        locationing=(Spinner)findViewById(R.id.locationid);
        b=(Button) findViewById(R.id.finditid);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(selection.this,dooner.class);
                String catagory=catag.getSelectedItem().toString();
                String location=locationing.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(),catagory+location,Toast.LENGTH_SHORT).show();
               intt.putExtra("key", catagory);
                intt.putExtra("key2", location);
                startActivity(intt);




            }
        });




    }
}
