package com.example.taller_n24_audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_play, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int posicion = 0, repetir = 2;

    MediaPlayer vectormp [] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_play = (Button) findViewById(R.id. btn_play);
        btn_repetir = (Button) findViewById(R.id.btn_repetir);
        iv = (ImageView) findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(this, R.raw.crab_rave);
        vectormp[1] = MediaPlayer.create(this, R.raw.for_narmer);
        vectormp[2] = MediaPlayer.create(this, R.raw.sleeping_in_the_cold_below);
    }

    public void PlayPause(View view) {
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            btn_play.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pause", Toast.LENGTH_LONG).show();
        } else {
            vectormp[posicion].start();
            btn_play.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_LONG).show();
        }
    }

    public void Stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();
            vectormp[0] = MediaPlayer.create(this, R.raw.crab_rave);
            vectormp[1] = MediaPlayer.create(this, R.raw.for_narmer);
            vectormp[2] = MediaPlayer.create(this, R.raw.sleeping_in_the_cold_below);

            posicion = 0;
            btn_play.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_LONG).show();
        }
    }

    public void Repetir(View view){
        if(repetir == 1){
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No Repetir", Toast.LENGTH_LONG).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        } else {
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_LONG).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    public void Anterior (View view){
        if(posicion >= 1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.crab_rave);
                vectormp[1] = MediaPlayer.create(this, R.raw.for_narmer);
                vectormp[2] = MediaPlayer.create(this, R.raw.sleeping_in_the_cold_below);

                posicion--;
                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    iv.setBackgroundResource(R.drawable.portada2);
                } else if (posicion == 2){
                    iv.setBackgroundResource(R.drawable.portada3);
                }
            }
        } else {
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_LONG).show();
        }
    }

    public void Siguiente (View view){
        if(posicion<vectormp.length -1){
            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();

                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    iv.setBackgroundResource(R.drawable.portada2);
                } else if (posicion == 2){
                    iv.setBackgroundResource(R.drawable.portada3);
                }
            } else {
                posicion++;
                if(posicion == 0){
                    iv.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    iv.setBackgroundResource(R.drawable.portada2);
                } else if (posicion == 2){
                    iv.setBackgroundResource(R.drawable.portada3);
                }
            }
        } else {
            Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_LONG).show();
        }
    }
}