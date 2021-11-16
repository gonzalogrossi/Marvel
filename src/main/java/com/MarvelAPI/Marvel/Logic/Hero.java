package com.MarvelAPI.Marvel.Logic;

import java.util.List;

public class Hero {
    private String id,nombre,descripcion;
    private List<String> comics;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getComics() {
        return comics;
    }

    public void setComics(List<String> comics) {
        this.comics = comics;
    }
}
