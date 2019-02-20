package com.example.a16pablovc.spinerprobvincias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
AutoCompleteTextView spp;
    Spinner spl;
    TextView et;



/*

    spi=(AutoCompleteTextView)findViewById(R.id.spi);
    final ArrayAdapter<String> array=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.nombre));
    //  array=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.nombre));


    spi.setAdapter(array);
    spi.setThreshold(1);

    */


    private String[] comunidades={"Galicia","Madrid","Extremadura","Pais Vasco",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spl=(Spinner)findViewById(R.id.spl);
        spp=(AutoCompleteTextView)findViewById(R.id.spp);

        et=(TextView) findViewById(R.id.et);
        final ArrayAdapter<String> adapt=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.comunidaedes));
        spp.setAdapter(adapt);
        spp.setThreshold(1);


        spp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ArrayAdapter   adapte;
               if(parent.getItemAtPosition(position).toString().equalsIgnoreCase("Galicia")){
                    adapte=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.progal));
                   spl.setAdapter(adapte);
                   Toast.makeText(MainActivity.this,String.valueOf(R.array.progal), Toast.LENGTH_SHORT).show();
               }else

               if(parent.getItemAtPosition(position).toString().equalsIgnoreCase("Extremadura")){
                   adapte=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.proext));
                   spl.setAdapter(adapte);
                   Toast.makeText(MainActivity.this,String.valueOf(R.array.propai), Toast.LENGTH_SHORT).show();
               }else

               if(parent.getItemAtPosition(position).toString().equalsIgnoreCase("Madrid")){

                   adapte=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.promad));
                   spl.setAdapter(adapte);
               }else
               if(parent.getItemAtPosition(position).toString().equalsIgnoreCase("Pais Vasco")){

                   adapte=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.propai));
                   spl.setAdapter(adapte);
               }

            }


        });
    }


    }

