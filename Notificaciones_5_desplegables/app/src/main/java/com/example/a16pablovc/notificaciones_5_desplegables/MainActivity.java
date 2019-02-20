package com.example.a16pablovc.notificaciones_5_desplegables;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationCompat.Builder ncBuilder = new NotificationCompat.Builder(this);
        ncBuilder.setSmallIcon(R.drawable.sas);
        ncBuilder.setTicker("Alerta!");
        ncBuilder.setContentTitle("Mensaje de Alerta");
        ncBuilder.setContentText("Esto es un ejemplo de notificación.");
//conversion de un recurso de tipo imagen a mapa de bits
        Bitmap icono = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ncBuilder.setLargeIcon(icono);

        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);


        ncBuilder.setContentIntent(pi);

        NotificationManager nm = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);

        Notification no = ncBuilder.build();
        nm.notify(NOTIFICATION_ID, no);
        System.out.println("casa");

    }
}