package com.example.a16pablovc.bd_2;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private String bdname;
    private int bdversion;
    private SQLiteDatabase bdusuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bdname="BDusuarios";
        bdversion=1;

        BDAyuda bd=new BDAyuda(this,bdname,null,bdversion);
        bdusuarios=bd.getWritableDatabase();
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("codigo", "12");
        nuevoRegistro.put("nombre", "usuario 12");
        bdusuarios.insert("TABLAUSUARIOS", null, nuevoRegistro);
         bdusuarios.execSQL("INSERT INTO TABLAUSUARIOS(CODIGO,NOMBRE) VALUES('3','USUARIO761') ");


        bdusuarios.close();
    }
}
