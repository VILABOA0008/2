package com.example.a16pablovc.planetas;

import android.app.Activity;
import android.content.Context;
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
    private objeto obj[];


    public Adatatador_personalizado(Activity context,objeto[] obj){

        super(context, R.layout.cosas_raras ,obj);
        this.context=context;
        this.obj = obj;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("pri");
        LayoutInflater inflater=context.getLayoutInflater();
        System.out.println("secu");
        View fila = inflater.inflate(R.layout.cosas_raras,null);

        TextView tv=(TextView)fila.findViewById(R.id.tv);
        ImageView img=(ImageView)fila.findViewById(R.id.img);
        TextView tv2=(TextView)fila.findViewById(R.id.tv2);
        if(position%2==0){

            fila.setBackgroundResource(R.color.colorAccent);
        }


        tv.setText(obj[position].getAnimales());
        tv2.setText(obj[position].getAnimales2());
        img.setImageResource(obj[position].getFotos());


        return fila;
        //return super.getView(position, convertView, parent);
    }
}
