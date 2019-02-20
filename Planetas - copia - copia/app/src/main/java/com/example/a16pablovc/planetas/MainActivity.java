package com.example.a16pablovc.planetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String>arraypla;
    private String[] planetos={"Merc","Venus","Tierra","MArte","Jupiter","Saturn","Urano"};
private Spinner spi;
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arraypla=new ArrayList<String>();
        arraypla.add("casa");
        arraypla.add("casuta");
        arraypla.add("casita");
        arraypla.add("Casota");


        setContentView(R.layout.activity_main);
        spi=(Spinner)findViewById(R.id.spi);
        ArrayAdapter<String>adapt=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,arraypla);
        et=(EditText)findViewById(R.id.et);
        spi.setAdapter(adapt);
spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        et.setText(spi.getSelectedItem()+"  "+(spi.getSelectedItemPosition()+1));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
et.setText("nada");
    }
});
    }


    public void click(View v){
et.setText(spi.getSelectedItem()+"  "+(spi.getSelectedItemPosition()+1));
        



    }
}
