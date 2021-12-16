package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Home_act extends AppCompatActivity {

    private VideoView video;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = findViewById(R.id.videoView);
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);
        MediaController media = new MediaController(this);
        video.setMediaController(media);
        video.start();
    }
    public void Ficha (View view){
        Intent i = new Intent(getBaseContext(), Gestion_Animales_act.class);
        startActivity(i);
    }

    public void Ingresos(View view) {
        Intent i = new Intent(getBaseContext(), Ingresos_Act.class);
        startActivity(i);
    }
}