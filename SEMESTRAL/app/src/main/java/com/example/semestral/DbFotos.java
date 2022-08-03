package com.example.semestral;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.semestral.Fotos;
import com.example.semestral.MainActivity;

import java.util.ArrayList;

/*
 * Utiliza DbHelper.class para realizar consultas, insersiones y eliminacion de datos
 * en la tabla Fotos de la BD Galeria.
 * */

public class DbFotos extends DbHelper {
    Context context;

    public DbFotos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarFoto(String rutaImagen,  String tituloImagen) {
        long id = 0;

        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("RutaImagen", rutaImagen);
            values.put("TituloImagen", tituloImagen);

            id = db.insert(TABLE_FOTOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList <Fotos> mostrarFotos (){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Fotos> listaFotos = new ArrayList<>();
        Fotos foto = null;

        Cursor cursorFotos = null;
        cursorFotos = db.rawQuery("SELECT * FROM " + TABLE_FOTOS, null);

        if (cursorFotos.moveToFirst()){
            do{
                foto = new Fotos();
                foto.setID(cursorFotos.getInt(0));
                foto.setRutaImagen(cursorFotos.getString(1));
                foto.setFechaCreacion(cursorFotos.getString(2));
                foto.setTituloImagen(cursorFotos.getString(3));
                listaFotos.add(foto);
            }while(cursorFotos.moveToNext());
        }
        cursorFotos.close();
        return listaFotos;
    }

    public boolean eliminarFoto (int id){

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try{
            db.execSQL("DELETE FROM " + TABLE_FOTOS + " WHERE ID = '" + id + "'");
            correcto = true;
        }catch (Exception ex){
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }
        return correcto;
    }

    public boolean actualizarFoto (int id, String nuevoTitulo){

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try{
            db.execSQL("UPDATE  " + TABLE_FOTOS + " SET TituloImagen = '" + nuevoTitulo + "' WHERE ID = '" + id + "'");
            correcto = true;
        }catch (Exception ex){
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }
        return correcto;
    }


    /* Pasos para crear cambiar titul
    1) Cambiar el cambpo de tituloImagen2 a un edittext
    2) Extraer el string con getText().toString()
    3) Crear el metodo de actualizarTitulo el que obtiene el id de la imagen y el nuevoTitulo
    4) Utilizar la sentencia UPDATE de SQL
    5) Invocar el metodo setlistview de galeria activity en un boton guardar o directamente en el regresar
    6) Es probable que sea necesario actualizar el cursor que se obtienem, es decir invocar el metodo mostrarFotos cuando se
    regresa o guarda.
    7) Es probable que en galeria activity debamos agregar algun ciclo de vida para que cada que volvamos a la pagina se asigne
    el cursor al listvieiw
     */

}

