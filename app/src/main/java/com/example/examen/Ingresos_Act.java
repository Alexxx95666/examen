package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Ingresos;

public class Ingresos_Act extends AppCompatActivity {
    private Spinner Tipo, Enfermedad;
    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos);

        Tipo = findViewById(R.id.sp1);
        Enfermedad = findViewById(R.id.sp2);
        Resultado = findViewById(R.id.tvResultado);

        Ingresos i = new Ingresos();
        ArrayAdapter adapterTipo = new ArrayAdapter(this, android.R.layout.simple_list_item_1, i.getTipo());
        Tipo.setAdapter(adapterTipo);
        ArrayAdapter adapterEnfermedad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, i.getEnfermedad());
        Enfermedad.setAdapter(adapterEnfermedad);
    }

    public void Calcular (){
        Ingresos ingre = new Ingresos();
        int [] TipoPrecio = ingre.getTipoPrecio();
        int [] EnfermedadPrecio = ingre.getEnfermedadPrecio();

        String tipo = Tipo.getSelectedItem().toString();
        String enfermedad = Enfermedad.getSelectedItem().toString();

        if(Tipo.equals("Domestico") && Enfermedad.equals ("Brucelosis") ) {
            Resultado.setVisibility(View.VISIBLE);
            Resultado.setText("La cotizacion final es: " + ingre.Resultado(TipoPrecio[0], EnfermedadPrecio[0]));
        }
        if(Tipo.equals("Domestico") && Enfermedad.equals ("Fiebre Aftosa") ) {
            Resultado.setVisibility(View.VISIBLE);
            Resultado.setText("La cotizacion final es: " + ingre.Resultado(TipoPrecio[0], EnfermedadPrecio[0]));
        }
        if(Tipo.equals("Domestico") && Enfermedad.equals ("Salmonella") ) {
            Resultado.setVisibility(View.VISIBLE);
            Resultado.setText("La cotizacion final es: " + ingre.Resultado(TipoPrecio[0], EnfermedadPrecio[0]));
        }
        if(Tipo.equals("Domestico") && Enfermedad.equals ("Rabia") ) {
            Resultado.setVisibility(View.VISIBLE);
            Resultado.setText("La cotizacion final es: " + ingre.Resultado(TipoPrecio[0], EnfermedadPrecio[0]));
        }
        if(Tipo.equals("Domestico") && Enfermedad.equals ("Brucelosis") ) {
            Resultado.setVisibility(View.VISIBLE);
            Resultado.setText("La cotizacion final es: " + ingre.Resultado(TipoPrecio[0], EnfermedadPrecio[0]));
        }
    }
}