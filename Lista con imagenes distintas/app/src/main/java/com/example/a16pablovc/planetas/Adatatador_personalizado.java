package com.example.a16pablovc.planetas;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by a16pablovc on 15/01/2019.
 */

public class Adatatador_personalizado extends ArrayAdapter {
    private Activity context;
    private String[]animales;
    private String[]animales2;
    private Integer[] fotos;
    private Integer[] fotos2;

    public Adatatador_personalizado(Activity context,String[]animales,String[]animales2,Integer[] fotos,Integer[] fotos2){
        super(context, R.layout.cosas_raras ,animales);
        this.context=context;
        this.animales=animales;
        this.animales2=animales2;
        this.fotos=fotos;
        this.fotos2=fotos2;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("asdfdsfdsf");
        LayoutInflater inflater=context.getLayoutInflater();
        View fila = inflater.inflate(R.layout.cosas_raras,null);
        TextView tv=(TextView)fila.findViewById(R.id.tv);
        ImageView img=(ImageView)fila.findViewById(R.id.img);
        ImageView img2=(ImageView)fila.findViewById(R.id.img2);
        TextView tv2=(TextView)fila.findViewById(R.id.tv2);
        tv.setText(animales[position]);
        tv2.setText(animales2[position]);
        img.setImageResource(fotos[position]);
        img2.setImageResource(fotos2[position]);

        return fila;
        //return super.getView(position, convertView, parent);
    }
}
