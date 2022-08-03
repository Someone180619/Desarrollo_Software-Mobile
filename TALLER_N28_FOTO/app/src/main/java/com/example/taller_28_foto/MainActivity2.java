package com.example.taller_28_foto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;

public class MainActivity2 extends AppCompatActivity {

    private ListView listView;
    private ImageView imageView2;
    private String[] archivos;
    private ArrayAdapter<String> adaptador;
    private String ruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        File dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        archivos = dir.list();
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, archivos);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adaptador);

        imageView2 = (ImageView) findViewById(R.id.imageView2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bitmap bitmap = BitmapFactory.decodeFile(getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/" + archivos[i]);
                imageView2.setImageBitmap(bitmap);
            }
        });

    }
}