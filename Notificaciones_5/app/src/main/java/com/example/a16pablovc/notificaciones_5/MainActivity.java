package com.example.a16pablovc.notificaciones_5;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void casa(View v) {
        NotificationCompat.Builder ncBuilder = new NotificationCompat.Builder(MainActivity.this);
        ncBuilder.setSmallIcon(android.R.drawable.stat_sys_warning);
        ncBuilder.setTicker("Alerta!");
        ncBuilder.setContentTitle("Mensaje de Alerta");
        ncBuilder.setContentText("Pesetero.");
//conversion de un recurso de tipo imagen a mapa de bits
        Bitmap icono = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ncBuilder.setLargeIcon(icono);

        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);


        ncBuilder.setContentIntent(pi);

        NotificationManager nm = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);

        Notification no = ncBuilder.build();
        nm.notify(NOTIFICATION_ID, no);


    }
}
