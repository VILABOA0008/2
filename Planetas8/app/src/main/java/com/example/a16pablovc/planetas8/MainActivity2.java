package com.example.a16pablovc.planetas8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ArrayList<String> arraypla;
    private Spinner spi;
    private TextView et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i=getIntent();
        arraypla=new ArrayList<String>();
        arraypla = i.getStringArrayListExtra("dato");
        System.out.println("arra"+ arraypla);




        setContentView(R.layout.activity_main2);
        spi=(Spinner)findViewById(R.id.spi);
        et=(TextView) findViewById(R.id.et);
        ArrayAdapter<String> adapt=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,arraypla);

        spi.setAdapter(adapt);
        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                et.setText(spi.getSelectedItem()+"  "+(spi.getSelectedItemPosition()+1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {et.setText("nada");

            }
        });
    }


}

