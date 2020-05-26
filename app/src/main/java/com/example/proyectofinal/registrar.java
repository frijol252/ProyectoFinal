package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class registrar extends AppCompatActivity {
     EditText _nombre, _apellido, _correo,_usuario,_contraseña2,_telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        _nombre = findViewById(R.id.etnombre);
        _apellido = findViewById(R.id.etapellido);
        _correo = findViewById(R.id.etcorreo);
        _usuario = findViewById(R.id.etnomusuario);
        _contraseña2 = findViewById(R.id.etpassword);
        _telefono = findViewById(R.id.ettelefono);
    }
    public void btncrearOnClick (View v){
                try {
                    String nombrestring = (_nombre.getText().toString());
                    String apellidostring = _apellido.getText().toString();
                    String correostring = _correo.getText().toString();
                    String usuariostring = _usuario.getText().toString();
                    String contraseña2string = _contraseña2.getText().toString();
                    String telefonoint = _telefono.getText().toString();
                    if (nombrestring.equals("") || apellidostring.equals("")|| correostring.equals("") || usuariostring.equals("") ||
                            contraseña2string.equals("") || telefonoint.equals("")) {
                        int a=Integer.parseInt("Hola");
                    }
                    else {
                        File archivo = new File("usuarios.txt");
                        if (!archivo.exists())
                        {
                            String texto = nombrestring + "," + contraseña2string + "," + correostring + "," + apellidostring + "," + usuariostring + "," + telefonoint + "\n";
                            guardarUsuario(texto);
                            Intent registrarse = new Intent(registrar.this, MainActivity.class);
                            startActivity(registrarse);
                        }
                        else{
                            String texto = nombrestring + "," + contraseña2string + "," + correostring + "," + apellidostring + "," + usuariostring + "," + telefonoint + "\n";
                            guardar(texto);

                        }
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Debe ingresar sus datos completos", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext() ,"Error "+e.getMessage(),Toast.LENGTH_LONG).show();
                }
    }
           public void guardarUsuario(String texto)
           { Intent registrarse = new Intent(registrar.this, MainActivity.class);
               startActivity(registrarse);
               String nombrearchivo="usuarios.txt";
               Context context = getApplicationContext();
                 try {
                     File registro;
                     registro = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+
                             "/data/user/0/com.example.proyectofinal.files/usuarios.txt","usuarios.txt");
                     FileOutputStream fo= context.openFileOutput(nombrearchivo,context.MODE_APPEND);
                     fo.write(texto.getBytes());
                     fo.close();
                 }
                 catch (Exception ex){
                     Toast.makeText(getApplicationContext() ,"Error "+ex.getMessage(),Toast.LENGTH_LONG).show();
                 }
             }
             public void guardar(String texto)
             {
                 String nombrearchivo="usuarios.txt";
                 Context context = getApplicationContext();
                 try {
                     FileOutputStream fo= context.openFileOutput(nombrearchivo,context.MODE_APPEND);
                     fo.write(texto.getBytes());
                     fo.close();
                 }
                 catch (Exception ex){
                     Toast.makeText(getApplicationContext() ,"Error "+ex.getMessage(),Toast.LENGTH_LONG).show();
                 }
             }
     }





