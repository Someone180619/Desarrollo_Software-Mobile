package com.example.taller_n17_fragments_dinamicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragment_inicio, fragment_rojo, fragment_verde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_inicio = new fragment_inicio();
        fragment_rojo = new fragment_rojo();
        fragment_verde = new fragment_verde();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment, fragment_inicio).commit();
    }

    public void onclick(View view){
        transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.btnRojo:
                transaction.replace(R.id.contenedorFragment, fragment_rojo);
                transaction.addToBackStack(null);
                break;

            case R.id.btnVerde:
                transaction.replace(R.id.contenedorFragment, fragment_verde);
                transaction.addToBackStack(null);
                break;
        }

        transaction.commit();
    }
}