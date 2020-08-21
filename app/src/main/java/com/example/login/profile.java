package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class profile extends AppCompatActivity {
    FirebaseAuth mauth;
    private Button savebutton,showbutton,findbutton;
    private Button savebutton2,showbutton2,findbutton2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        mauth=FirebaseAuth.getInstance();
        savebutton=(Button)findViewById(R.id.savedatabid);
        showbutton=(Button)findViewById(R.id.showdatabid);
        findbutton=(Button)findViewById(R.id.findid);

        savebutton2=(Button)findViewById(R.id.bloodregid);
        showbutton2=(Button)findViewById(R.id.findbloodid);
        findbutton2=(Button)findViewById(R.id.upbloodid);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(profile.this,datasave.class);
                startActivity(intent);

            }
        });


        savebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(profile.this,datasave2.class);
                startActivity(intent);

            }
        });
        showbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(profile.this,selection.class);
                startActivity(intt);

            }
        });
        showbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt=new Intent(profile.this,show_theme.class);
                startActivity(intt);

            }
        });
        findbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inttt=new Intent(profile.this,find.class);
                startActivity(inttt);

            }
        });
        findbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inttt=new Intent(profile.this,dateupdate.class);
                startActivity(inttt);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.helpid)
        {
            Intent inttt=new Intent(profile.this,helper.class);
            startActivity(inttt);
        }
        else if(item.getItemId()==R.id.shareid)
        {
            Intent inttt=new Intent(Intent.ACTION_SEND);
            inttt.setType("text/plain");
            String subject="An app to find your nearby doctors and blood dooners";
            String body=" Doctors and blood bd.\nAn app to find your nearby doctors and blood dooners.\n Download it\n https://play.google.com/store/apps/details?id=com.example.login";
            inttt.putExtra(Intent.EXTRA_SUBJECT,subject);
            inttt.putExtra(Intent.EXTRA_TEXT,body);


            startActivity(Intent.createChooser(inttt,"Share with"));
        }
        return super.onOptionsItemSelected(item);
    }
}
