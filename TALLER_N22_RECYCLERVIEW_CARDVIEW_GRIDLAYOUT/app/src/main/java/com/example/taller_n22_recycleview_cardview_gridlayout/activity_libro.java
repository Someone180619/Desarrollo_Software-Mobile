package com.example.taller_n22_recycleview_cardview_gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_libro extends AppCompatActivity {

    private TextView tvtitulo, tvcategoria, tvdescripcion;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro);

        tvtitulo = (TextView) findViewById(R.id.tvtitulo);
        tvcategoria = (TextView) findViewById(R.id.tvcategoria);
        tvdescripcion = (TextView) findViewById(R.id.tvdescripcion);
        img = (ImageView) findViewById(R.id.imagenLibrominiatura);

        Intent intent = getIntent();
        String titulo = intent.getExtras().getString("Titulo");
        String descripcion = intent.getExtras().getString("Descripcion");
        String categoria = intent.getExtras().getString("Categoria");
        int image = intent.getExtras().getInt("Miniatura");

        tvtitulo.setText(titulo);
        tvdescripcion.setText(descripcion);
        tvcategoria.setText(categoria);
        img.setImageResource(image);
    }
}