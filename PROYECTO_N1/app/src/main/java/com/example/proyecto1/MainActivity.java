/*
    Integrantes         Cédula
    Brandool Cortez     (3-742-294)
    Gabriel García      (8-955-58)
    Gloria Jimenez      (8-961-700)
    Oriel Delgado       (8-970-187)
    Yulissa Restrepo    (8-961-1900)
 */
package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((ImageView) findViewById(R.id.bola)).setImageResource(0);
    }

    public void onClick(View view) {
        ImageView bola = (ImageView) findViewById(R.id.bola);
        bola.setImageResource(R.drawable.bola);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.movimiento);
        bola.startAnimation(animation);
    }
}