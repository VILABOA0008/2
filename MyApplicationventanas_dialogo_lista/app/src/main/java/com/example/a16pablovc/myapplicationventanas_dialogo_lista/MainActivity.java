package com.example.a16pablovc.myapplicationventanas_dialogo_lista;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public Dialog onCreateDialog(int id) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setTitle("Elige color");
        final String[] colores = {"Rojo", "Verde", "Azul", "Amarillo"};
        switch (id) {
            case 1:


                ventana.setItems(colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
// el parametro "which" contiene la posicion del elemento seleccionado
                        Toast.makeText(getApplicationContext(), "Opción elegida: " + colores[which],
                                Toast.LENGTH_LONG).show();
                    }
                });
                return ventana.create();

            case 2:
                ventana.setPositiveButton("Clickeame pls", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                ventana.setSingleChoiceItems(colores, 2, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, colores[which], Toast.LENGTH_SHORT).show();
                    }
                });
                return ventana.create();

            case 3:
                final boolean[] b = new boolean[colores.length];
                ventana.setPositiveButton("Clickeame pls", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        String n="";
                        for (int i = 0; i < colores.length; i++) {
                    if(b[i]==true){
                            n+=" "+colores[i];}
                        }

                        Toast.makeText(getApplicationContext(), n,Toast.LENGTH_SHORT).show();
                    }
                });
                ventana.setMultiChoiceItems(colores, null, new
                        DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                System.out.println(isChecked);

                                    if (isChecked) {
                                        b[which] = true;
                                    }else{b[which] = false;}

                            }
                        });
                return ventana.create();


            default:
                return null;
        }


    }

    public void casa(View v) {
        showDialog(1);

    }

    public void casa2(View v) {

        showDialog(2);
    }

    public void casa3(View v) {
        removeDialog(3);
       showDialog(3);

    }
}
