package com.example.a16pablovc.autocompletar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
AutoCompleteTextView spi;
//ArrayAdapter<String>array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spi=(AutoCompleteTextView)findViewById(R.id.spi);
   final ArrayAdapter<String> array=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.nombre));
      //  array=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.nombre));


        spi.setAdapter(array);
        spi.setThreshold(1);


    }
}
