package com.FundacionNeuron.AppNeuronV4;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;


public class UsuarioCita extends AppCompatActivity {


    EditText etCita, etHora;
    DatePicker viewDate;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_cita);


        etCita = findViewById(R.id.etCita);
        etHora = findViewById(R.id.etHora);

    }


    public void abrirCalendario(View view){

        Calendar calendario = Calendar.getInstance();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(UsuarioCita.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String fecha = dayOfMonth+ "/" + month +"/"+ year;

                db = FirebaseFirestore.getInstance();

                //Datos que se guarda  en registro de la base de datos
                 mDatabase = FirebaseDatabase.getInstance().getReference();

                Map<String, Object> dias = new HashMap<>();
                dias.put("Dia", fecha);

                db.collection("user").document(UsuarioInicioRegistro.idDocumento)
                        .update(dias)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(UsuarioCita.this, "Se a añadidoc correctamente", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(UsuarioCita.this, "nO se a podido añadir", Toast.LENGTH_SHORT).show();
                            }
                        });

                etCita.setText(fecha);

            }
        }, anio, mes, dia);

        datePickerDialog.show();


    }



    public void AbrirHora (View view){

        Calendar calendario = Calendar.getInstance();

        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int min = calendario.get(Calendar.MINUTE);


        TimePickerDialog time = new TimePickerDialog(UsuarioCita.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

                String hora =hourOfDay + ":" + minute;
                db = FirebaseFirestore.getInstance();
                //Datos qwue se guarda  en registro de la base de datos
                mDatabase = FirebaseDatabase.getInstance().getReference();

                Map<String, Object> Lashora = new HashMap<>();
                Lashora.put("Hora", hora);

                db.collection("user").document(UsuarioInicioRegistro.idDocumento)
                        .update(Lashora)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(UsuarioCita.this, "La hora s eha guardado correctamente", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(UsuarioCita.this, "No se a podido guardar la hora", Toast.LENGTH_SHORT).show();
                            }
                        });
                etHora.setText(hora);



            }
        }, hora, min, false);

        time.show();

    }

}