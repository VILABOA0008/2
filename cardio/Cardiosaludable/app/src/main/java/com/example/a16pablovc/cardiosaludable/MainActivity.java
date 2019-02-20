package com.example.a16pablovc.cardiosaludable;




import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView av;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        av=(AutoCompleteTextView)findViewById(R.id.sv);
      //  startActivity(new Intent(this,Main2Activity.class));


    }
    public void on_cardiosaludable(View v){
        String nombre=av.getText().toString();
        System.out.println(nombre);
        DatabaseAcces aces= DatabaseAcces.getInstance(getApplicationContext());
        aces.open();
        String []a=   aces.datos(nombre);
        String nom=nombre+"  ";
        nom+=a[0];
        nom+="    "+a[1]+"    ";
        nom+=a[2];
        Toast.makeText(this,nom,Toast.LENGTH_LONG).show();

        Intent i=new Intent(this,Main2Activity.class);
        i.putExtra("nom",nombre);
        i.putExtra("azu",a[0]);
        i.putExtra("gra",a[1]);
        i.putExtra("sod",a[2]);

        startActivity(i);

    }


public void on_casa(View v){
DatabaseAcces aces= DatabaseAcces.getInstance(getApplicationContext());
aces.open();
    ArrayList<String >a=   aces.consultars();
    for(int i=0;i<a.size();i++){
        System.out.println(a.get(i));

    }
    autocomplete(a);
aces.close();;
}


    public void autocomplete( ArrayList<String >a){
        ArrayList<String >arr=a;
        final ArrayAdapter<String> array=new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,arr);
        av.setAdapter(array);
        av.setThreshold(1);

    }

}
