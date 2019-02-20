package com.example.a16pablovc.menu_3_contextual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
TextView tv;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.tv);
        img=(ImageView)findViewById(R.id.img);
        registerForContextMenu(tv);
        registerForContextMenu(img);
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_opciones,menu);

        return true; }*/

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        System.out.println();
        if(v.getId()==tv.getId()){
        inflater.inflate(R.menu.menu_opciones,menu);}else{
            inflater.inflate(R.menu.menu_abc,menu);

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id){
            case R.id.acerca: Toast.makeText(this,"optione una",Toast.LENGTH_SHORT).show();return true;
            case R.id.opa: Toast.makeText(this,"optione a",Toast.LENGTH_SHORT).show();return true;
            case R.id.altas:Toast.makeText(this,"optione dosse",Toast.LENGTH_SHORT).show();return true;
            case R.id.opb: Toast.makeText(this,"optione b",Toast.LENGTH_SHORT).show();return true;
            case R.id.opc: Toast.makeText(this,"optione c",Toast.LENGTH_SHORT).show();return true;
            case R.id.bajas:     Toast.makeText(this,"optione thré",Toast.LENGTH_SHORT).show();return true;

            default:
                return super.onContextItemSelected(item);}


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        switch(id){
            case R.id.acerca: Toast.makeText(this,"optione una",Toast.LENGTH_LONG).show();return true;

            case R.id.altas:Toast.makeText(this,"optione dosse",Toast.LENGTH_LONG).show();return true;

            case R.id.bajas:     Toast.makeText(this,"optione thré",Toast.LENGTH_LONG).show();return true;

            default:   return super.onOptionsItemSelected(item);
        }

    }
}
