package com.example.taller_n10_animaciones_con_constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                imageView.startAnimation(animation);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clock);
                imageView.startAnimation(animation);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                imageView.startAnimation(animation);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                imageView.startAnimation(animation);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
                imageView.startAnimation(animation);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
                imageView.startAnimation(animation);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.clearAnimation();
            }
        });
    }
}