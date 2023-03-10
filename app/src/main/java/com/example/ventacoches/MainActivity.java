package com.example.ventacoches;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Spinner cmbMarca;
    private Spinner cmbNombres;
    private TextView LblMensaje;
    private Spinner cmbAño;
    private Spinner cmbColor;
    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LblMensaje=(TextView) findViewById(R.id.lblMensaje);
        btnBuscar=(Button) findViewById(R.id.button);
        final String[] marca = new String[]{"-","Audi","BMW","Mercedes","Volkswagen","Volvo","Ford","Chevrolet","Toyota","Nissan","Hyundai","Kia","Mazda","Suzuki","Honda","Mitsubishi","Subaru","Daihatsu","Lexus","Infiniti","Jaguar","Land Rover","Porsche","Ferrari","Lamborghini","Aston Martin","Bentley","Maserati","Alfa Romeo","Fiat","Peugeot","Citroen","Renault","Dacia","Opel","Seat","Skoda","Mini","Smart","Tesla","Mclaren","Bugatti","Pagani","Rolls Royce","Acura","Buick","Cadillac","Chrysler","Dodge","GMC","Jeep","Lincoln","Pontiac","Ram","Saab","Saturn","Scion","Abarth","Aixam","Alpina","Asia Motors","Asia Towner","Aston Martin","Audi","Austin","Bentley","BMW","Brilliance","Bugatti","Buick","Cadillac","Changan","Chery","Chevrolet","Chrysler","Citroen","Dacia","Daewoo","Daihatsu","Dodge","Donkervoort","DS","Ferrari","Fiat","Fisker","Ford","GMC","Great Wall","Hafei","Honda","Hummer","Hyundai","Infiniti","Isuzu","Iveco","Jaguar","Jeep","Kia","Lada","Lamborghini","Lancia","Land Rover","Landwind","Lexus","Lifan","Lincoln","Lotus","Mahindra","Maserati","Maybach","Mazda","McLaren","Mercedes","Mercury","MG","Mini","Mitsubishi","Morgan","Nissan","Oldsmobile","Opel","Peugeot","Plymouth","Pontiac","Porsche","Proton","Renault","Rolls Royce","Rover","Saab","Seat","Shuanghuan","Skoda","Smart","Ssangyong","Subaru","Suzuki","Tata","Tesla","Toyota","Volkswagen","Volvo","Wartburg","Wiesmann","Zotye","ZX"};
        final String[] nombre = new String[]{"-","A1","A3","A4","A5","A6","A7","A8","Q3","Q5","Q7","R8","RS3","RS4","RS5","RS6","RS7","S3","S4","S5","S6","S7","S8","SQ5","TT","TT RS","TTS","A1","A3","A4","A5","A6","A7","A8","Q3","Q5","Q7","R8","RS3","RS4","RS5","RS6","RS7","S3","S4","S5","S6","S7","S8","SQ5","TT","TT RS","TTS","A1","A3","A4","A5","A6","A7","A8","Q3","Q5","Q7","R8","RS3","RS4","RS5","RS6","RS7","S3","S4","S5","S6","S7","S8","SQ5","TT","TT RS","TTS","A1","A3","A4","A5","A6","A7","A8","Q3","Q5","Q7","R8","RS3","RS4","RS5","RS6","RS7","S3","S4","S5","S6","S7","S8","SQ5","TT","TT RS","TTS","A1","A3","A4","A5","A6","A7","A8","Q3","Q5","Q7","R8","RS3","RS4","RS5","RS6","RS7","S3","S4","S5","S6","S7","S8","SQ5","TT","TT RS","TTS","A1","A3","A4","A5","A6","A7","A8","Q3","Q5","Q7","R8","RS3","RS4","RS5","RS6","RS7","S3","S4","S5","S6","S7","S8","SQ5","TT","TT RS","TTS","A1","A3","A4","A5","A6","A7","A8","Q3","Q5","Q7","R8"};
        final String[] modelo= new String[]{"-","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};
        final String[] color= new String[]{"-","Rojo","Azul","Verde","Amarillo","Blanco","Negro","Gris","Morado","Naranja","Rosa","Plateado","Cafe","Dorado","Oro","Plata","Cobre","Bronce","Cian","Magenta","Carmesi","Turquesa","Lila","Violeta","Marron","Beige","Rosa","Lima","Lavanda","Coral","Canela"};
        cmbMarca =(Spinner) findViewById(R.id.cmbAutos);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, marca);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbMarca.setAdapter(adapter);
        cmbMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Has seleccionado: " + marca[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                LblMensaje.setText("");
            }
        });
        cmbNombres=(Spinner) findViewById(R.id.cmbNombre);
        ArrayAdapter<String> adapterNombre = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nombre);
        adapterNombre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbNombres.setAdapter(adapterNombre);
        cmbNombres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Nombre: " + nombre[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                LblMensaje.setText("");
            }
        });
        cmbAño=(Spinner) findViewById(R.id.cmbAño);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modelo);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbAño.setAdapter(adapter1);
        cmbAño.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Año: " + modelo[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                LblMensaje.setText("");
            }
        });
        cmbColor=(Spinner) findViewById(R.id.cmbColor);
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
        //cambiar de layout
        btnBuscar.setOnClickListener(v -> {
            String marcaSeleccionada = cmbMarca.getSelectedItem().toString();
            String nombreSeleccionado = cmbNombres.getSelectedItem().toString();
            String añoSeleccionado = cmbAño.getSelectedItem().toString();
            String colorSeleccionado = cmbColor.getSelectedItem().toString();
            if (marcaSeleccionada.equals("-")){
                LblMensaje.setText("Selecciona un marca");
            } else if (nombreSeleccionado.equals("-")) {
                LblMensaje.setText("Selecciona un nombre");
            } else if (añoSeleccionado.equals("-")) {
                LblMensaje.setText("Selecciona un año");
            } else if (colorSeleccionado.equals("-")) {
                LblMensaje.setText("Selecciona un color");
            } else{
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