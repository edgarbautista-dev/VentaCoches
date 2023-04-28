package com.example.ventacoches.model;

public class CarModel {
    private String nombre;
    private String modelo;
    private double precio;
    private String color;
    private String año;
    private String imagen;

    public CarModel() {
        super();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String marca) {
        this.modelo = marca;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getAño() {
        return año;
    }
    public void setAño(String año) {
        this.año = año;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public CarModel(String nombre, String modelo, double precio, String color, String año, String imagen) {
        super();
        this.nombre = nombre;
        this.modelo = modelo;
        this.precio = precio;
        this.color = color;
        this.año = año;
        this.imagen = imagen;
    }

}
