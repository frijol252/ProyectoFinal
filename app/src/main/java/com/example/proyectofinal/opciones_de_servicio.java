package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import static android.os.Build.VERSION_CODES.N;


public class opciones_de_servicio extends AppCompatActivity {
    CheckBox _chbmanicura, _chbpedicura,_chbmaquillaje, _chbcorte,_chbtinte,_chbdepilacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_opciones_de_servicio);
        _chbmanicura = findViewById(R.id.chbmanicura);
        _chbpedicura = findViewById(R.id.chbpedicura);
        _chbmaquillaje = findViewById(R.id.chbmaquillaje);
        _chbcorte = findViewById(R.id.chbcorte);
        _chbtinte = findViewById(R.id.chbtinte);
        _chbdepilacion = findViewById(R.id.chbdepilacion);
    }
    public void btreserva (View v){
        try {
            String reserva = "";
            double total=0.00;
            if (_chbmanicura.isChecked() == false && _chbpedicura.isChecked() == false && _chbmaquillaje.isChecked() == false && _chbcorte.isChecked() == false &&
                    _chbtinte.isChecked() == false && _chbdepilacion.isChecked() == false) {
                int a = Integer.parseInt("Hola");
            }
            else {
                if (_chbmanicura.isChecked() == true) {
                    reserva = reserva + "manicura,";
                    total=total+45.00;
                }
                if (_chbpedicura.isChecked() == true) {
                    reserva = reserva + "pedicura,";
                    total=total+50.00;
                }
                if (_chbmaquillaje.isChecked() == true) {
                    reserva = reserva + "maquillaje,";
                    total=total+80.00;
                }
                if (_chbcorte.isChecked() == true) {
                    reserva = reserva + "corte,";
                    total=total+70.00;
                }
                if (_chbtinte.isChecked() == true) {
                    reserva = reserva + "tinte,";
                    total=total+100.00;
                }
                if (_chbdepilacion.isChecked() == true) {
                    reserva = reserva + "depilacion,";
                    total=total+100.00;
                }
                reserva = reserva + "";
                String reservaCompleta=reserva+"/"+total+"\n";
                guardar(reservaCompleta);
                //Toast.makeText(getApplicationContext(), reservaCompleta, Toast.LENGTH_LONG).show();
                Intent registrarse = new Intent(opciones_de_servicio.this, reserva.class);
                startActivity(registrarse);
            }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
        }
    }
    public void guardar(String texto)
    {
        String nombrearchivo="reservas.txt";
        Context context = getApplicationContext();
        try{
            File archivo = new File("reservas.txt");
            if (!archivo.exists())
            {
                File registro;
                registro = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+
                        "/data/user/0/com.example.proyectofinal.files/reservas.txt","reservas.txt");

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


