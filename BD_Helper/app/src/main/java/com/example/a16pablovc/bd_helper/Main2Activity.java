package com.example.a16pablovc.bd_helper;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView tvtit;
    EditText etok,etinvi;
    Button boper;
    String ventana;
    //private static final TABLA="tablausuarios";
    private String bdname;
    private int bdversion;
    private SQLiteDatabase bdusuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       etok=(EditText)findViewById(R.id.etok);
        etinvi=(EditText)findViewById(R.id.etinvi);
        tvtit=(TextView)findViewById(R.id.tvtit);
        boper=(Button)findViewById(R.id.boper);

       Intent i=getIntent();
        ventana=i.getStringExtra("ventana");
        bdname="BDusuarios";
        bdversion=1;

        BDAyuda bd=new BDAyuda(this,bdname,null,bdversion);
        bdusuarios=bd.getWritableDatabase();
       // Toast.makeText(this,ventana,Toast.LENGTH_SHORT).show();

switch(ventana){

    case "insertar":boper.setText("Inserta persona");etinvi.setHint("Nombre");etinvi.setVisibility(View.VISIBLE);etok.setHint("Codigo");tvtit.setText("Insertalo");break;
    case "borrar":etok.setHint("Codigo");boper.setText("Borrame");tvtit.setText("Borralos");break;
    case "modificar":boper.setText("Modifica persona");etinvi.setHint("Nuevo Nombre");etinvi.setVisibility(View.VISIBLE);etok.setHint("Codigo");tvtit.setText("Modificalo");break;
    case "uno":etok.setHint("Codigo");boper.setText("Consultalelo");tvtit.setText("Consultalo a ese solo");break;
    case "varios":etok.setHint("Codigo");boper.setText("Consultame");tvtit.setText("Consultalos a todos");etok.setVisibility(View.INVISIBLE);break;


}


    }

    @Override
    protected void onDestroy() {
        bdusuarios.close();
        super.onDestroy();
    }

        public void Operacion(View v){
            switch(ventana){

                case "insertar":insertar();break;
                case "borrar":borrar();break;
                case "modificar":modificar();break;
                case "uno":uno();break;
                case "varios":consultars();break;
            }

        }
    public void borrar(){
        bdusuarios.execSQL("delete from tablausuarios where codigo="+etok.getText());

    }
    public void modificar(){
     //   bdusuarios.execSQL("update tablausuarios set nombre="+etinvi.getText()+"   where codigo="+etok.getText());
        ContentValues otroRegistro = new ContentValues();
        otroRegistro.put("nombre", etinvi.getText().toString());
      int a=  bdusuarios.update("tablausuarios", otroRegistro,"codigo="+etok.getText().toString(), null);
        System.out.println(a);
    }

    public void uno(){
        Cursor c = bdusuarios.rawQuery("SELECT * FROM tablausuarios where codigo="+etok.getText(), null);
        if (c.moveToFirst()) { //significa que se ha recuperado algo en la consulta

                String n = c.getString(0);
                String nn = c.getString(1);
                Toast.makeText(this, "Nombre: " + n+"  "+nn, Toast.LENGTH_SHORT).show();


    }else{ Toast.makeText(this, " NO HAY ", Toast.LENGTH_SHORT).show();}
    }

    public void consultars(){
    Cursor c = bdusuarios.rawQuery("SELECT * FROM tablausuarios ", null);
    if (c.moveToFirst()) { //significa que se ha recuperado algo en la consulta
        while(!c.isAfterLast()){
            String n = c.getString(0);
            String nn = c.getString(1);
            Toast.makeText(this, "Nombre: " + n+"  "+nn, Toast.LENGTH_SHORT).show();
            c.moveToNext();
        }
    }
    else{
        Toast.makeText(this, "Usuario inexistente", Toast.LENGTH_LONG).show();
    }}

    public void insertar(){

        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("codigo", etok.getText().toString());
        nuevoRegistro.put("nombre", etinvi.getText().toString());
       long f= bdusuarios.insert("TABLAUSUARIOS", null, nuevoRegistro);
        Toast.makeText(this, String.valueOf(f)+"  Insertado", Toast.LENGTH_SHORT).show();
        // bdusuarios.execSQL("INSERT INTO TABLAUSUARIOS(CODIGO,NOMBRE) VALUES('ESPACOD','USUARIO761') ");*/
    }

        public void Fin(View v){
            etinvi.setVisibility(View.INVISIBLE);
            etok.setVisibility(View.VISIBLE);
    finish();



    }
}
