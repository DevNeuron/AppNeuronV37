package com.FundacionNeuron.AppNeuronV4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UsuarioConsultaCita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_consulta_cita);


    }

    public void bModificarCita(View view) {
        Intent i = new Intent(UsuarioConsultaCita.this, UsuarioModificarCita.class);
        startActivity(i);
        // trabajando en el calendario, posterior integracion
        Toast.makeText(UsuarioConsultaCita.this, "trabajando en el calendario, posterior integracion", Toast.LENGTH_SHORT).show();
    }


}