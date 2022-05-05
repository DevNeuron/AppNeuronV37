package com.FundacionNeuron.AppNeuronV4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ModificarCita extends AppCompatActivity {
Button bModificacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_cita);
        // implementando calendario


    }
    public void Modificacion(View view){

        Toast.makeText(getApplicationContext(), "Modificado", Toast.LENGTH_SHORT).show();
    }
}