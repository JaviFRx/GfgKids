package com.robotica.gfgkids;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


public class pdf extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

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

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });


    }

    public  void ir_inicio(View view){
        publicidad();
       // volver_al_inicio();
    }
    public void volver_al_inicio(){
        Intent pantalla_new = new Intent(this, MainActivity.class);
        startActivity(pantalla_new);
    }

    public void publicidad( ){
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(pdf.this,"ca-app-pub-7646700747398841/7423347805", adRequest,
                // "ca-app-pub-3940256099942544/1033173712" para pruebas
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");

                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                Log.d("TAG", "El anuncio fue descartado.");
                                volver_al_inicio();
                            }


                            @Override
                            public void onAdFailedToShowFullScreenContent( @NonNull AdError adError) {
                                Log.d("TAG", "El anuncio no se mostro");
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                mInterstitialAd = null;
                                Log.d("TAG", "El anuncio se mostro");
                               // volver_al_inicio();
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });
        if (mInterstitialAd != null) {
            mInterstitialAd.show(pdf.this);
        } else {
            Log.d("TAG", "El anuncio intersticial aún no estaba listo.");
            Toast.makeText(this, "El anuncio intersticial aún no estaba listo.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed(){
        publicidad();
    }

}