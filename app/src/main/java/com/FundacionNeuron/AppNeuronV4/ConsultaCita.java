package com.FundacionNeuron.AppNeuronV4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConsultaCita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_cita);


    }

    public void bModificarCita(View view) {
        Intent i = new Intent(ConsultaCita.this, ModificarCita.class);
        startActivity(i);
        // trabajando en el calendario, posterior integracion
        Toast.makeText(ConsultaCita.this, "trabajando en el calendario, posterior integracion", Toast.LENGTH_SHORT).show();
    }


}