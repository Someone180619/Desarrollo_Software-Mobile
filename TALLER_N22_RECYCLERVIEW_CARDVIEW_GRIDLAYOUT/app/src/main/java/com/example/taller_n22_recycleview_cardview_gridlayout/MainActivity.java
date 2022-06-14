package com.example.taller_n22_recycleview_cardview_gridlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Libro> libro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        libro = new ArrayList<>();
        libro.add(new Libro("El abandono", "Categoria de Libro", "Descripcion del libro", R.drawable.el_abandono));
        libro.add(new Libro("El beso que no te di", "Categoria de Libro", "Descripcion del libro", R.drawable.el_beso_que_no_te_di));
        libro.add(new Libro("El final del viaje", "Categoria de Libro", "Descripcion del libro", R.drawable.el_final_del_viaje));
        libro.add(new Libro("El quinto infierno", "Categoria de Libro", "Descripcion del libro", R.drawable.el_quinto_infierno));
        libro.add(new Libro("Harry potter", "Categoria de Libro", "Descripcion del libro", R.drawable.harry_potter));
        libro.add(new Libro("Laila Winter", "Categoria de Libro", "Descripcion del libro", R.drawable.laila_winter));
        libro.add(new Libro("Lo que el viento se llevo", "Categoria de Libro", "Descripcion del libro", R.drawable.lo_que_el_viento_se_llevo));
        libro.add(new Libro("Matar a un ruiseñor", "Categoria de Libro", "Descripcion del libro", R.drawable.matar_a_un_ruisenor));
        libro.add(new Libro("Todas las hadas del reino", "Categoria de Libro", "Descripcion del libro", R.drawable.todas_las_hadas_del_reino));
        libro.add(new Libro("Viaje al centro de la tierra", "Categoria de Libro", "Descripcion del libro", R.drawable.viaje_al_centro_de_la_tierra));
        libro.add(new Libro("El abandono", "Categoria de Libro", "Descripcion del libro", R.drawable.el_abandono));
        libro.add(new Libro("El beso que no te di", "Categoria de Libro", "Descripcion del libro", R.drawable.el_beso_que_no_te_di));
        libro.add(new Libro("El final del viaje", "Categoria de Libro", "Descripcion del libro", R.drawable.el_final_del_viaje));
        libro.add(new Libro("El quinto infierno", "Categoria de Libro", "Descripcion del libro", R.drawable.el_quinto_infierno));
        libro.add(new Libro("Harry potter", "Categoria de Libro", "Descripcion del libro", R.drawable.harry_potter));
        libro.add(new Libro("Laila Winter", "Categoria de Libro", "Descripcion del libro", R.drawable.laila_winter));
        libro.add(new Libro("Lo que el viento se llevo", "Categoria de Libro", "Descripcion del libro", R.drawable.lo_que_el_viento_se_llevo));
        libro.add(new Libro("Matar a un ruiseñor", "Categoria de Libro", "Descripcion del libro", R.drawable.matar_a_un_ruisenor));
        libro.add(new Libro("Todas las hadas del reino", "Categoria de Libro", "Descripcion del libro", R.drawable.todas_las_hadas_del_reino));
        libro.add(new Libro("Viaje al centro de la tierra", "Categoria de Libro", "Descripcion del libro", R.drawable.viaje_al_centro_de_la_tierra));
        libro.add(new Libro("El abandono", "Categoria de Libro", "Descripcion del libro", R.drawable.el_abandono));
        libro.add(new Libro("El beso que no te di", "Categoria de Libro", "Descripcion del libro", R.drawable.el_beso_que_no_te_di));
        libro.add(new Libro("El final del viaje", "Categoria de Libro", "Descripcion del libro", R.drawable.el_final_del_viaje));
        libro.add(new Libro("El quinto infierno", "Categoria de Libro", "Descripcion del libro", R.drawable.el_quinto_infierno));
        libro.add(new Libro("Harry potter", "Categoria de Libro", "Descripcion del libro", R.drawable.harry_potter));
        libro.add(new Libro("Laila Winter", "Categoria de Libro", "Descripcion del libro", R.drawable.laila_winter));
        libro.add(new Libro("Lo que el viento se llevo", "Categoria de Libro", "Descripcion del libro", R.drawable.lo_que_el_viento_se_llevo));
        libro.add(new Libro("Matar a un ruiseñor", "Categoria de Libro", "Descripcion del libro", R.drawable.matar_a_un_ruisenor));
        libro.add(new Libro("Todas las hadas del reino", "Categoria de Libro", "Descripcion del libro", R.drawable.todas_las_hadas_del_reino));
        libro.add(new Libro("Viaje al centro de la tierra", "Categoria de Libro", "Descripcion del libro", R.drawable.viaje_al_centro_de_la_tierra));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, libro);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(myAdapter);
    }
}