package com.example.taller_n19_fragment_vertical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View view){
            @Override
            public void onClick(View view){
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(!status){
                    fragment_uno f1 = new fragment_uno();
                    fragmentTransaction.add(R.id.fragment_container, f1);
                    fragmentTransaction.commit();
                    btn1.setText("Cargando Fragment Dos");
                    status = True;
                } else {
                    fragment_dos f1 = new fragment_dos();
                    fragmentTransaction.add(R.id.fragment_container, f2);
                    fragmentTransaction.commit();
                    btn1.setText("Cargando Fragment Uno");
                    status = False;
                }
            }
        }
    }
}