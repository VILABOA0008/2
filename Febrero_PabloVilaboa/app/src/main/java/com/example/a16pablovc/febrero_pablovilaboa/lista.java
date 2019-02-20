package com.example.a16pablovc.febrero_pablovilaboa;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class lista extends ArrayAdapter {
    private Activity context;
    private ArrayList<String> nombre;
    private ArrayList<String> curso;
    private ArrayList<String> ciclo;


    public lista(Activity context, ArrayList<String> nombre, ArrayList<String>  curso, ArrayList<String>  ciclo){
        super(context, R.layout.activity_lista ,nombre);
        this.context=context;
        this.nombre=nombre;
        this.curso=curso;
        this.ciclo=ciclo;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View fila = inflater.inflate(R.layout.activity_lista,null);
        TextView tv=(TextView)fila.findViewById(R.id.tv);
        TextView tv2=(TextView)fila.findViewById(R.id.tv2);
        TextView tv3=(TextView)fila.findViewById(R.id.tv3);
        tv.setText(nombre.get(position));
        tv2.setText(curso.get(position));
        tv3.setText(ciclo.get(position));
        return fila;
        //return super.getView(position, convertView, parent);
    }
}
