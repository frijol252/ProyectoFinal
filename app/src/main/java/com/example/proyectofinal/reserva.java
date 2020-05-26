package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class reserva extends AppCompatActivity {
    CalendarView _cvFecha;
    EditText _ethora;
    String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        _cvFecha = findViewById(R.id.cvfecha);
        _ethora= findViewById(R.id.ethora);

        _cvFecha.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Calendar otrafecha=  new GregorianCalendar(i,i1,i2);
                fecha=(otrafecha.getTime().toString());
            }
        });
    }
    public void btventana_finalOnclick(View v) {
        try {
            String horaCompleta=_ethora.getText().toString();
            String [] palabras = horaCompleta.split(":");
            int hora=Integer.parseInt(palabras[0]);
            int minutos=Integer.parseInt(palabras[1]);
            if ((hora>=9&&hora<21)&&(minutos>=0&&minutos<60)){
                String mensaje=horaCompleta+"/"+fecha.toString()+"\n";
                guardar(mensaje);
                Intent Intentcontinuar = new Intent(this, ventana_final.class);
                startActivity(Intentcontinuar);
            }
            else{
                Toast.makeText(getApplicationContext() ,"Horario de reservas de 9:00 a 20:00",Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception ex){

        }
    }
    public void guardar(String texto)
    {
        String nombrearchivo="FechaReserva.txt";
        Context context = getApplicationContext();
        try{
            File archivo = new File("FechaReserva.txt");
            if (!archivo.exists())
            {
                File registro;
                registro = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+
                        "/data/user/0/com.example.proyectofinal.files/FechaReserva.txt","FechaReserva.txt");

                FileOutputStream fo= context.openFileOutput(nombrearchivo,context.MODE_APPEND);
                fo.write(texto.getBytes());
                fo.close();
            }
            else{
                FileOutputStream fo= context.openFileOutput(nombrearchivo,context.MODE_APPEND);
                fo.write(texto.getBytes());
                fo.close();
            }
        }
        catch (Exception ex){
            Toast.makeText(getApplicationContext() ,"Error "+ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
