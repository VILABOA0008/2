package com.example.a16cristiancc.listapersonalizada;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by a16cristiancc on 17/01/2019.
 */

public class ViewHolder {
    TextView titulo;
    ImageView imagen;
    TextView descripcion;

    public ViewHolder(TextView titulo, ImageView imagen, TextView descripcion) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public TextView getTitulo() {
        return titulo;
    }

    public void setTitulo(TextView titulo) {
        this.titulo = titulo;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public TextView getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(TextView descripcion) {
        this.descripcion = descripcion;
    }
}

