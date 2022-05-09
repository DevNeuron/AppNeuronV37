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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class UsuarioInicioRegistro extends AppCompatActivity {

    EditText etNombre, etApellidos, etCorreo, etMiContraseña, etMiContraseña2, etTelefono;
    TextView mensajeError;
    public static String idDocumento;

    // FireBase
    FirebaseAuth mAuth;

    //Base de datos
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_registrar);

        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etCorreo = findViewById(R.id.etCorreo);
        etMiContraseña = findViewById(R.id.etMiContraseña);
        etMiContraseña2 = findViewById(R.id.etMiContraseña2);
        mensajeError = findViewById(R.id.mensajeError);
        etTelefono= findViewById(R.id.etTelefono);

    }

    public void Registrar(View view){

        // Base de datos
         db = FirebaseFirestore.getInstance();
         //Autentificacion con correo y contraseña
         mAuth = FirebaseAuth.getInstance();

        String nombre = etNombre.getText().toString();
        String apellidos = etApellidos.getText().toString();
        String correo = etCorreo.getText().toString();
        String contraseña = etMiContraseña.getText().toString();
        String contraseña2 = etMiContraseña2.getText().toString();

        //Mapa para guardar una coleccion de datos en la base de datos
        Map<String, Object> user = new HashMap<>();
        user.put("Nombre", nombre);
        user.put("Apellidos", apellidos);
        user.put("Correo", correo);
        user.put("Contraseña", contraseña);
        user.put("ContraseñaDos", contraseña2);

        db.collection("user")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.println(documentReference.getId());
                        idDocumento = documentReference.getId();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UsuarioInicioRegistro.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

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
                        Intent login = new Intent(UsuarioInicioRegistro.this, MainActivity.class );
                        startActivity(login);
                        Toast.makeText(UsuarioInicioRegistro.this, "Se ha registado correctamente", Toast.LENGTH_SHORT).show();
                    }else{
                        mensajeError.setText("");
                        Toast.makeText(UsuarioInicioRegistro.this, "No se puede registrar, verifique que todo esta correctamente", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


    }






}