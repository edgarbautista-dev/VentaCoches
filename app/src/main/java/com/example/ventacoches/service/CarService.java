package com.example.ventacoches.service;

import com.example.ventacoches.model.CarModel;

public class CarService {

    public CarModel[] getCarModel(){
        return carModel;
    }
    CarModel[] carModel = new CarModel[]{
            new CarModel("-","-",0,"-","-","-"),
            new CarModel("Mazda","3",454000,"negro","2022","m3s"),
            new CarModel("Toyota","Rav4",350000,"roja","2022","rav4"),
            new CarModel("Audi","A7",400000,"blanco", "2022","au"),
            new CarModel("Toyota","Corolla",350000,"roja","2022","corolla"),
            new CarModel("volvo","XC60",900000,"blanco","2022","volvo"),
            new CarModel("volvo","C640",900000,"plata","2022","c640")

    };
}
