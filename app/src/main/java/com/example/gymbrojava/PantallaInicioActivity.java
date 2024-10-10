package com.example.gymbrojava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PantallaInicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_inicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Método para abrir la actividad de Agregar Clases
    public void openAgregarClasesActivity(View view) {
        Intent intent = new Intent(this, AgregarClasesActivity.class);
        startActivity(intent);
        finish();
    }

    // Método para abrir la actividad de Agregar Rutina
    public void openAgregarRutinaActivity(View view) {
        Intent intent = new Intent(this, AgregarRutinaActivity.class);
        startActivity(intent);
        finish();
    }

    // Método para abrir la actividad de Agregar Dieta
    public void openAgregarDietaActivity(View view) {
        Intent intent = new Intent(this, AgregarDietaActivity.class);
        startActivity(intent);
        finish();
    }

    // Método para abrir la actividad de Agregar Ususarios
    public void openAgregarUsuariosActivity(View view) {
        Intent intent = new Intent(this, AgregarUsuarioActivity.class);
        startActivity(intent);
        finish();
    }

}
