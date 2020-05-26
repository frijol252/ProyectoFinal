package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;

public class ventana_final extends AppCompatActivity {
    EditText _etreservas;
    TextView _tvprecio;
    String servicio;
    String precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            setContentView(R.layout.activity_ventana_final);
            _etreservas = findViewById(R.id.etreservas);
            _tvprecio = findViewById(R.id.tvprecio);
            //Aqui crea las cositas :)
            _etreservas.setText(Rellenar2()+"\n"+Rellenar()+"\n"+Rellenar3());
            _etreservas.setEnabled(false);
            _tvprecio.setText(Rellenar4());
        }
        catch (Exception ex) {
            Toast.makeText(getApplicationContext() ,"Error "+ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    public void btnreservaOnClick (View v) {
        Intent reserva = new Intent(ventana_final.this, MainActivity.class);
        startActivity(reserva);
        Toast.makeText(getApplicationContext(),"Su reserva ha sido registrada", Toast.LENGTH_LONG).show();
    }
    public void btncancelarOnClick (View v) {
        Intent cancelar = new Intent(ventana_final.this, MainActivity.class);
        startActivity(cancelar);
        Toast.makeText(getApplicationContext(),"Su reserva ha sido cancelada", Toast.LENGTH_LONG).show();
    }
    public String Rellenar2(){
        String mensaje = "";
        try {

            String parte1 = "";
            InputStreamReader archivo = new InputStreamReader(openFileInput("InicioSesion.txt"));
            BufferedReader br = new BufferedReader(archivo);
            String linea = br.readLine();
            String[] palabras;
            Log.i("ERROR", "" + linea);
            while (linea != null) {
                palabras = linea.split("/");
                //Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                parte1 = palabras[0] + " " + palabras[1] + "\n";
                linea = br.readLine();
            }
            br.close();
            archivo.close();
            mensaje = parte1;

        } catch (Exception ex) {
            Toast.makeText(getApplicationContext() ,"Error "+ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return mensaje;
    }
    public String Rellenar4(){
        String mensaje="";
        String parte2="";
        try {

            InputStreamReader archivo2 = new InputStreamReader(openFileInput("reservas.txt"));
            BufferedReader br2 = new BufferedReader(archivo2);
            String linea2 = br2.readLine();
            Log.i("ERROR", "" + linea2);
            while (linea2 != null) {
                String[] palabras2 = linea2.split("/");
                parte2 = palabras2[1];
                //Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                linea2 = br2.readLine();
            }
            br2.close();
            archivo2.close();
            mensaje = mensaje + parte2;
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext() ,"Error "+ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return mensaje;
    }
    public String Rellenar3(){
        String mensaje="";
        String parte2="";
        try {

            InputStreamReader archivo2 = new InputStreamReader(openFileInput("reservas.txt"));
            BufferedReader br2 = new BufferedReader(archivo2);
            String linea2 = br2.readLine();
            Log.i("ERROR", "" + linea2);
            while (linea2 != null) {
                String[] palabras2 = linea2.split("/");
                parte2 = palabras2[0] + "\n";
                //Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                linea2 = br2.readLine();
            }
            br2.close();
            archivo2.close();
            mensaje = mensaje + parte2;
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext() ,"Error "+ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return mensaje;
    }
    public String Rellenar() {
        String mensaje="";
        String[] palabras3;
        String[] fechita;
        String parte3="";
        try {
            InputStreamReader archivo3 = new InputStreamReader(openFileInput("FechaReserva.txt"));
            BufferedReader br3 = new BufferedReader(archivo3);
            String linea3 = br3.readLine();
            Log.i("ERROR", "" + linea3);
            while (linea3 != null) {
                palabras3 = linea3.split("/");
                fechita=palabras3[1].split(" ");
                parte3 = "Hora: " + palabras3[0] + "\n"+ "Fecha: " +fechita[0]+" "+fechita[2]+" "+fechita[1]+" "+fechita[5]+ "\n";
                linea3 = br3.readLine();
            }
            br3.close();
            archivo3.close();
            mensaje=parte3;
        } catch (Exception ex) {

        }
        return mensaje;
    }
}




