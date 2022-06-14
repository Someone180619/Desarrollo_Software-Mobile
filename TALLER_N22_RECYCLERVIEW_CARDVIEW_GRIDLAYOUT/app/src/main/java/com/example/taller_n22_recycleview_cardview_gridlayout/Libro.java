package com.example.taller_n22_recycleview_cardview_gridlayout;

public class Libro {

    private String titulo, categoria, descripcion;
    private int miniatura;

    public Libro(){

    }

    public Libro(String titulo, String categoria, String descripcion, int miniatura){
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.miniatura = miniatura;
    }

    public String getTitulo(){ return titulo;}

    public String getCategoria(){ return categoria;}

    public String getDescripcion(){ return descripcion;}

    public int getMiniatura(){ return miniatura;}

    public void setTitulo(String titulo) { this.titulo = titulo;}

    public void setCategoria(String categoria){this.categoria = categoria;}

    public void setDescripcion(String descripcion){this.descripcion = descripcion;}

    public void setMiniatura(int miniatura){this.miniatura = miniatura;}
}
