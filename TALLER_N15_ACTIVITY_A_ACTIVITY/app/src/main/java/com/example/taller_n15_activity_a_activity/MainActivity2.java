//TALLER N°15 | BRANDOOL CORTEZ [3-742-294] | 1SF141
package com.example.taller_n15_activity_a_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("MainActivity_2");

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        Intent intent = getIntent();
        String nom = intent.getStringExtra("Nombre");
        String tel = intent.getStringExtra("Telefono");

        tv1.setText(nom);
        tv2.setText(tel);
    }
}