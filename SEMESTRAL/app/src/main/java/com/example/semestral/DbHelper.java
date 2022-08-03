package com.example.semestral;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
/*
 * Crea la base de datos llamada Galeria y la tabla Fotos
 * */
public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "Galeria";
    public static final String TABLE_FOTOS = "Fotos";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    //Crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s(ID INTEGER PRIMARY KEY AUTOINCREMENT, RutaImagen TEXT NOT NULL, FechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP,TituloImagen TEXT NOT NULL)", TABLE_FOTOS));
    }

    //Elimina la base de datos y la vuelve a crear cuando se cambia la version. No se utiliza mucho.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //El error no da problemas
        db.execSQL("DROP TABLE" + TABLE_FOTOS);
        onCreate(db);
    }
}

