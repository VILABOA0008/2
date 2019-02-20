package com.example.a16pablovc.bd_helper;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String bdname;
    private int bdversion;
    private SQLiteDatabase bdusuarios;
    int ventana=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }

    public void Insertar(View v){
        Intent i=new Intent(MainActivity.this,Main2Activity.class);
        i.putExtra("ventana","insertar");
        startActivity(i);

    }

    public void Borrar(View v){
        Intent i=new Intent(MainActivity.this,Main2Activity.class);
        i.putExtra("ventana","borrar");
        startActivity(i);

    }

    public void Modificar(View v){
        Intent i=new Intent(MainActivity.this,Main2Activity.class);
        i.putExtra("ventana","modificar");
        startActivity(i);

    }

    public void Uno(View v){
        Intent i=new Intent(MainActivity.this,Main2Activity.class);
        i.putExtra("ventana","uno");
        startActivity(i);

    }

    public void Varios(View v){
        Intent i=new Intent(MainActivity.this,Main2Activity.class);
        i.putExtra("ventana","varios");
        startActivity(i);

    }


}
