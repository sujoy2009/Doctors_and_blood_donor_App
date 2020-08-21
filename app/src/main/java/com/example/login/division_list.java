package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class division_list extends AppCompatActivity {
    public Button k,d,r,c,kustiab,satkirab,jessoreb,jenedahb,faridpurb,shariatb,naraynb,madarib,gazib;
    public Button gopalib,tangailb,narsingdib,kisorb,bagurab,natorb,pabnab,bandorb,noakhalib,rangamatib,coxb,rangpurb,syletb;
    String cata;
   // public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division_list);
        getSupportActionBar().setTitle("     Location");

       // context=this;
        k=(Button)findViewById(R.id.khid);
        kustiab=(Button)findViewById(R.id.kustiaid);
        satkirab=(Button)findViewById(R.id.satkhiraid);
        jessoreb=(Button)findViewById(R.id.jessoreid);
        jenedahb=(Button)findViewById(R.id.jhenaidahid);

        d=(Button)findViewById(R.id.dhid);

         faridpurb=(Button)findViewById(R.id.faridpurid);
          tangailb=(Button)findViewById(R.id.tangailid);
           gopalib=(Button)findViewById(R.id.gopalgonjid);
           narsingdib =(Button)findViewById(R.id.narsingdiid);
            shariatb =(Button)findViewById(R.id.shariatpurid);
            naraynb=(Button)findViewById(R.id.narayanganjid);
            madarib=(Button)findViewById(R.id.madaripurid);
             gazib=(Button)findViewById(R.id.gazipurid);
              kisorb=(Button)findViewById(R.id.kishoreganjid);


        r=(Button)findViewById(R.id.rajid);
        bagurab=(Button)findViewById(R.id.boguraid);
         natorb=(Button)findViewById(R.id.natoreid);
          pabnab=(Button)findViewById(R.id.pabnaid);

        c=(Button)findViewById(R.id.chitid);
         bandorb=(Button)findViewById(R.id.bandorbonid);
          noakhalib=(Button)findViewById(R.id.noakhaliid);
           bandorb=(Button)findViewById(R.id.bandorbonid);
            coxb=(Button)findViewById(R.id.coxid);
             rangamatib=(Button)findViewById(R.id.rangamatiid);
              rangpurb=(Button)findViewById(R.id.rangpurid);
               syletb=(Button)findViewById(R.id.sylhetid);
        Bundle bundle=new Bundle();
         bundle=getIntent().getExtras();

        if(bundle!=null){
            cata=bundle.getString("key");
            Toast.makeText(getApplicationContext(),"catagory:"+cata,Toast.LENGTH_SHORT).show();


        }
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Dhaka");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Khulna");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Rajshahi");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Chattogram");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });
        kustiab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Kushtia");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");


                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });
          satkirab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Satkhira");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

            jessoreb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Jessore");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

              jenedahb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Jhenaidah");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                faridpurb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Faridpur");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                  gopalib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Gopalgonj");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                    tangailb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Tangail");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                      narsingdib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Narsingdi");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                        shariatb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Shariatpur");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                          naraynb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Narayanganj");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                startActivity(intent);

            }
        });
                            madarib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Madaripur");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                              gazib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Gazipur");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                                kisorb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Kishoreganj");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                                  bagurab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Bogura");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                                    natorb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Natore");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                                      pabnab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Pabna");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                                        bandorb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Bandorbon");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                                          noakhalib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Noakhali");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                                            rangamatib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Rangamati");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

                                              coxb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","cox.s_Bazar");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

        rangpurb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Rangpur");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });

        syletb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(division_list.this, detail.class);
                intent.putExtra("key2","Sylhet");
                if(cata.equalsIgnoreCase("medicine")) {
                    intent.putExtra("key", "medicine");

                }
                if(cata.equalsIgnoreCase("neurologist")){
                    intent.putExtra("key","neurologist");

                }
                if(cata.equalsIgnoreCase("psychiatris")){
                    intent.putExtra("key","psychiatrist");

                }
                if(cata.equalsIgnoreCase("general_sergeon")){
                    intent.putExtra("key","general_sergeon");

                }
                if(cata.equalsIgnoreCase("cardiologist")){
                    intent.putExtra("key","cardiologist");

                }
                if(cata.equalsIgnoreCase("urologist")){
                    intent.putExtra("key","urologist");

                }
                if(cata.equalsIgnoreCase("dentist")){
                    intent.putExtra("key","dentist");

                }
                if(cata.equalsIgnoreCase("podiatrists")){
                    intent.putExtra("key","podiatrists");

                }
                if(cata.equalsIgnoreCase("gynecologist")){
                    intent.putExtra("key","gynecologist");

                }
                if(cata.equalsIgnoreCase("breast_surgeon")){
                    intent.putExtra("key","breast_surgeon");

                }
                if(cata.equalsIgnoreCase("chest_specialist")){
                    intent.putExtra("key","chest_specialist");

                }
                if(cata.equalsIgnoreCase("child_specialist")){
                    intent.putExtra("key","child_specialist");

                }
                if(cata.equalsIgnoreCase("eye_specialist")){
                    intent.putExtra("key","eye_specialist");

                }
                if(cata.equalsIgnoreCase("heart_specialist")){
                    intent.putExtra("key","heart_specialist");

                }


                if(cata.equalsIgnoreCase("alldoctor")){
                    intent.putExtra("key","alldoctor");

                }


                startActivity(intent);

            }
        });








    }
}
