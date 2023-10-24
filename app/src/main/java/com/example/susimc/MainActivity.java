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

            Button limparButton = findViewById(R.id.limpar);
            limparButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    limparDados();
                }
            });

        }


        // funcção para calcular o IMC
        private void calcular() {


            String nome = nomeEditText.getText().toString();
            String pesoStr = pesoEditText.getText().toString();
            String alturaStr = alturaEditText.getText().toString();

            if (nome.isEmpty()) {
                respostaTextView.setTextColor(getResources().getColor(R.color.red));
                respostaTextView.setText("[ERRO] Você não colocou o seu nome!");
            } else if (pesoStr.isEmpty()) {
                respostaTextView.setTextColor(getResources().getColor(R.color.red));
                respostaTextView.setText("[ERRO] Você não colocou o seu peso!");
            }else if (alturaStr.isEmpty()) {
                respostaTextView.setTextColor(getResources().getColor(R.color.red));
                respostaTextView.setText("[ERRO] Você não colocou a sua altura!");
            }else if (!alturaStr.contains(".")) {
                respostaTextView.setTextColor(getResources().getColor(R.color.red));
                respostaTextView.setText("[ERRO] A altura deve conter ponto (exemplo: 1.82)!");
            }else {
                try {
                    respostaTextView.setTextColor(getResources().getColor(R.color.black));
                    double peso = Double.parseDouble(pesoStr);
                    double altura = Double.parseDouble(alturaStr);
                    double imc = peso / (altura * altura);
                    respostaTextView.setText("[ERRO] Você não colocou o seu peso!");
                    if (altura == 0) {
                        respostaTextView.setText("[ERRO] Você não colocou a sua altura!");
                    } else if (imc < 16) {
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
                } catch (NumberFormatException e) {
                    respostaTextView.setText("[ERRO] Peso e altura devem ser números válidos!");
                }
            }
        }
        
        // função para limpar os campos
        private void limparDados() {
            nomeEditText.setText("");  // limpa o campo de nome
            pesoEditText.setText("");  // limpa o campo de peso
            alturaEditText.setText("");  // limpa o campo de altura
            respostaTextView.setText("");  // limpa o campo de resposta
            img.setImageResource(0);  // remove a imagem
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(android.R.color.white));  // restaura a cor de fundo padrão
        }


    }



