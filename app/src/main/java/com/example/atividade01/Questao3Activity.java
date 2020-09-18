package com.example.atividade01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questao3Activity extends AppCompatActivity {
    Button buttonResponderQ3;
    RadioButton radioButtonfallguys,radioButtonpes,radioButtonfifa,radioButtonmine;
    TextView textviewNome;
    String nome="";
    int qtsErros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao3);

        buttonResponderQ3 = findViewById(R.id.buttonResponderQ3);
        radioButtonfallguys = findViewById(R.id.radioButtonfallguys);
        radioButtonpes = findViewById(R.id.radioButtonpes);
        radioButtonfifa = findViewById(R.id.radioButtonfifa);
        radioButtonmine = findViewById(R.id.radioButtonmine);
        textviewNome = findViewById(R.id.textviewNome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtsErros = bundle.getInt("qtdErros");
        if (!nome.equals(""))
            textviewNome.setText(nome);

        buttonResponderQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButtonfifa.isChecked()) {
                    Toast.makeText(Questao3Activity.this, "Certo", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Questao3Activity.this, Questao4Activity.class);
                    intent.putExtra("nome",nome);
                    intent.putExtra("qtdErros",qtsErros);
                    startActivity(intent);
                } else {
                    Toast.makeText(Questao3Activity.this, "Errado", Toast.LENGTH_SHORT).show();
                    qtsErros++;
                }
            }
        });
    }
}