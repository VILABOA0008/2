package com.example.a16pablovc.notificaciones_3_fragmentos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int DIALOGO_MENSAJE = 1;
    private static final int DIALOGO2 = 2;
    private static final int DIALOGO3= 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id) {

            case 1:
                AlertDialog.Builder ventana = new AlertDialog.Builder(this);
                ventana.setTitle("Atención");
                ventana.setMessage("Esto es un mensaje. Pulsa ...");
                ventana.setIcon(android.R.drawable.ic_dialog_alert);
                return ventana.create();


            case 2:

                AlertDialog.Builder v=new AlertDialog.Builder(this);
                v.setTitle("Atencione");
                v.setMessage("Esto SI funciona");
                v.setPositiveButton("Clickeame pls", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                return v.create();


            case 3:
                AlertDialog.Builder vi=new AlertDialog.Builder(this);
                vi.setTitle("Atencione");
                vi.setMessage("Esto SI funciona");
                vi.setPositiveButton("Clickeame pls", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println(which+"   which");
                        Toast.makeText(MainActivity.this,"HOLA",Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });

                vi.setNegativeButton("No me clickees", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });


                vi.setNeutralButton("No hago absolutamente nada, crAck", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        on_click3(null);
                    }
                });
                return vi.create();



        default:return  null;
        }

    }
    public void on_click(View v){

showDialog(DIALOGO_MENSAJE);

    }

    public void on_click2(View v){
        showDialog(DIALOGO2);


    }

    public void on_click3(View v){
        showDialog(DIALOGO3);


    }

}
