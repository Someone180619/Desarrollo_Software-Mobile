package com.example.semestral;

/*
 * Clase que define los atributos de la entidad Fotos
 * */
public class Fotos {
    private int ID;
    private String RutaImagen;
    private String FechaCreacion;
    private String TituloImagen;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRutaImagen() {
        return RutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        RutaImagen = rutaImagen;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getTituloImagen() {
        return TituloImagen;
    }

    public void setTituloImagen(String tituloImagen) {
        TituloImagen = tituloImagen;
    }
}

