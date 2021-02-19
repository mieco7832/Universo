package com.universo.entity;

public class Espacio {

    private int id_planeta;
    private String nombre_planeta;
    private String masa;
    private int numero;
    private String descripcion;
    private int galaxia;
    private String nombre;
    private String url;

    public Espacio(int id_planeta, String nombre_planeta, String masa, int numero, String descripcion, String url) {
        this.id_planeta = id_planeta;
        this.nombre_planeta = nombre_planeta;
        this.masa = masa;
        this.numero = numero;
        this.descripcion = descripcion;
        this.url = url;
    }

    public Espacio(int galaxia, String nombre, String descripcion, String url) {
        this.galaxia = galaxia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }

    public int getId_planeta() {
        return id_planeta;
    }

    public void setId_planeta(int id_planeta) {
        this.id_planeta = id_planeta;
    }

    public String getNombre_planeta() {
        return nombre_planeta;
    }

    public void setNombre_planeta(String nombre_planeta) {
        this.nombre_planeta = nombre_planeta;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getGalaxia() {
        return galaxia;
    }

    public void setGalaxia(int galaxia) {
        this.galaxia = galaxia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
