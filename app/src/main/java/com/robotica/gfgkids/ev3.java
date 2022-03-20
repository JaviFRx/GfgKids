package com.robotica.gfgkids;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.robotica.gfgkids.R;


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
            case R.id.B_carreras:
                nombre_del_pdf = "Carreras.pdf";
                break;
            case R.id.B_futbol:
                nombre_del_pdf = "Futbol.pdf";
                break;
            case R.id.B_Boxeo:
                nombre_del_pdf = "boxeadorev3.pdf";
                break;
            case R.id.B_dino:
                nombre_del_pdf = "dino ev3.pdf";
                break;
            case R.id.b_tanque:
                nombre_del_pdf = "tanque.pdf";
                break;
            case R.id.b_coche_f1:
                nombre_del_pdf = "cochef1.pdf";
                break;
        }

        Intent pantalla_new = new Intent(this, pdf.class);
        pantalla_new.putExtra("datos_a_enviar", nombre_del_pdf);
        startActivity(pantalla_new);
    }
}