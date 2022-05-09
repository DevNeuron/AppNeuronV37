package com.FundacionNeuron.AppNeuronV4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class UsuarioHome extends AppCompatActivity {
    Button bCita,bModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_home);

    }


    @Override
    protected void onStart() {


        super.onStart();
    }

    public void PedirCita(View view){
        Intent cita = new Intent(this, UsuarioCita.class);
        startActivity(cita);
    }

    public void ConsultarCita(View view){
        Intent cita = new Intent(this, UsuarioConsultaCita.class);
        startActivity(cita);
    }









}