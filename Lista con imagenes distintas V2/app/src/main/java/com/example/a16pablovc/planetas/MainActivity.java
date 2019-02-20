package com.example.a16pablovc.planetas;

import android.content.res.TypedArray;
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

/*
    private String[]animales;
    private String[]animales2;
    private Integer[] fotos;
*/


private ListView spi;
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
String[] nombre=getResources().getStringArray(R.array.anima);
        String[] descrip=getResources().getStringArray(R.array.anima2);
        TypedArray imagenes=getResources().obtainTypedArray((R.array.fotos));
        objeto o[]=new objeto[nombre.length];
        for (int i=0;i<nombre.length;i++){
            o[i]=new objeto(nombre[i],descrip[i],imagenes.getResourceId(i,0));


        }
        /*
      objeto  obj1=new objeto("csa ","dsad",R.drawable.aguila);
        objeto  obj2=new objeto("csa ","dsad",R.drawable.ballena);
        objeto  obj3=new objeto("csa ","dsad",R.drawable.aguila);
        objeto  obj4=new objeto("csa ","dsad",R.drawable.ballena);
        objeto  obj5=new objeto("csa ","dsad",R.drawable.aguila);
        objeto  obj6=new objeto("csa ","dsad",R.drawable.ballena);
        objeto  obj7=new objeto("csa ","dsad",R.drawable.aguila);
        objeto  obj8=new objeto("csa ","dsad",R.drawable.ballena);
        objeto  obj9=new objeto("csa ","dsad",R.drawable.aguila);
        objeto obj[]={obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8,obj9};
  */

        setContentView(R.layout.activity_main);
        spi=(ListView)findViewById(R.id.spi);
        et=(EditText) findViewById(R.id.et);

        Adatatador_personalizado adaptador = new Adatatador_personalizado(this,o);
        System.out.println("antes");
        spi.setAdapter(adaptador);
        System.out.println("despues");




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
 /*    animales= getResources().getStringArray(R.array.anima);
       animales2= getResources().getStringArray(R.array.anima2);;
       fotos= new Integer[]{R.drawable.aguila, R.drawable.ballena,R.drawable.caballo, R.drawable.canario, R.drawable.delfin, R.drawable.gato,R.drawable.libro, R.drawable.perro, R.drawable.vaca};;
         obj=new obeto(animales,animales2,fotos);


        setContentView(R.layout.activity_main);
        spi=(ListView)findViewById(R.id.spi);
        et=(EditText) findViewById(R.id.et);
        System.out.println("antes");
        Adatatador_personalizado adaptador = new Adatatador_personalizado(this,obj);
        System.out.println("despues");
        spi.setAdapter(adaptador);

                fotos = new Integer[]{R.drawable.aguila, R.drawable.ballena,R.drawable.caballo, R.drawable.canario, R.drawable.delfin, R.drawable.gato,R.drawable.libro, R.drawable.perro, R.drawable.vaca};

        animales = getResources().getStringArray(R.array.anima);
        animales2 = getResources().getStringArray(R.array.anima2);


        */
