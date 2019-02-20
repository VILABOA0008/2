package com.example.a16pablovc.menus_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_opciones,menu);

        return true; }

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
