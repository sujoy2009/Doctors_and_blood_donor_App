package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dateupdate extends AppCompatActivity {
    EditText fi;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dateupdate);
        fi=(EditText)findViewById(R.id.finding);
        b=(Button)findViewById(R.id.fb);
       // String BMDCIS=fi.getText().toString().trim();
        getSupportActionBar().setTitle(" Profile ");

        fi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                fi.setHint("");
                return false;
            }
        });
        fi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    fi.setHint("  Enter your name");
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((fi.getText().toString()).isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(dateupdate.this, dooner.class);
                    intent.putExtra("key", "update");
                    intent.putExtra("real",fi.getText().toString().toLowerCase());
                    Toast.makeText(getApplicationContext(),fi.getText().toString().toLowerCase(),Toast.LENGTH_SHORT).show();




                    startActivity(intent);

                }



            }
        });

    }
}
