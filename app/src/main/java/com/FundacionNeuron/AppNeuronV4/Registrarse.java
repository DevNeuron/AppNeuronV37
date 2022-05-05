package com.FundacionNeuron.AppNeuronV4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Registrarse extends AppCompatActivity {

    EditText etNombre, etApellidos, etCorreo, etMiContraseña, etMiContraseña2, etTelefono;
    TextView mensajeError;
    // FireBase
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etCorreo = findViewById(R.id.etCorreo);
        etMiContraseña = findViewById(R.id.etMiContraseña);
        etMiContraseña2 = findViewById(R.id.etMiContraseña2);
        mensajeError = findViewById(R.id.mensajeError);
        etTelefono= findViewById(R.id.etTelefono);

    }

    public void Registrar(View view){

        String nombre = etNombre.getText().toString();
        String apellidos = etApellidos.getText().toString();
        String correo = etCorreo.getText().toString();
        String contraseña = etMiContraseña.getText().toString();
        String contraseña2 = etMiContraseña2.getText().toString();

        mAuth = FirebaseAuth.getInstance();

        if(nombre.isEmpty() && apellidos.isEmpty() && correo.isEmpty() && contraseña.isEmpty()){
            mensajeError.setText("Debes rellenar todos los campos");

        }else if(nombre.isEmpty()){
            mensajeError.setText("Debes rellenar todos los campos");

        }else if(apellidos.isEmpty()){
            mensajeError.setText("Debes rellenar todos los campos");

        }else if(correo.isEmpty()){
            mensajeError.setText("Debes rellenar todos los campos");

        }else if(contraseña.isEmpty()){
            mensajeError.setText("Debes rellenar todos los campos");

        }else if(contraseña2.isEmpty()) {
            mensajeError.setText("Debes rellenar todos los campos");

        }else if(etTelefono.getText().toString().length()==0) {
            mensajeError.setText("Debes rellenar todos los campos");

        }else if (!contraseña.equals(contraseña2)){
            mensajeError.setText("Las contraseñas deben de ser iguales");
        }else{
            mAuth.createUserWithEmailAndPassword(correo, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Intent login = new Intent(Registrarse.this, MainActivity.class );
                        startActivity(login);
                        Toast.makeText(Registrarse.this, "Se ha registado correctamente", Toast.LENGTH_SHORT).show();
                    }else{
                        mensajeError.setText("");
                        Toast.makeText(Registrarse.this, "No se puede registrar, verifique que todo esta correctamente", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


    }






}