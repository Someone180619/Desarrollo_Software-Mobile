package com.example.semestral;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;


/*
 * Activity que se linkea con ListaFotosAdapter.class para mostrar todas
 * las fotos almacenadas en la base de datos
 * */
public class GaleriaActivity extends AppCompatActivity {

    RecyclerView listaFotos;
    ArrayList<Fotos> listaArrayFotos;
    DbFotos dbFotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
        dbFotos = new DbFotos(GaleriaActivity.this);
        listaFotos = findViewById(R.id.listaFotos);
        setListView();
    }

    //Aqui se agrega el ciclo de vida
    @Override
    protected void onStart() {
        super.onStart();
        setListView();
    }

    private void setListView() {
        listaFotos.setLayoutManager(new LinearLayoutManager(this));
        listaArrayFotos = new ArrayList<>();
        ListaFotosAdapter adapter = new ListaFotosAdapter(this, dbFotos.mostrarFotos());
        listaFotos.setAdapter(adapter);
    }

}
