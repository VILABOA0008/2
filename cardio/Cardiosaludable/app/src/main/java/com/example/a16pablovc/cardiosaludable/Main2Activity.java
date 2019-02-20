package com.example.a16pablovc.cardiosaludable;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    TextView azucar,grasa,sodio;
    LinearLayout ll;

    private String bdname;
    private int bdversion;
    private SQLiteDatabase bdusuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ll=(LinearLayout)findViewById(R.id.activity_main2);
        azucar=(TextView)findViewById(R.id.azucar);
        grasa=(TextView)findViewById(R.id.grasa);
        sodio=(TextView)findViewById(R.id.sodio);
        Intent i=getIntent();
        Float f;
        String a;
        int c=0;
        try {
             a= String.format("%.2f", Float.valueOf(i.getStringExtra("azu")));
            f = Float.valueOf(a);
            if(f<10){azucar.setTextColor(getResources().getColor(R.color.green));}else{azucar.setTextColor(getResources().getColor(R.color.red));c++;}
            azucar.setText(f+"g");
        }catch(java.lang.NumberFormatException e){azucar.setText(0.00+"g");}
        try {
         a=String.format("%.2f",Float.valueOf(i.getStringExtra("gra")));
        f=Float.valueOf(a);
            if(f<10){grasa.setTextColor(getResources().getColor(R.color.green));}else{grasa.setTextColor(getResources().getColor(R.color.red));c++;}
        grasa.setText(f+"g");
        }catch(java.lang.NumberFormatException e){grasa.setText(0.00+"g");}
            try {
        a=String.format("%.2f",Float.valueOf(i.getStringExtra("sod")));
        f=Float.valueOf(a);
                if(f<100){sodio.setTextColor(getResources().getColor(R.color.green));}else{sodio.setTextColor(getResources().getColor(R.color.red));c++;}
        sodio.setText(f+"mg");
            }catch(java.lang.NumberFormatException e){sodio.setText(0.00+"mg");}
       switch(c){
        case 0:ll.setBackgroundColor(getResources().getColor(R.color.greens));break;
        case 1:
        case 2:ll.setBackgroundColor(getResources().getColor(R.color.oranges));break;
        case 3:ll.setBackgroundColor(getResources().getColor(R.color.reds));break;}

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        System.out.println("ESPA");


    }

    public void on_click(View v){
Random r=new Random();

        int a=r.nextInt(3);

        switch(a){
            case 0:ll.setBackgroundColor(getResources().getColor(R.color.green));break;
            case 1:ll.setBackgroundColor(getResources().getColor(R.color.red));break;
            case 2:ll.setBackgroundColor(getResources().getColor(R.color.orange));break;


        }

    }
    public void on_finish(View v){
        finish();
    }
}
