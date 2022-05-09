package com.FundacionNeuron.AppNeuronV4;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    EditText etUsuario, etContraseña;
    TextView tvMensaje;
    Button btIniciar,bRegistroNuevoUser;
    TextView neuron, btRegistrar;
    ImageView ibFace, ibInsta, IbTwit;
    private FirebaseAuth mAuth;
    //id pruebalogin-9578d fire base

    int REQUEST_CODE = 200;

    // Hola carlos


    //probando comentario para git commit mas push

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);
        etContraseña = findViewById(R.id.etContraseña);
        tvMensaje = findViewById(R.id.tvMensaje);
        btIniciar = findViewById(R.id.btIniciar);
        bRegistroNuevoUser = findViewById(R.id.bRegistroNuevoUser);
        btRegistrar=findViewById(R.id.btRegistrar);
        neuron = findViewById(R.id.neuron);

        neuron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://fundacionneuron.org/";

                Uri link = Uri.parse(url);
                Intent i = new Intent(Intent.ACTION_VIEW, link);
                startActivity(i);
            }
        });
        bRegistroNuevoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,UsuarioPreguntasRegistro.class);
                startActivity(i);
            }
        });

    }

    public void Iniciar(View view) {

        String usuario = etUsuario.getText().toString();
        String contraseña = etContraseña.getText().toString();
        mAuth = FirebaseAuth.getInstance();

        if (usuario.isEmpty() && contraseña.isEmpty()) {
            tvMensaje.setText("Rellene todos los campos");

        } else if (usuario.isEmpty()) {
            tvMensaje.setText("El campo Email esta vacio");
        } else if (contraseña.isEmpty()) {
            tvMensaje.setText("El campo contraseña esta vacio");
        } else {
            mAuth.signInWithEmailAndPassword(usuario, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                        Intent home = new Intent(MainActivity.this, UsuarioHome.class);
                        startActivity(home);
                    } else {
                        tvMensaje.setText("No se pudo inicar sesion, verifique correo y contraseña");

                    }


                }
            });

        }


    }

    /* @Override
     protected void onStart() {
         FirebaseUser user = mAuth.getCurrentUser();

         if(user!=null){
             Intent home = new Intent(MainActivity.this, HomeUsuario.class);
             startActivity(home);
         }

         super.onStart();
     }

     */
    public void Registrar(View view) {

        Intent registrar = new Intent(this, UsuarioInicioRegistro.class);
        startActivity(registrar);

    }


}