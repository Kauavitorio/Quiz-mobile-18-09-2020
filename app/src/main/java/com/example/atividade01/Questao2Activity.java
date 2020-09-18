package com.example.atividade01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questao2Activity extends AppCompatActivity {
    Button buttonResponderQ2;
    TextView textviewNome;
    RadioButton radioButtonr6, radioButtonpayday, radioButtonresidente, radioButtongta;
    String nome;
    int qtsErros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao2);

        buttonResponderQ2 = findViewById(R.id.buttonResponderQ2);
        textviewNome = findViewById(R.id.textviewNome);
        radioButtonr6 = findViewById(R.id.radioButtonr6);
        radioButtonpayday = findViewById(R.id.radioButtonpayday);
        radioButtonresidente = findViewById(R.id.radioButtonresidente);
        radioButtongta = findViewById(R.id.radioButtongta);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtsErros = bundle.getInt("qtdErros");
        if (!nome.equals(""))
            textviewNome.setText(nome);

        buttonResponderQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButtonresidente.isChecked()) {
                    Toast.makeText(Questao2Activity.this, "Certo", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Questao2Activity.this, Questao3Activity.class);
                    intent.putExtra("nome",nome);
                    intent.putExtra("qtdErros",qtsErros);
                    startActivity(intent);
                } else {
                    Toast.makeText(Questao2Activity.this, "Errado", Toast.LENGTH_SHORT).show();
                    qtsErros++;
                }
            }

        });
    }
}