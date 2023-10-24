package com.example.susimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        private EditText nomeEditText;
        private EditText pesoEditText;
        private EditText alturaEditText;
        private ImageView img;
        private TextView respostaTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            nomeEditText = findViewById(R.id.nome);
            pesoEditText = findViewById(R.id.peso);
            alturaEditText = findViewById(R.id.altura);
            img = findViewById(R.id.imagem);
            respostaTextView = findViewById(R.id.resposta);

            Button calcularButton = findViewById(R.id.calcular);
            calcularButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    calcular();
                }
            });
        }

        private void calcular() {
            String nome = nomeEditText.getText().toString();
            double peso = Double.parseDouble(pesoEditText.getText().toString());
            double altura = Double.parseDouble(alturaEditText.getText().toString());
            double imc = peso / (altura * altura);

            if (nome.isEmpty()) {
                respostaTextView.setTextColor(getResources().getColor(R.color.red));
                respostaTextView.setText("[ERRO] Você não colocou o seu nome!");

            }else if (peso == 0){
                respostaTextView.setText("[ERRO] Você não colocou o seu peso!");
            }else if (altura == 0){
                respostaTextView.setText("[ERRO] Você não colocou a sua altura!");
            }else if (imc < 16) {
                respostaTextView.setText(nome + " Seu imc é " + String.format("%.2f", imc) + " você está no grau magreza III.");
                img.setImageResource(R.drawable.magreza3);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorMagreza3));
            } else if (imc > 16.1 && imc < 16.9) {
                respostaTextView.setText(nome + " Seu imc é " + String.format("%.2f", imc) + " você está no grau magreza II.");
                img.setImageResource(R.drawable.magreza2);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorMagreza2));
            } else if (imc > 17 && imc < 18.4) {
                respostaTextView.setText(nome + " Seu imc é " + String.format("%.2f", imc) + " você está no grau magreza I.");
                img.setImageResource(R.drawable.magreza1);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorMagreza1));
            } else if (imc > 18.5 && imc < 24.9) {
                respostaTextView.setText(nome + " Seu imc é " + String.format("%.2f", imc) + " você está com o peso normal.");
                img.setImageResource(R.drawable.normal);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorNormal));
            } else if (imc > 25 && imc < 29.9) {
                respostaTextView.setText(nome + " Seu imc é " + String.format("%.2f", imc) + " você está com sobrepeso.");
                img.setImageResource(R.drawable.sobrepeso);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorSobrepeso));
            } else if (imc > 30 && imc < 34.9) {
                respostaTextView.setText(nome + " Seu imc é " + String.format("%.2f", imc) + " você está no grau obesidade I.");
                img.setImageResource(R.drawable.obesidade1);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorObesidade1));
            } else if (imc > 35 && imc < 39.9) {
                respostaTextView.setText(nome + " Seu imc é " + String.format("%.2f", imc) + " você está no grau obesidade II.");
                img.setImageResource(R.drawable.obesidade2);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorObesidade2));
            } else if (imc > 40) {
                respostaTextView.setText(nome + " Seu IMC é " + String.format("%.2f", imc) + " você está no grau obesidade III.");
                img.setImageResource(R.drawable.obesidade3);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorObesidade3));
            }
        }
        private void limpar(){
            String nome = "";
            double peso = 0;
            double altura = 0;
            double imc = 0;
            String respostaTextView = "";

        }

    }



