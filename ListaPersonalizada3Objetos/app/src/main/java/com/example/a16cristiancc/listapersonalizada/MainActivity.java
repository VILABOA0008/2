package com.example.a16cristiancc.listapersonalizada;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etFrutas;
    ArrayList<String> frutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frutas = new ArrayList<>();
        frutas.add("Naranja");
        frutas.add("Cordero");
        frutas.add("Risotto");
        etFrutas = (EditText) findViewById(R.id.etFrutas);


    }

    public void onPlus(View v) {
        frutas.add(etFrutas.getText().toString());
        etFrutas.setText("");
    }

    public void onAcabar(View v) {
        Intent i = new Intent(MainActivity.this, ListActivity.class);
        i.putStringArrayListExtra("frutas", frutas);
        startActivity(i);

    }
}
