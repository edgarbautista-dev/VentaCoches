package com.example.ventacoches.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Entity(tableName = "auto")
@Getter
@Setter
public class Auto {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @ColumnInfo(name = "color")
    private String color;

    @ColumnInfo(name = "marca")
    private String marca;

    @ColumnInfo(name = "modelo")
    private String modelo;

    @ColumnInfo(name = "anio")
    private int anio;

    @ColumnInfo(name = "imagen")
    private String imagen;
}
