package com.android.terceraappbbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.BBDD_OpenHelper;

public class Registro extends AppCompatActivity {

    Button btnRegistro;
    EditText edtNomUsu, edtDirUsu,edtPassUsu,edtMailUsu;
    BBDD_OpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        dbHelper= new BBDD_OpenHelper(Registro.this);

        btnRegistro=findViewById(R.id.btnRegistrar);
        edtNomUsu=findViewById(R.id.edtNombre);
        edtDirUsu=findViewById(R.id.edtDireccion);
        edtMailUsu=findViewById(R.id.edtMail);
        edtPassUsu=findViewById(R.id.edtPasswordUsu);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = dbHelper.insertarRegistro(edtNomUsu.getText().toString(), edtDirUsu.getText().toString(), edtMailUsu.getText().toString(), edtPassUsu.getText().toString());

                if (b){
                    Toast.makeText(getApplicationContext(),"Registro insertado",Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(),"Registro no insertado",Toast.LENGTH_SHORT).show();
                }

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });


    }
}