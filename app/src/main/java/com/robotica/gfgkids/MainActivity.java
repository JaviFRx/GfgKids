package com.robotica.gfgkids;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private final String TAG = "myApp";

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
    @Override
    public void onBackPressed(){    }

}