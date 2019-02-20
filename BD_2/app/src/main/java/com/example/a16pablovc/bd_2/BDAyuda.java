package com.example.a16pablovc.bd_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by a16pablovc on 08/02/2019.
 */

public class BDAyuda extends SQLiteOpenHelper {

    public BDAyuda(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table TABLAUSUARIOS(" +
                "CODIGO INTEGER   ," +
                " nombre VARCHAR(43)," +
                "PRIMARY KEY(CODIGO))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS TABLAUSUARIOS");
    }
}
