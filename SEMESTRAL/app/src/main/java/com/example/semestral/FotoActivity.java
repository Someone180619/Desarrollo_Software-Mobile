package com.example.semestral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.semestral.DbFotos;
/*
 *Activity que muestra la foto de la galeria que fue seleccionada,
 * junto con un boton de eliminar y de regresar.
 */
public class FotoActivity extends AppCompatActivity {
    TextView idFoto2, tituloFoto2, fechaFoto2;
    ImageView imageViewFoto2;
    Button btnRegresar, btnEliminar, btnGuardar;

    Bitmap fotoBitmap;
    String id, titulo, fecha;

    int idDb = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_foto);

        DbFotos dbFotos = new DbFotos(FotoActivity.this);

        idFoto2 =findViewById(R.id.idFoto2);
        tituloFoto2 = findViewById(R.id.tituloFoto2);
        fechaFoto2 = findViewById(R.id.fechaFoto2);
        imageViewFoto2 = findViewById(R.id.imageViewFoto2);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnGuardar = findViewById(R.id.btnGuardar);

        obtenerDatos ();
        fijarDatos();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Cambio del titulo
                String nuevoTitulo = tituloFoto2.getText().toString();
                if(dbFotos.actualizarFoto(idDb, nuevoTitulo)) {
                    Toast.makeText(FotoActivity.this, "El titulo ha sido cambiado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(FotoActivity.this, "No se pudo actualizar la foto", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Elimina la foto seleccionada en la lista de activity_galeria.xml
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dbFotos.eliminarFoto(idDb)){
                    regresarGaleria ();
                    Toast.makeText(FotoActivity.this, "La foto " + idDb + " fue eliminada", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(FotoActivity.this, "No se pudo eliminar la foto", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresarGaleria ();
            }
        });
    }

    //Funcion para obtener los datos del item de la lista que se seleccionó desde activity_galeria.xml
    private void obtenerDatos() {
        if (getIntent().hasExtra("ID") && getIntent().hasExtra("Foto") && getIntent().hasExtra("Titulo") && getIntent().hasExtra("Fecha")){
            fotoBitmap = BitmapFactory.decodeFile(getIntent().getStringExtra("Foto"));

            //Variable utilizada para eliminar foto en la base de datos
            idDb = Integer.parseInt(getIntent().getStringExtra("ID"));

            id = getIntent().getStringExtra("ID");
            titulo = getIntent().getStringExtra("Titulo");
            fecha = getIntent().getStringExtra("Fecha");

        } else {
            Toast.makeText(this, "No hay datos", Toast.LENGTH_SHORT).show();
        }
    }

    //Funcion para fijar los datos obtenidos desde activity_foto.xml
    private void fijarDatos() {
        idFoto2.setText(id);
        tituloFoto2.setText(titulo);
        fechaFoto2.setText(fecha);
        imageViewFoto2.setImageBitmap(fotoBitmap);
    }

    //Funcion para regresar a la galeria
    private void regresarGaleria () {
        Intent regresarGaleria = new Intent(this, GaleriaActivity.class);
        startActivity(regresarGaleria);
    }
}
