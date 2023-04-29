package com.example.ventacoches.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ventacoches.model.Auto;

import java.util.List;

@Dao
public interface AutoDao {

    @Query("SELECT * FROM auto")
    List<Auto> getAll();

    @Query("SELECT * FROM auto WHERE marca LIKE :marca")
    Auto findByMarca(String marca);

    @Query("SELECT * FROM auto WHERE modelo LIKE :modelo")
    Auto findByModelo(String modelo);

    @Query("SELECT * FROM auto WHERE anio LIKE :anio")
    Auto findByAnio(String anio);

    @Query("SELECT * FROM auto WHERE color LIKE :color")
    Auto findByColor(String color);

    @Update
    void updateAutos(Auto... autos);

    @Insert
    void insertAll(Auto... autos);

    @Delete
    void delete(Auto auto);
}
