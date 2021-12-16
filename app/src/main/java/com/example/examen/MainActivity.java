package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import Objetos.Administrador;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private Administrador adm =new Administrador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        msj = findViewById(R.id.msj);
        msj.setVisibility(View.INVISIBLE);
    }

    public void LoadSession(View view)
    {
        String usuario = user.getText().toString();
        String contrasena = pass.getText().toString();

        String userObj = adm.getUser().toString().trim();
        String passObj = adm.getPass().toString().trim();

        switch (usuario)
        {
            case "Sofia":
                if (usuario.equals(userObj) && contrasena.equals(passObj))
                {
                    user.setText("");
                    pass.setText("");

                    //INICIO SESION
                    Intent i = new Intent(this, Home_act.class);


                    startActivity(i);
                }
                break;
            case "":
                if (usuario.equals("") && contrasena.equals(""))
                {
                    msj.setVisibility(View.VISIBLE);
                    msj.setText("Campos vacios, por favor intenta nuevamente");
                }
                break;
            default:
                if (!usuario.equals(userObj) && !contrasena.equals(passObj))
                {
                    msj.setVisibility(View.VISIBLE);
                    msj.setText("Campos incorrectos por favor intentar nuevamente");

                }
                break;
        }

    }

    public void cerrar (View view)
    {
        System.exit(0);
    }

}