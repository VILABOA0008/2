package com.example.a16pablovc.menu_2_contextual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.tv);
        registerForContextMenu(tv);
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
        inflater.inflate(R.menu.menu_opciones,menu);
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
