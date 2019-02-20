package com.example.a16pablovc.notificaciones_2_dialogos;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void on_click(View vtry){

        AlertDialog.Builder v=new AlertDialog.Builder(this);
        v.setTitle("Atencione");
        v.setMessage("Esto no funciona");
        v.setIcon(android.R.drawable.sym_def_app_icon);
        v.show();

    }

    public void on_click2(View vtry){
        AlertDialog.Builder v=new AlertDialog.Builder(this);
        v.setTitle("Atencione");
        v.setMessage("Esto SI funciona");
        v.setPositiveButton("Clickeame pls", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
v.show();



    }


    public void on_click3(View vtry){
        AlertDialog.Builder v=new AlertDialog.Builder(this);
        v.setTitle("Atencione");
        v.setMessage("Esto SI funciona");
        v.setPositiveButton("Clickeame pls", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        v.setNegativeButton("No me clickees", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               finish();
            }
        });


v.setNeutralButton("No hago absolutamente nada, crAck", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
on_click3(null);
    }
});

        v.show();



    }
}
