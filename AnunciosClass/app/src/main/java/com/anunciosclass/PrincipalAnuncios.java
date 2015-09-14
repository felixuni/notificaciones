package com.anunciosclass;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class PrincipalAnuncios extends ActionBarActivity {

    TextView FH;
    Button iranuncio;
    Date fecha;
    String hora;
    String minutos;
    String segundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_anuncios);

        FH=(TextView)findViewById(R.id.textView1);
        iranuncio=(Button)findViewById(R.id.button1);
        iranuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iranuncio1();
            }
        });


    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void iranuncio1() {

        /*NotificationManager notifica=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        int icono=R.drawable.icono;
        CharSequence titulo="ESTO ES UN ANUNCIO";
        long cuando=System.currentTimeMillis();
        Notification notification=new Notification(icono,titulo,cuando);
        Context contexto=getApplicationContext();
        CharSequence otrotitulo="APLICACION DE ANUNCIOS";
        CharSequence otrotexto="ESTO ES UN TEXTO";
        // Agregar sonido a la notificacion
        notification.defaults|=Notification.DEFAULT_SOUND;
        //agrego vibracion
        notification.defaults|=Notification.DEFAULT_VIBRATE;
        Intent hacernotifica=new Intent(PrincipalAnuncios.this,PrincipalAnuncios.class);
        PendingIntent contenidointent=PendingIntent.getActivities(PrincipalAnuncios.this,0, new Intent[]{hacernotifica},0);

        notification.setLatestEventInfo(context, TITULO, TEXTO, contentIntent);
        int HELLO_ID=0;
        notifica.notify(HELLO_ID, notification);*/

        android.support.v4.app.NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.icono)
                        .setContentTitle("ESTO ES UN ANUNCIO\"")
                        .setContentText("APLICACION DE ANUNCIOS");

        Intent resultIntent = new Intent(this, PrincipalAnuncios.class);

// Because clicking the notification opens a new ("special") activity, there's
// no need to create an artificial back stack.
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager notifica=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification=new Notification();
        notification.defaults|=Notification.DEFAULT_SOUND;
        notification.defaults|=Notification.DEFAULT_VIBRATE;
        notifica.notify(001,notification);
        notifica.notify(001,mBuilder.build());

        //para mostrar y get la fecha y la hora del sistema
        fecha=new Date();
        hora=Integer.toString(fecha.getHours());
        minutos=Integer.toString(fecha.getMinutes());
        segundos=Integer.toString(fecha.getSeconds());

        FH.setText("la hora es: " + hora + ":" + minutos + ":" + segundos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal_anuncios, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
