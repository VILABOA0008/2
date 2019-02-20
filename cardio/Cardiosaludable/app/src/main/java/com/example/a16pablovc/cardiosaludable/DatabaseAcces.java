package com.example.a16pablovc.cardiosaludable;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mi on 17/02/2019.
 */

public class DatabaseAcces {
    private SQLiteOpenHelper open;
    private SQLiteDatabase bd;
    private static DatabaseAcces aces;
    Cursor c = null;

    private DatabaseAcces(Context context){
this.open=new BDAyuda(context);

    }

    public static DatabaseAcces getInstance(Context context){
    if(aces==null) {
        aces = new DatabaseAcces(context);
    }
        return aces;
    }

    public void open(){
        this.bd=open.getWritableDatabase();}

public void close(){
if(bd!=null){

    this.bd.close();
}

}

    public String[] datos(String nombre){

        Cursor c = bd.rawQuery("SELECT * FROM \"Base de datos Alimentación equilibrada_modular_Cereais e derivados\" WHERE ALIMENTO= \""+nombre+"\""  ,null);
        String[] a=new String[3];
        if (c.moveToFirst()) {
            a[0] = c.getString(1);
            a[1] = c.getString(2);
            a[2] = c.getString(3);
        }
        return a;
    }

    public ArrayList consultars(){

        Cursor c = bd.rawQuery("SELECT * FROM \"Base de datos Alimentación equilibrada_modular_Cereais e derivados\" ", null);
        ArrayList <String> a=new ArrayList<>();
        if (c.moveToFirst()) {
            while(!c.isAfterLast()){
                String n = c.getString(0);
                  a.add(n);
                c.moveToNext();

            }}
    return a;
    }

}
