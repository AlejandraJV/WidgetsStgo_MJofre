package com.example.widgetsstgo_mariajofre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //
    private ProgressBar barra;
    private CheckBox calificaciones, productos;
    private TextView texto;
    private int progreso; //progreso de la barra


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra = (ProgressBar)findViewById(R.id.pb);
        calificaciones = (CheckBox)findViewById(R.id.ch1);
        productos = (CheckBox)findViewById(R.id.ch2);
        texto = (TextView)findViewById(R.id.tv);

    }
    //Rellenar el progressBar
    public void Charge(View view)
    {
        final Timer t = new Timer(); //Crea un temporizador

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() { //proceso que voy a ejecutar
                //rellenar la barra de progreso
                progreso++;
                barra.setProgress(progreso); //rellenar la barra
                texto.setText("El progreso es: " + barra.getProgress() + "/ 100");
            }
        };
        t.schedule(tarea, 0,100); //pasar tarea al temporizador
    }

    public void Menu(View view)
    {
        //si seleccionamos las 2 opciones
        if(calificaciones.isChecked() && productos.isChecked())
        {
            texto.setText("Seleccione una sola opción, por favor.");
        }
        else
        {
            if(calificaciones.isChecked())
            {
                //de este contexto me voy a Calificaciones
                Intent i = new Intent(this, Calificaciones_act.class);
                startActivity(i); // inicia la actividad
            }

            if(productos.isChecked())
            {
                Intent i = new Intent(this, Productos_act.class);
                startActivity(i); // inicia la actividad

            }
        }

    }
}