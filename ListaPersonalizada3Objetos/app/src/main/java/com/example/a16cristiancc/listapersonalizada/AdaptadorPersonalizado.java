package com.example.a16cristiancc.listapersonalizada;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by a16cristiancc on 15/01/2019.
 */

public class AdaptadorPersonalizado extends ArrayAdapter {
    private Activity context;
    private Frutas[] frutas;

    public AdaptadorPersonalizado(Activity context, Frutas[] frutas) {
        super(context, R.layout.cadafila, frutas);
        this.context = context;
        this.frutas = frutas;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View plantilla = convertView;                           //
        ViewHolder vhs;                                         // Cambio hecho para optimizar la eficiencia de la aplicación
                                                                //
        if (plantilla == null) {                                //
            LayoutInflater li = context.getLayoutInflater();    //
            plantilla = li.inflate(R.layout.cadafila, null);    //
                                                                //
            vhs = new ViewHolder((TextView) plantilla.findViewById(R.id.tvNombre),(ImageView) plantilla.findViewById(R.id.imgFruta), (TextView) plantilla.findViewById(R.id.tvDescripcion));
            plantilla.setTag(vhs);                              //
                                                                //
        } else {                                                //
            vhs = (ViewHolder) plantilla.getTag();              //
        }                                                       //

        TextView tvNombre = vhs.getTitulo();
        ImageView imgFruta = vhs.getImagen();
        TextView tvDescripcion = vhs.getDescripcion();

        tvNombre.setText(frutas[position].getNombre());
        imgFruta.setImageResource(frutas[position].getImagen());
        tvDescripcion.setText(frutas[position].getDescripcion());

        return plantilla;
    }
}
