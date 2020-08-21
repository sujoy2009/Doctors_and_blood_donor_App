package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class find extends AppCompatActivity {
    EditText fi;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        fi=(EditText)findViewById(R.id.finding);
        b=(Button)findViewById(R.id.fb);
         String BMDCIS=fi.getText().toString().trim();
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
                    fi.setHint("  Enter your BMDC");
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((fi.getText().toString()).isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please Enter your bmdc",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(find.this, detail.class);
                    intent.putExtra("key", "bmdc");
                    intent.putExtra("real",fi.getText().toString());


                    startActivity(intent);

                }



            }
        });

    }
}
