package com.FundacionNeuron.AppNeuronV4;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Cita extends AppCompatActivity {

    Spinner spinner;
    TextView tv;
    Button btCita, btHora;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);


    btCita = findViewById(R.id.btCita);
    spinner = findViewById(R.id.spinner);
    btHora = findViewById(R.id.btHora);



    String [] especialistas = {"Elija una opción","PSICOLOGÍA", "TERAPIA OCUPACIONAL", "LOGOPEDIA", "NUTRICION", "TERAPIA ASISTIDA PERROS", "NEUROCIO"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, especialistas);
        spinner.setAdapter(adapter);



    }

    public void abrirCalendario(View view){

        Calendar calendario = Calendar.getInstance();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(Cita.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String fecha = dayOfMonth+ "/" + month +"/"+ year;

                btCita.setText(fecha);

            }
        }, anio, mes, dia);


        datePickerDialog.show();


    }

    public void AbrirHora (View view){

        Calendar calendario = Calendar.getInstance();

        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int min = calendario.get(Calendar.MINUTE);


        TimePickerDialog time = new TimePickerDialog(Cita.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

                btHora.setText(hourOfDay + ":" + minute);

            }
        }, hora, min, false);
        time.show();

    }














}