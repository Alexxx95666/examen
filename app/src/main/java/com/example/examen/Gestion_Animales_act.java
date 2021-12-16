package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examen.db.DbHelper;

public class Gestion_Animales_act extends AppCompatActivity {

    Button Añadir, Mostrar, Eliminar;
    EditText Codigo, Nombre, Tipo, Edad, Enfermedad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_animales);

        Añadir = findViewById(R.id.btnAñadir);
        Mostrar = findViewById(R.id.btnMostrar);
        Eliminar = findViewById(R.id.btnEliminar);


        Codigo = findViewById(R.id.tvficha);
        Nombre = findViewById(R.id.tvnombre);
        Tipo = findViewById(R.id.tvtipo);
        Edad= findViewById(R.id.tvedad);
        Enfermedad = findViewById(R.id.tvenfermedad);
    }

    public void Clean(){
        Codigo.setText("");
        Nombre.setText("");
        Tipo.setText("");
        Edad.setText("");
        Enfermedad.setText("");

    }

    public void Añadir(View view) {
        DbHelper admin = new DbHelper(this, "veticalcare",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = Codigo.getText().toString();
        String nombre = Nombre.getText().toString();
        String tipo = Tipo.getText().toString();
        String edad = Edad.getText().toString();
        String enfermedad = Enfermedad.getText().toString();

        if (!codigo.isEmpty() && !nombre.isEmpty() && !tipo.isEmpty()&& !edad.isEmpty()&& !enfermedad.isEmpty()) {

            ContentValues values = new ContentValues();
            values.put("codigo",codigo);
            values.put("nombre",nombre);
            values.put("tipo",tipo);
            values.put("edad",edad);
            values.put("enfermedad",enfermedad);

            db.insert("Ficha",null,values);
            db.close();
            Clean();
            Toast.makeText(this, "Has guardado una ficha",Toast.LENGTH_LONG).show();
        } else
        {
            Toast.makeText(this, "Los campos están vacios",Toast.LENGTH_LONG).show();

        }
    }

    public void Mostrar(View view){
        DbHelper admin = new DbHelper(this, "veticalcare",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = Codigo.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor file = db.rawQuery
                    ("SELECT nombre,tipo, edad, enfermedad FROM Ficha WHERE codigo="+codigo,null);
            if(file.moveToFirst())
            {
                Nombre.setText(file.getString(0));
                Tipo.setText(file.getString(1));
                Edad.setText(file.getString(2));
                Enfermedad.setText(file.getString(3));

            }
            else
            {
                Toast.makeText(this,"No hay elementos",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"No hay clase asociada",Toast.LENGTH_LONG).show();
        }
    }

    public void Eliminar (View v)
    {
        DbHelper admin = new DbHelper(this, "biofit",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = Codigo.getText().toString();

        if(!codigo.isEmpty())
        {
            int cant = db.delete("Ficha", "codigo="+codigo,null);
            db.close();
            Clean();

            if(cant==1)
            {
                Toast.makeText(getBaseContext(),"Eliminaste una clase asociada a: " +codigo, Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(getBaseContext(),"No existe la clase en la database", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(getBaseContext(),"No hay clase asociada", Toast.LENGTH_SHORT).show();
        }

    }
}