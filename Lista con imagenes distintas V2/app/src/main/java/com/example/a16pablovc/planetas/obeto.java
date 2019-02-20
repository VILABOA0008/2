package com.example.a16pablovc.planetas;

/**
 * Created by a16pablovc on 17/01/2019.
 */

public class obeto {


    private String[] animales;
    private String[] animales2;
    private Integer[] fotos;

    public obeto(String[] animales, String[] animales2, Integer[] fotos) {
        this.animales = animales;
        this.animales2 = animales2;
        this.fotos = fotos;
    }

    public String[] getAnimales() {
        return animales;
    }

    public void setAnimales(String[] animales) {
        this.animales = animales;
    }

    public String[] getAnimales2() {
        return animales2;
    }

    public void setAnimales2(String[] animales2) {
        this.animales2 = animales2;
    }

    public Integer[] getFotos() {
        return fotos;
    }

    public void setFotos(Integer[] fotos) {
        this.fotos = fotos;
    }

}
