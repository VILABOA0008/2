package com.example.a16pablovc.planetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[]animales;
    private String[]animales2;
    private Integer[] fotos;
    private Integer[] fotos2;
private ListView spi;
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        fotos = new Integer[]{R.drawable.aguila, R.drawable.ballena,R.drawable.caballo, R.drawable.canario, R.drawable.delfin, R.drawable.gato,R.drawable.libro, R.drawable.perro, R.drawable.vaca};
        fotos2 = new Integer[]{R.drawable.aguila, R.drawable.ballena,R.drawable.caballo, R.drawable.canario, R.drawable.delfin, R.drawable.gato,R.drawable.libro, R.drawable.perro, R.drawable.vaca};
        animales = getResources().getStringArray(R.array.anima);
        animales2 = getResources().getStringArray(R.array.anima2);


        setContentView(R.layout.activity_main);
        spi=(ListView)findViewById(R.id.spi);
        et=(EditText) findViewById(R.id.et);
        Adatatador_personalizado adaptador = new Adatatador_personalizado(this,
                animales, animales2,fotos,fotos2);
        spi.setAdapter(adaptador);


spi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            et.setText(spi.getItemAtPosition(position) + "  ");
        }
    });
}


        public void click(View v){
et.setText(spi.getSelectedItem()+"  "+(spi.getSelectedItemPosition()+1));
        



    }
}
