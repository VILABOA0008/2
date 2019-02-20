package com.example.a16pablovc.spinerprobvincias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Spinner spp,spl;
    TextView et;
    private String[] comunidades={"Galicia","Madrid","Extremadura","Pais Vasco",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spp=(Spinner)findViewById(R.id.spp);
        spl=(Spinner)findViewById(R.id.spl);
        et=(TextView) findViewById(R.id.et);
        final ArrayAdapter<String> adapt=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.comunidaedes));


        spp.setAdapter(adapt);
        spp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ArrayAdapter   adapte;
               if(spp.getSelectedItem().toString().equalsIgnoreCase("Galicia")){
                    adapte=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.progal));
                   spl.setAdapter(adapte);
                   Toast.makeText(MainActivity.this,String.valueOf(R.array.progal), Toast.LENGTH_SHORT).show();
               }else

               if(spp.getSelectedItem().toString().equalsIgnoreCase("Extremadura")){
                   adapte=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.proext));
                   spl.setAdapter(adapte);
                   Toast.makeText(MainActivity.this,String.valueOf(R.array.propai), Toast.LENGTH_SHORT).show();
               }else

               if(spp.getSelectedItem().toString().equalsIgnoreCase("Madrid")){

                   adapte=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.promad));
                   spl.setAdapter(adapte);
               }else
               if(spp.getSelectedItem().toString().equalsIgnoreCase("Pais Vasco")){

                   adapte=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.propai));
                   spl.setAdapter(adapte);
               }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    }

