//Taller N°11 | Brandool Cortez [3-742-294] | 1SF141
package com.example.taller11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=(Button) findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View){
                ImageView ImageView = (ImageView) findViewById(R.id.imageView);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.secuencia);
                ImageView.startAnimation(animation);
            }
        });

    }
}