package com.FundacionNeuron.AppNeuronV4;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class Cita extends AppCompatActivity {


    EditText etCita, etHora;
    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);


       etCita = findViewById(R.id.etCita);
       etHora = findViewById(R.id.etHora);

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

                db = FirebaseFirestore.getInstance();

                Map<String, Object> dias = new HashMap<>();
                dias.put("Dia", fecha);

               String id =  db.collection("user").getId();

                Toast.makeText(Cita.this, id, Toast.LENGTH_SHORT).show();

                etCita.setText(fecha);

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

                String dia =hourOfDay + ":" + minute;
                etHora.setText(dia);

            }
        }, hora, min, false);
        time.show();

    }

}