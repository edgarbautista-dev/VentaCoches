package com.example.ventacoches;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView LblMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        LblMensaje = (TextView) findViewById(R.id.textView2);
        Bundle bundle = getIntent().getExtras();
        String auto = bundle.getString("auto");
        String año = bundle.getString("año");
        String color = bundle.getString("color");
        LblMensaje.setText("Has seleccionado: " + auto + " " + año + " " + color);
    }
}