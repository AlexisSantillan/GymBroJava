package com.example.gymbrojava;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class AgregarClasesActivity extends AppCompatActivity {

    private EditText editTextDiaClase, editTextHorarioClase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_clases);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextDiaClase = findViewById(R.id.editTextDiaClase);
        editTextHorarioClase = findViewById(R.id.editTextHorarioClase);

        // Abrir DatePickerDialog para el día de la clase
        editTextDiaClase.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    AgregarClasesActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        editTextDiaClase.setText(selectedDate);
                    }, year, month, day);
            datePickerDialog.show();
        });

        // Abrir TimePickerDialog para el horario de la clase
        editTextHorarioClase.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    AgregarClasesActivity.this,
                    (view, selectedHour, selectedMinute) -> {
                        String selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
                        editTextHorarioClase.setText(selectedTime);
                    }, hour, minute, true);
            timePickerDialog.show();
        });
    }

    // Método para abrir la actividad de PantallaInicio
    public void openPantallaInicio(View view) {
        Intent intent = new Intent(this, PantallaInicioActivity.class);
        startActivity(intent);
        finish();
    }
}
