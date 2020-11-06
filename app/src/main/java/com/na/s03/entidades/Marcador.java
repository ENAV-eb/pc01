package com.na.s03.entidades;

public class Marcador {

    private int id;
    private String nombre;
    private String marca;
    private String modelo;
    private String color;
    private String longitud;

    public Marcador(String nombre, String marca, String modelo, String color, String longitud) {

        if(marca.contentEquals("Selecciona una Marca ...")) marca="";

        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.longitud = longitud;
    }

    public Marcador(int id, String nombre, String marca, String modelo, String color, String longitud) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.longitud = longitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
