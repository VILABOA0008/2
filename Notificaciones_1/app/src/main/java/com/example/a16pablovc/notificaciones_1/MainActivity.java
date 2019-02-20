package com.example.a16pablovc.notificaciones_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.img);
    }

    public void  on_click1(View v){


        Toast t=Toast.makeText(this,"1",Toast.LENGTH_SHORT);
    t.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT,30,0);

        t.show();
    }

    public void  on_click2(View v){

        Toast.makeText(this,"2",Toast.LENGTH_SHORT).show();


    }

    public void  on_click3(View v){
        LinearLayout toas2=(LinearLayout)findViewById(R.id.linear);
        LayoutInflater inflater=getLayoutInflater();
        View view =inflater.inflate(R.layout.toas,toas2);
        TextView tex=(TextView)view.findViewById(R.id.tex);
        tex.setText("casita");
        Toast t3=new Toast(this);
        t3.setDuration(Toast.LENGTH_SHORT);
        t3.setView(view);
        t3.show();

        Toast.makeText(this,"3",Toast.LENGTH_SHORT);



    }
}
