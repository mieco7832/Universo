package com.universo.models;

public class Galaxia {

    private int id_galaxia;
    private String nombre;
    private String img;
    private String descripcion;

    public Galaxia() {
        super();
    }

    public int getId_galaxia() {
        return id_galaxia;
    }

    public void setId_galaxia(int id_galaxia) {
        this.id_galaxia = id_galaxia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id_galaxia;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Galaxia other = (Galaxia) obj;
        if (this.id_galaxia != other.id_galaxia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Galaxia{" + "id_galaxia=" + id_galaxia + ", nombre=" + nombre + '}';
    }

}
