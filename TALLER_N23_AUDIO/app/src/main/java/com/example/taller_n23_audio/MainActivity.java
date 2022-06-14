package com.example.taller_n23_audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private MediaPlayer mediaPlayer;
    private Handler updateHandler = new Handler();
    private SeekBar seekBar;
    private TextView nomCan, tieCan, durCan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomCan = (TextView) findViewById(R.id.nomCan);
        nomCan.setText("Crab Rave");

        mediaPlayer = MediaPlayer.create(this, R.raw.crabrave);
        durCan = (TextView) findViewById(R.id.durCan);

        int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(mediaPlayer.getDuration());
        int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getDuration());

        durCan.setText(String.format("%02d:%02d", minutes, seconds));
        tieCan = (TextView) findViewById(R.id.tieCan);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax((int)mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) this);

        updateHandler = new Handler();
        updateHandler.postDelayed(update, 100);
    }

    private Runnable update = new Runnable () {
        @Override
        public void run() {
            long currentTime = mediaPlayer.getCurrentPosition();
            seekBar.setProgress((int) currentTime);
            int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(currentTime);
            int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(currentTime) - minutes * 60;

            tieCan.setText(String.format("%02d:%02d", minutes, seconds));
            updateHandler.postDelayed(this, 100);
        }
    };

    public void Play (View view) { mediaPlayer.start();}

    public void Pause (View view) { mediaPlayer.pause();}

    public void Stop (View view) {
        mediaPlayer.stop();
        mediaPlayer = mediaPlayer.create(this, R.raw.crabrave);
    }

    @Override
    public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser){
            mediaPlayer.seekTo(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch (SeekBar seekBar) {

    }
}