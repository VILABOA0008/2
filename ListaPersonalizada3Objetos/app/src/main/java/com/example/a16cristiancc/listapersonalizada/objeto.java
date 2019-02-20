package com.example.a16cristiancc.listapersonalizada;

/**
 * Created by a16pablovc on 17/01/2019.
 */

public class objeto {

    private String animales;
    private String animales2;
    private int fotos;


    public objeto(String animales, String animales2, int fotos) {
        this.animales = animales;
        this.animales2 = animales2;
        this.fotos = fotos;
    }

    public String getAnimales() {
        return animales;
    }

    public void setAnimales(String animales) {
        this.animales = animales;
    }

    public String getAnimales2() {
        return animales2;
    }

    public void setAnimales2(String animales2) {
        this.animales2 = animales2;
    }

    public int getFotos() {
        return fotos;
    }

    public void setFotos(int fotos) {
        this.fotos = fotos;
    }
}
