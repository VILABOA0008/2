package com.example.a16cristiancc.listapersonalizada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = (ListView) findViewById(R.id.lvFrutas);

        Frutas fruta1= new Frutas("Pera", R.drawable.speed2, "Sabe bien");
        Frutas fruta2= new Frutas("Manzana", R.drawable.speed3, "Es dulce");
        Frutas fruta3= new Frutas("Narancia", R.drawable.speed4, "Sabe mal");
        Frutas fruta4= new Frutas("Mandarina", R.drawable.speed7, "Comer demasiadas es malo");
        Frutas fruta5= new Frutas("Platano", R.drawable.speed8, "Lo que quieras bro");
        Frutas fruta6= new Frutas("Limon", R.drawable.speed9, "Hinyaku hinyakuuu!");

        Frutas[] furutas = {fruta1, fruta2, fruta3, fruta4, fruta5, fruta6};
        ArrayAdapter<String> adaptador = new AdaptadorPersonalizado(this, furutas);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "Has elegido la posicion " + String.valueOf(position+1) + ", que contiene la fruta " + ((Frutas)list.getItemAtPosition(position)).getNombre(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
