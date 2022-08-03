package com.example.semestral;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnCamara, btnGaleria;
    ImageView imageView;
    String rutaImagen;
    String tituloImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout  = findViewById(R.id.galeria);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        //Crea la base de datos llamada Galeria
        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        if (db == null) {
            Toast.makeText(this, "La galeria no fue creada", Toast.LENGTH_LONG).show();
        }

        btnCamara = findViewById(R.id.btnCamara);
        btnGaleria = findViewById(R.id.btnGaleria);
        imageView = findViewById(R.id.imageView);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamara();
            }
        });

        btnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GaleriaActivity.class);
                startActivity(intent);
            }
        });
    }

    //Permite activar la camara del dispositivo
    private void abrirCamara () {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            File imagenArchivo = null;

            try {
                imagenArchivo = crearImagen();
            } catch (IOException ex) {
                Log.e("Error", ex.toString());
            }

            if (imagenArchivo != null) {
                Uri fotoUri = FileProvider.getUriForFile(this, "com.example.semestral_galeria.fileprovider", imagenArchivo);

                intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
                startActivityForResult(intent, 1);
            }
        }
    }

    //Almacena la foto tomada con la camaba en la BD y la muestra en el imageView de activity_main.xml
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Bundle extras = data.getExtras();

            DbFotos dbFotos = new DbFotos(MainActivity.this);
            long id = dbFotos.insertarFoto(rutaImagen.toString(), tituloImagen.toString());

            if (id > 0) {
                Toast.makeText(this, "La foto se guardó en la galeria", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No se pudo guardar la foto en la galeria", Toast.LENGTH_LONG).show();
            }

            Bitmap imageBitmap = BitmapFactory.decodeFile(rutaImagen);
            imageView.setImageBitmap(imageBitmap);
        }
    }

    //Crea un archivo temporal para la foto tomada con la camara
    private File crearImagen () throws IOException {
        String nombreImagen = "foto_";
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagen = File.createTempFile(nombreImagen, ".jpg", directorio);

        rutaImagen = imagen.getAbsolutePath();
        tituloImagen = imagen.getName();
        return imagen;
    }

}
