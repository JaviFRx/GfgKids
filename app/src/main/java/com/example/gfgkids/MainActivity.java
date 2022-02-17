package com.example.gfgkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pantalla_wedo(View view){
        Intent pantalla_new = new Intent(this, wedo.class);
        startActivity(pantalla_new);
    }
    public void pantalla_ev3(View view){
        Intent pantalla_new = new Intent(this, ev3.class);
        startActivity(pantalla_new);
    }
    public  void ir_inicio(View view) {
        Intent pantalla_new = new Intent(this, MainActivity.class);
        startActivity(pantalla_new);
    }
}