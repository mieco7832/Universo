package com.universo.models;

import java.util.Objects;

public class Planeta {

    private int id_planeta;
    private String nombre_planeta;
    private String masa;
    private int numero;
    private String img;
    private Galaxia galaxia;
    private String description;

    public Planeta() {
        super();
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Galaxia getGalaxia() {
        return galaxia;
    }

    public void setGalaxia(Galaxia galaxia) {
        this.galaxia = galaxia;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id_planeta);
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
        final Planeta other = (Planeta) obj;
        if (!Objects.equals(this.id_planeta, other.id_planeta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Planeta{" + "id_planeta=" + id_planeta + ", nombre_planeta=" + nombre_planeta + '}';
    }

}
