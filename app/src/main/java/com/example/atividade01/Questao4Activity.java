package com.example.atividade01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questao4Activity extends AppCompatActivity {
    Button buttonResponderQ4;
    RadioButton radioButtonfifa, radioButtonmine, radioButtonhalo, radioButtonterraria;
    TextView textviewNome;
    String nome = "";
    int qtsErros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao4);

        buttonResponderQ4 = findViewById(R.id.buttonResponderQ4);
        radioButtonfifa = findViewById(R.id.radioButtonfifa);
        radioButtonmine = findViewById(R.id.radioButtonmine);
        radioButtonhalo = findViewById(R.id.radioButtonhalo);
        radioButtonterraria = findViewById(R.id.radioButtonterraria);
        textviewNome = findViewById(R.id.textviewNome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nome = bundle.getString("nome");
        qtsErros = bundle.getInt("qtdErros");
        if (!nome.equals("")) {
            textviewNome.setText(nome);
        }
            buttonResponderQ4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (radioButtonmine.isChecked()) {
                        AlertDialog.Builder msgCerto = new AlertDialog.Builder(Questao4Activity.this);
                        msgCerto.setTitle("VOCÊ ACERTOU!");
                        msgCerto.setNeutralButton("OK", null);
                        msgCerto.setMessage("RESPOSTA CORRETA!").show();
                        if (qtsErros == 0) {
                            msgCerto.setMessage(nome + " Você acertou todas, PARABÉNS!");
                            msgCerto.show();
                        }
                        else if (qtsErros == 1) {
                            msgCerto.setMessage(nome + " Você errou " + qtsErros + " vez.");
                            msgCerto.show();
                        }
                        else if (qtsErros >= 2) {
                            msgCerto.setMessage(nome + " Você errou " + qtsErros + " vezes.");
                            msgCerto.show();
                        }
                    } else {
                        Toast.makeText(Questao4Activity.this, "Errado", Toast.LENGTH_SHORT).show();
                        qtsErros++;
                    }
                }
            });
        }
    }