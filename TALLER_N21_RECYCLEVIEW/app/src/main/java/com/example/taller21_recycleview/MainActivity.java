package com.example.taller21_recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.androidstudio, R.drawable.c, R.drawable.cpp, R.drawable.java,
            R.drawable.matlab, R.drawable.php, R.drawable.python, R.drawable.ruby,
            R.drawable.sharp, R.drawable.vb};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.Software_Programación);
        s2 = getResources().getStringArray(R.array.Descripción);

        myAdapter myAdapter = new myAdapter( this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}