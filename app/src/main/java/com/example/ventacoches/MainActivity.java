package com.example.ventacoches;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    private Spinner cmbAutos;
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
        final String[] autos= new String[]{"-","Audi","BMW","Mercedes","Volkswagen","Volvo","Ford","Chevrolet","Toyota","Nissan","Hyundai","Kia","Mazda","Suzuki","Honda","Mitsubishi","Subaru","Daihatsu","Lexus","Infiniti","Jaguar","Land Rover","Porsche","Ferrari","Lamborghini","Aston Martin","Bentley","Maserati","Alfa Romeo","Fiat","Peugeot","Citroen","Renault","Dacia","Opel","Seat","Skoda","Mini","Smart","Tesla","Mclaren","Bugatti","Pagani","Rolls Royce","Acura","Buick","Cadillac","Chrysler","Dodge","GMC","Jeep","Lincoln","Pontiac","Ram","Saab","Saturn","Scion","Abarth","Aixam","Alpina","Asia Motors","Asia Towner","Aston Martin","Audi","Austin","Bentley","BMW","Brilliance","Bugatti","Buick","Cadillac","Changan","Chery","Chevrolet","Chrysler","Citroen","Dacia","Daewoo","Daihatsu","Dodge","Donkervoort","DS","Ferrari","Fiat","Fisker","Ford","GMC","Great Wall","Hafei","Honda","Hummer","Hyundai","Infiniti","Isuzu","Iveco","Jaguar","Jeep","Kia","Lada","Lamborghini","Lancia","Land Rover","Landwind","Lexus","Lifan","Lincoln","Lotus","Mahindra","Maserati","Maybach","Mazda","McLaren","Mercedes","Mercury","MG","Mini","Mitsubishi","Morgan","Nissan","Oldsmobile","Opel","Peugeot","Plymouth","Pontiac","Porsche","Proton","Renault","Rolls Royce","Rover","Saab","Seat","Shuanghuan","Skoda","Smart","Ssangyong","Subaru","Suzuki","Tata","Tesla","Toyota","Volkswagen","Volvo","Wartburg","Wiesmann","Zotye","ZX"};
        final String[] color= new String[]{"-","Rojo","Azul","Verde","Amarillo","Blanco","Negro","Gris","Morado","Naranja","Rosa","Plateado","Cafe","Dorado","Oro","Plata","Cobre","Bronce","Cian","Magenta","Carmesi","Turquesa","Lila","Violeta","Marron","Beige","Rosa","Lima","Lavanda","Coral","Canela"};
        final String[] modelo= new String[]{"-","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};
        cmbAutos=(Spinner) findViewById(R.id.cmbAutos);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, autos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbAutos.setAdapter(adapter);
        cmbAutos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               LblMensaje.setText("Has seleccionado: " + autos[position]);
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
                LblMensaje.setText("Año: " + modelo[position]);
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
                LblMensaje.setText("Color: " + color[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                LblMensaje.setText("");
            }
        });
        //cambiar de layout
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String auto = cmbAutos.getSelectedItem().toString();
                String año = cmbAño.getSelectedItem().toString();
                String color = cmbColor.getSelectedItem().toString();
                if (auto.equals("-") || año.equals("-") || color.equals("-")){
                    LblMensaje.setText("No has seleccionado ningun auto");
                }else{
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("auto", auto);
                    intent.putExtra("año", año);
                    intent.putExtra("color", color);
                    startActivity(intent);
                }
            }
        });

    }
}