package com.example.ventacoches;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.ventacoches.dao.AutoDao;
import com.example.ventacoches.model.Auto;
import com.example.ventacoches.repository.AutoDatabase;

public class SaveAutoActivity extends AppCompatActivity {

    private TextView labelMarca;
    private TextView labelModelo;
    private TextView labelAnio;
    private TextView labelColor;
    private EditText cmbAnio;
    private EditText cmbColor;

    private EditText cmbModelo;
    private EditText cmbMarca;
    private Button guardar;
    private Button cancelar;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_auto);
        labelMarca = findViewById(R.id.labelMarca);
        labelModelo = findViewById(R.id.labelModelo);
        labelAnio = findViewById(R.id.labelAnio);
        labelColor = findViewById(R.id.labelColor);

        cmbMarca = findViewById(R.id.cmbMarca);
        cmbAnio = findViewById(R.id.cmbAnio);
        cmbColor = findViewById(R.id.cmbColor);
        cmbModelo =  findViewById(R.id.cmbModelo);

        guardar = findViewById(R.id.guardar);
        cancelar = findViewById(R.id.cancelar);

        guardar.setOnClickListener(view -> {
            Auto auto = new Auto();
            auto.setMarca(cmbMarca.getText().toString());
            auto.setModelo(cmbModelo.getText().toString());
            auto.setModelo(cmbColor.getText().toString());
            auto.setAnio(Integer.parseInt(cmbAnio.getText().toString()));
            auto.setUid(999);
            // AutoDatabase db = Room.databaseBuilder(getApplicationContext(),
                    //AutoDatabase.class, "auto_db").build();

            AutoDatabase db = AutoDatabase.getInstance(getApplicationContext());
            AutoDao autoDao =  db.autoDao();

            autoDao.insertAll(auto);

        });
    }
}
