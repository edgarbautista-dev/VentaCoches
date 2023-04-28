package com.example.ventacoches;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.*;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.ventacoches.model.CarModel;
import com.example.ventacoches.service.CarService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private Spinner cmbMarca;
    private Spinner cmbNombres;
    private TextView LblMensaje;
    private TextView LblMensajeDos;
    private TextView LblMensajeTres;
    private TextView LblMensajeCuatro;
    private Spinner cmbAño;
    private Spinner cmbColor;
    private Button btnBuscar;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LblMensaje=(TextView) findViewById(R.id.lblMensaje);
        LblMensajeDos=(TextView) findViewById(R.id.labelNombre);
        LblMensajeTres=(TextView) findViewById(R.id.labelAño);
        LblMensajeCuatro=(TextView) findViewById(R.id.labelColor);
        btnBuscar=(Button) findViewById(R.id.button);
        cmbMarca =(Spinner) findViewById(R.id.cmbAutos);
        cmbNombres=(Spinner) findViewById(R.id.cmbNombre);
        cmbAño=(Spinner) findViewById(R.id.cmbAño);
        cmbColor=(Spinner) findViewById(R.id.cmbColor);

        CarService carService = new CarService();
        CarModel[] carModel = carService.getCarModel();
        String[] marca = Arrays.stream(carModel).map(CarModel::getNombre).distinct().collect(Collectors.toList()).toArray(new String[0]);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, marca);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbMarca.setAdapter(adapter);
        cmbMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Has seleccionado: " + marca[position]);
                cmbMarca.setSelection(position);
                System.out.println(cmbMarca.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                LblMensaje.setText("");
            }
        });

        LblMensajeDos.setVisibility(View.VISIBLE);
        cmbNombres.setVisibility(View.VISIBLE);
        String[] model = Arrays.stream(carModel).map(CarModel::getModelo).distinct().collect(Collectors.toList()).toArray(new String[0]);
        ArrayAdapter<String> adapterNombre = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, model);
        adapterNombre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbNombres.setAdapter(adapterNombre);
        cmbNombres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Modelo: " + model[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                LblMensaje.setText("");
            }
        });

        LblMensajeTres.setVisibility(View.VISIBLE);
        cmbAño.setVisibility(View.VISIBLE);

        String[] año = Arrays.stream(carModel).map(CarModel::getAño).distinct().collect(Collectors.toList()).toArray(new String[0]);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, año);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbAño.setAdapter(adapter1);
        cmbAño.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Año: " + año[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                LblMensaje.setText("");
            }
        });


        LblMensajeCuatro.setVisibility(View.VISIBLE);
        cmbColor.setVisibility(View.VISIBLE);
        String[] color = Arrays.stream(carModel).map(CarModel::getColor).distinct().collect(Collectors.toList()).toArray(new String[0]);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, color);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbColor.setAdapter(adapter2);
        cmbColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Color: " + color[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                LblMensaje.setText("");
            }
        });


        btnBuscar.setVisibility(View.VISIBLE);
        //cambiar de layout
        btnBuscar.setOnClickListener(v -> {
            String marcaSeleccionada = cmbMarca.getSelectedItem().toString();
            String nombreSeleccionado = cmbNombres.getSelectedItem().toString();
            String añoSeleccionado = cmbAño.getSelectedItem().toString();
            String colorSeleccionado = cmbColor.getSelectedItem().toString();
            if (marcaSeleccionada.equals("-")){
                LblMensaje.setText("Selecciona un marca");
            } else if (nombreSeleccionado.equals("-")) {
                LblMensaje.setText("Selecciona un modelo");
            } else if (añoSeleccionado.equals("-")) {
                LblMensaje.setText("Selecciona un año");
            } else if (colorSeleccionado.equals("-")) {
                LblMensaje.setText("Selecciona un color");
            } else {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("marca", marcaSeleccionada);
                intent.putExtra("nombre", nombreSeleccionado);
                intent.putExtra("año", añoSeleccionado);
                intent.putExtra("color", colorSeleccionado);
                startActivity(intent);
            }
        });
    }
}
