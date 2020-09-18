package com.example.atividade01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button botaoavancar;
    EditText edittextNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaoavancar = findViewById(R.id.botaoavancar);
        edittextNome = findViewById(R.id.edittextNome);


        botaoavancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Questao1Activity.class);
                intent.putExtra("nome", edittextNome.getText().toString());
                startActivity(intent);
            }
        });
    }
}