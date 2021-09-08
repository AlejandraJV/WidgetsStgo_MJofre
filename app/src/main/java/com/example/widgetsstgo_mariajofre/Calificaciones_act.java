package com.example.widgetsstgo_mariajofre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class Calificaciones_act extends AppCompatActivity {

    private RatingBar calificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificaciones);

        calificacion = (RatingBar)findViewById(R.id.rbar);
    }

    public void Calificar(View view)
    {
        calificacion.setNumStars(5); //cambia el número de estrellas
        calificacion.setRating(5);//pinta estrellas
        float rat = calificacion.getRating();
        Toast.makeText(this,"La calificación es: " + rat, Toast.LENGTH_SHORT).show();
    }
    public void Volver(View view)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}