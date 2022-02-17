package com.example.gfgkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class pdf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        String recivido = getIntent().getStringExtra("datos_a_enviar");

        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset(recivido)
                //.pages(0, 2, 1, 3, 3, 3) // todas las páginas se muestran por defecto
                .enableSwipe(true) // permite bloquear el cambio de páginas usando deslizar
                .swipeHorizontal(false)
                .enableDoubletap(false)
                .defaultPage(0)
                .enableAntialiasing(true) // mejorar un poco el renderizado en pantallas de baja resolución
                .autoSpacing(true) // agregue espaciado dinámico para que cada página se ajuste a sí misma en la pantalla
                .fitEachPage(true) // ajuste cada página a la vista; de lo contrario, las páginas más pequeñas se escalan en relación con la página más grande.
                .pageSnap(true) // ajustar páginas a los límites de la pantalla
                .pageFling(true) // hacer un cambio de aventura solo una página como ViewPager
                .nightMode(false) // alternar el modo nocturno
                .enableAnnotationRendering(false) //permitir anotaciones
                .password(null)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(0) //espacio entre pag
                .pageFitPolicy(FitPolicy.WIDTH) // modo para ajustar páginas en la vista
                .load();

    }

    public  void ir_inicio(View view){
        Intent pantalla_new = new Intent(this, MainActivity.class);
        startActivity(pantalla_new);
    }
}