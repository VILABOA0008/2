package com.example.a16pablovc.menu_4_listview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    TextView tv;
private String casa;
    private String[] p={"Merc","Venus","Tierra","MArte","Jupiter","Saturn","Urano"};
    ArrayList<String> plan=new ArrayList<>();
    ArrayAdapter<String> adapt;
    int pos;
    ListView spi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.tv);


for (int i=0;i<p.length;i++){
    plan.add(p[i]);

}


        spi=(ListView)findViewById(R.id.spi);
        adapt=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,plan/*arraypla*/);

        spi.setAdapter(adapt);

        registerForContextMenu(spi);
        spi.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       tv.setText(spi.getItemAtPosition(position).toString());
                    }
                });

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_opciones,menu);

        return true; }*/

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();
        casa=spi.getAdapter().getItem(info.position).toString();
        final AdapterView.AdapterContextMenuInfo info1=info;
        switch (item.getItemId()) {
            case R.id.op1:
                AlertDialog.Builder v=new AlertDialog.Builder(this);
                v.setTitle("Atencione");
                v.setMessage("Esto SI funciona");
                v.setPositiveButton("Seguro que quieres eliminar  "+casa, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapt.remove(adapt.getItem(info1.position));
                        dialog.cancel();
                    }
                });

                v.setNegativeButton("No",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {

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
        casa=spi.getAdapter().getItem(info.position).toString();
        menu.setHeaderTitle(casa);
        inflater.inflate(R.menu.menu_opciones, menu);


    }

    /*@Override
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id){

            case R.id.op1: Toast.makeText(this,"option  1"+casa,Toast.LENGTH_SHORT).show();return true;
            case R.id.op2:Toast.makeText(this,"option  2",Toast.LENGTH_SHORT).show();return true;
            default:
                return super.onContextItemSelected(item);}


    }*/


}
