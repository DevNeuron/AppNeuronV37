package com.FundacionNeuron.AppNeuronV4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UsuarioPreguntasRegistro extends AppCompatActivity {
    Button bContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_preguntas_registro);
        bContinuar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i= startActivity(UsuarioPreguntasRegistro.this,UsuarioFinalRegistro.class);
                startActivity(i);
            }
        });

    }


}