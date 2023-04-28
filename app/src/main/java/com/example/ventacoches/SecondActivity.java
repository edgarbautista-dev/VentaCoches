package com.example.ventacoches;

import android.os.Build;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.ventacoches.model.CarModel;
import com.example.ventacoches.service.CarService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SecondActivity extends AppCompatActivity {

    private TextView LblModelo;
    private TextView LblNombre;
    private TextView LblAño;
    private TextView LblColor;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle bundle = getIntent().getExtras();
        LblModelo=(TextView) findViewById(R.id.lblMarca);
        LblNombre=(TextView) findViewById(R.id.lblNombre);
        LblAño=(TextView) findViewById(R.id.lblAño);
        LblColor=(TextView) findViewById(R.id.lblColor);
        LblModelo.setText(bundle.getString("marca"));
        LblNombre.setText(bundle.getString("nombre"));
        LblAño.setText(bundle.getString("año"));
        LblColor.setText(bundle.getString("color"));
        CarService carService = new CarService();
        CarModel[] carModel = carService.getCarModel();
        String[] imagenes = Arrays.stream(carModel).map(CarModel::getImagen).distinct().collect(Collectors.toList()).toArray(new String[0]);
        String imagen= Arrays.stream(carModel).filter(m -> m.getNombre().equals(LblModelo.getText().toString())).map(CarModel :: getImagen).findFirst().get();
        int resID = getResources().getIdentifier(imagen, "mipmap", getPackageName());
        ImageView img = (ImageView) findViewById(R.id.imageCars);
        img.setImageResource(resID);
    }
}