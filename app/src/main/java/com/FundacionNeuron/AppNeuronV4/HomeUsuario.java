package com.FundacionNeuron.AppNeuronV4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomeUsuario extends AppCompatActivity {
    Button bCita,bModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_usuario);

    }


    @Override
    protected void onStart() {


        super.onStart();
    }

    public void PedirCita(View view){
        Intent cita = new Intent(this, Cita.class);
        startActivity(cita);
    }

    public void ConsultarCita(View view){
        Intent cita = new Intent(this, ConsultaCita.class);
        startActivity(cita);
    }









}