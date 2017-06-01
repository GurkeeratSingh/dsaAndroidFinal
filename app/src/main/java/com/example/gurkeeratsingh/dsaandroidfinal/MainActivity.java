package com.example.gurkeeratsingh.dsaandroidfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button BotonSeguidores = (Button) findViewById(R.id.button);
        Button BotonSeguidos = (Button) findViewById(R.id.button2);




        BotonSeguidores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText) findViewById(R.id.name);
                if(name.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Escribe el user objetivo de la busqueda", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent (getApplicationContext(),Main2Activity.class);
                    intent.putExtra("usuario", name.getText().toString());
                    Toast.makeText(MainActivity.this, "Buscando a: "+name.getText().toString(), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }

            }
        });

        BotonSeguidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText) findViewById(R.id.name);
                if(name.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Escribe el user objetivo de la busqueda", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent2 = new Intent (getApplicationContext(),Main3Activity.class);
                    intent2.putExtra("usuario", name.getText().toString());
                    Toast.makeText(MainActivity.this, "Buscando a: "+name.getText().toString(), Toast.LENGTH_SHORT).show();
                    startActivity(intent2);
                }

            }
        });

    }
}

