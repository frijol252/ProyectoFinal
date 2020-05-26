package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText _etusuario,_etcontraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _etusuario = findViewById(R.id.etusuario);
        _etcontraseña = findViewById(R.id.etcontraseña);
    }
    public void btnregistroOnClick (View v){
        Intent registro=new Intent(MainActivity.this,registrar.class);
        startActivity(registro);
            }
    public void btniniciosesionOnClick (View v){
        try
                {
                    boolean exito = false;
                    String usuario,contraseña;
                    usuario = _etusuario.getText().toString();
                    contraseña = _etcontraseña.getText().toString();
                    InputStreamReader archivo = new InputStreamReader(openFileInput("usuarios.txt"));
                    BufferedReader br = new BufferedReader(archivo);
                    String linea = br.readLine();
                    String mensaje="";
                    Log.i("ERROR", ""+linea);
                    String [] palabras;
                    while(linea != null)
                    {
                        palabras = linea.split(",");

                        Log.i("ERROR", "usuario"+palabras[4]+" contraseña"+palabras[1]);

                        if(palabras[4].equals(usuario) && palabras[1].equals(contraseña)){
                            Intent iniciosesion=new Intent(MainActivity.this, opciones_de_servicio.class);
                            startActivity(iniciosesion);
                            exito=true;
                            mensaje="Bienvenido/a "+palabras[0]+" "+palabras[3];
                            Toast.makeText(getApplicationContext() ,mensaje,Toast.LENGTH_LONG).show();
                            guardar(palabras[0]+"/"+palabras[3]+"\n");
                            break;
                        }
                        linea=br.readLine();
                    }
                    br.close();
                    archivo.close();
                    if (exito==false){
                        Toast.makeText(getApplicationContext() ,"El usuario no existe",Toast.LENGTH_LONG).show();
                    }

                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext() ,"Error "+e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
    public void guardar(String texto)
    {
        String nombrearchivo="InicioSesion.txt";
        Context context = getApplicationContext();
        try{
            File archivo = new File("InicioSesion.txt");
            if (!archivo.exists())
            {
                File registro;
                registro = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+
                        "/data/user/0/com.example.proyectofinal.files/reservas.txt","InicioSesion.txt");

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












