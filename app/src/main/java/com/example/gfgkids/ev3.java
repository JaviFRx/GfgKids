package com.example.gfgkids;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ev3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ev3);
    }
    public  void ir_inicio(View view) {
        Intent pantalla_new = new Intent(this, MainActivity.class);
        startActivity(pantalla_new);
    }

    public void seleccion (@NonNull View boton){
        String nombre_del_pdf ="";
        switch (boton.getId()){
            case R.id.B_Helicoptero:
                nombre_del_pdf = "helocoptero.pdf";
                break;
            case R.id.B_blaze:
                nombre_del_pdf = "blaze.pdf";
                break;
            case R.id.B_catapulta:
                nombre_del_pdf = "catapulta wedo.pdf";
                break;
            case R.id.B_araña:
                nombre_del_pdf = "araña.pdf";
                break;
            case R.id.B_Boxeador:
                nombre_del_pdf = "Boxeador.pdf";
                break;
            case R.id.B_Giromaker:
                nombre_del_pdf = "catapulta giromaker.pdf";
                break;
            case R.id.B_Lanzador_manual:
                nombre_del_pdf = "lanzador manual.pdf";
                break;
            case R.id.B_Sumo:
                nombre_del_pdf = "sumo wedo2.pdf";
                break;
            case R.id.Contenedor:
                nombre_del_pdf = "Arbol Navidad.pdf";
                break;
            case R.id.B_Quitanieves:
                nombre_del_pdf = "quitanieves.pdf";
                break;
        }

        Intent pantalla_new = new Intent(this, pdf.class);
        pantalla_new.putExtra("datos_a_enviar", nombre_del_pdf);
        startActivity(pantalla_new);
    }
}