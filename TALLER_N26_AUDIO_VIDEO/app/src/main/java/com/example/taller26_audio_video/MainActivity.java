/*
* BRANDOOL CORTEZ [3-742-294] | 1SF141
* */

package com.example.taller26_audio_video;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    AudioManager audioManager;
    SeekBar volumeControl;
    SeekBar scrubber;
    MediaPlayer audio;

    MediaController controller;
    VideoView video;

    public void PlayAudio(View view){
        audio.start();
        (findViewById(R.id.btn1)).setVisibility(View.INVISIBLE);
        (findViewById(R.id.btn2)).setVisibility(View.INVISIBLE);
    }

    public void PauseAudio(View view){
       if(audio.isPlaying())
            audio.pause();
       (findViewById(R.id.btn1)).setVisibility(View.VISIBLE);
       (findViewById(R.id.btn2)).setVisibility(View.INVISIBLE);
    }

    public void PlayVideo(View view){
        video.start();
    }

    public void PauseVideo(View view){
        if(video.isPlaying())
            video.pause();
    }


    public void Play(View view){
        (findViewById(R.id.frontal)).setVisibility(View.INVISIBLE);
        if((view.getResources().getResourceName(view.getId())).equals("audioPlay")){
            (findViewById(R.id.audio)).setVisibility(View.VISIBLE);
            PlayAudio(view);
        }
        else{
            (findViewById(R.id.video)).setVisibility(View.VISIBLE);
            PlayVideo(view);
        }
    }

    public void Back(View view){
        PauseAudio(view);
        PauseVideo(view);
        (findViewById(R.id.audio)).setVisibility(View.INVISIBLE);
        (findViewById(R.id.video)).setVisibility(View.INVISIBLE);
        (findViewById(R.id.frontal)).setVisibility(View.VISIBLE);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        video = (VideoView) findViewById(R.id.videoView);
        video.setVideoPath("android.resource://"+getOpPackageName()+"/"+R.raw.crabrave_video);
        controller = new MediaController(this);
        controller.setAnchorView(video);

        volumeControl = (SeekBar) findViewById(R.id.seekBar1);
        audio = MediaPlayer.create(this,R.raw.crabrave_audio);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolumen = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolumen = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volumeControl.setMax(maxVolumen);
        volumeControl.setProgress(curVolumen);
        scrubber = (SeekBar) findViewById(R.id.seekBar2);
        scrubber.setMax(audio.getDuration());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubber.setProgress(audio.getCurrentPosition());
                volumeControl.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            }
            }, 0 , 100);

        scrubber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b)
                    audio.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}