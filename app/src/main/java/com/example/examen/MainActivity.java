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
    }

    public void LoadSession(View view){
        String usuario = user.getText().toString().trim();
        String contrasena = pass.getText().toString().trim();

        String userObj= adm.getUser().toString().trim();
        String passObj= adm.getPass().toString().trim();

        msj.setVisibility(View.INVISIBLE);


        switch (usuario){
            case "Sofia":
                if(usuario.equals(userObj) && contrasena.equals(passObj)){
                    //inicio sesion
                    Intent i = new Intent(getBaseContext(), Home_act.class);
                    startActivity(i);
                }
                break;
            case "":
                if(usuario.equals("") && contrasena.equals("")){
                    //campos vacios
                    msj.setVisibility(View.VISIBLE);
                    msj.setText("Campos vacíos, por favor intente nuevamente");
                }
                break;
            default:
                if(!usuario.equals(userObj) && !contrasena.equals(passObj)){
                    //incorrectos
                    msj.setVisibility(View.VISIBLE);
                    msj.setText("Campos incorrectos. Por favor intente nuevamente");
                }
                break;
        }
    }

}