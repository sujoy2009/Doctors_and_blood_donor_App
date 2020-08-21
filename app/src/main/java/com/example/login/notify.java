package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class notify extends AppCompatActivity {
   private Button button,b2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
      final   String pr;

        Bundle bundle=new Bundle();
        bundle= getIntent().getExtras();

          pr=bundle.getString("note");
        getSupportActionBar().setTitle("  Notification ");





        button=(Button)findViewById(R.id.checkid);
        b2=(Button)findViewById(R.id.backid);

        button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              try{
                  Bundle bundle=new Bundle();
                  bundle= getIntent().getExtras();
                  Intent intent=new Intent(notify.this, find.class);
                //  intent.putExtra("real", pr) ;

                startActivity(intent);

              }
              catch (NullPointerException ignored){

              }



          }
      });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(notify.this, profile.class);
                //  intent.putExtra("real", pr) ;

                startActivity(intent);

            }
        });

    }
}
