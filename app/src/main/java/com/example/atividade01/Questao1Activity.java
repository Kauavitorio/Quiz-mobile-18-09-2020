package com.example.atividade01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questao1Activity extends AppCompatActivity {
    Button buttonResponder;
    TextView textviewNome;
    RadioButton radioButton2anos, radioButton3meses, radioButton5anos, radioButton10anos;
    int qtsErros = 0;
    String nome="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao1);

        buttonResponder = findViewById(R.id.buttonResponder);
        radioButton2anos = findViewById(R.id.radioButton2anos);
        radioButton3meses = findViewById(R.id.radioButton3meses);
        radioButton5anos = findViewById(R.id.radioButton5anos);
        radioButton10anos = findViewById(R.id.radioButton10anos);
        textviewNome = findViewById(R.id.textviewNome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        if (!nome.equals(""))
            textviewNome.setText(nome);

        buttonResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton5anos.isChecked()) {
                    Toast.makeText(Questao1Activity.this, "Certo", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Questao1Activity.this, Questao2Activity.class);
                    intent.putExtra("nome",nome);
                    intent.putExtra("qtdErros",qtsErros);
                    startActivity(intent);
                } else {
                    qtsErros++;
                    Toast.makeText(Questao1Activity.this, "Errado", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}