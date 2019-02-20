package com.example.a16pablovc.febrero_pablovilaboa;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spicursos,spiciclos;
    private final int NOTIFICATION_ID = 1;
    int contador=0;
    EditText et;
    TextView tv;
    Button bt,bt2;
    String tit;
    lista adapt;
    ListView lista;
    String[]cursos={"ESO","Bach","Ciclos"};
    String[]ciclos={"DAM","DAW","ASIR"};
    ArrayList<String> nombre=new ArrayList<>();
    ArrayList<String> ciclo=new ArrayList<>();
    ArrayList<String> curso=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    spiciclos=(Spinner)findViewById(R.id.spiciclos);
        spicursos=(Spinner)findViewById(R.id.spicursos);
        et=(EditText) findViewById(R.id.et);
        tv=(TextView) findViewById(R.id.tv);
        lista=(ListView) findViewById(R.id.lista);
        bt=(Button) findViewById(R.id.bt);
        bt2=(Button) findViewById(R.id.bt2);
        final ArrayAdapter<String> adapt=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,ciclos);
        spiciclos.setAdapter(adapt);
        final ArrayAdapter<String> adapt2=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,cursos);
        spicursos.setAdapter(adapt2);

        spicursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spicursos.getSelectedItem().toString().equalsIgnoreCase("Ciclos")){
                    spiciclos.setVisibility(View.VISIBLE);
                    tv.setVisibility(View.VISIBLE);
                }else{
                    spiciclos.setVisibility(View.GONE);
                    tv.setVisibility(View.GONE);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nombre_alum="Alumno: "+nombre.get(position);
                String curso_alumno="\nCurso: "+curso.get(position);
                String ciclo_alum;
                if(ciclo.get(position).isEmpty()){ciclo_alum="";}else{
                    ciclo_alum ="\nCiclo: "+ciclo.get(position);}
Toast.makeText(MainActivity.this,nombre_alum+curso_alumno+ciclo_alum,Toast.LENGTH_SHORT).show();
                System.out.println(lista.getItemAtPosition(position));
            }
        });
    }


    public void on_guardar(View v){
        bt.setEnabled(true);
        curso.add(spicursos.getSelectedItem().toString());
        if(!spicursos.getSelectedItem().toString().equalsIgnoreCase("ciclos")){
            ciclo.add("");
        }else{
        ciclo.add(spiciclos.getSelectedItem().toString());}
        nombre.add(et.getText().toString());
        et.setText("");
    }

    public void on_listar(View v){
        registerForContextMenu(lista);
        bt.setEnabled(false);
        bt2.setEnabled(false);
        adapt = new lista(this,nombre,curso,ciclo);
        lista.setAdapter(adapt);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();
        tit=lista.getAdapter().getItem(info.position).toString();
        final AdapterView.AdapterContextMenuInfo info1=info;
        switch (item.getItemId()) {
            case R.id.op1:
                AlertDialog.Builder v=new AlertDialog.Builder(this);
                v.setIcon(android.R.drawable.ic_dialog_alert);
                v.setTitle("Importante");
                v.setMessage("Se va a eliminar registro:\n "+tit);
                v.setPositiveButton("Eliminar ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("\n casa  "+adapt.getItem(info1.position)+" saca \n");
                        System.out.println("\n casa  "+adapt.getItem(info1.position)+" saca \n");
                        curso.remove(info1.position);
                        ciclo.remove(info1.position);
                        adapt.remove(adapt.getItem(info1.position));
                        contador++;
                        Toast.makeText(MainActivity.this,tit+" ha sido eliminad@",Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                v.setNegativeButton("Cancelar",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,tit+" Has cancelado",Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                v.show();
        }
        return true;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) menuInfo;
        tit=lista.getAdapter().getItem(info.position).toString();
        menu.setHeaderTitle(tit);
        inflater.inflate(R.menu.menu_opciones, menu);
    }


    @Override
    protected void onDestroy() {
        NotificationCompat.Builder ncBuilder = new NotificationCompat.Builder(MainActivity.this);
        ncBuilder.setSmallIcon(android.R.drawable.stat_sys_warning);
        ncBuilder.setTicker("Alerta!");
        ncBuilder.setContentTitle("Aviso");

        ncBuilder.setContentText("Ha realizado "+contador+" borrados");
        Bitmap icono = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ncBuilder.setLargeIcon(icono);

        NotificationManager nm = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);

        Notification no = ncBuilder.build();
        nm.notify(NOTIFICATION_ID, no);

        super.onDestroy();
    }
}
