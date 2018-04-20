package com.example.gilsonbarbosa.meuprogramamisto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CicloVidaActivity extends AppCompatActivity {


    private Button btndiv, btnmult,  btnmais, btnsub;

    public TextView display;
    private EditText valor1;
    private EditText valor2;
    private TextView exibir;
    //Vars da classe para o calculo
    double n1, n2, resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_vida);
        Log.i("ciclo", "onCreate()");


        valor1 = findViewById(R.id.valor1);
        valor2    = findViewById(R.id.valor2);
        display  = findViewById(R.id.display);
        btndiv       =   findViewById(R.id.btndiv);
        btnmult    =   findViewById(R.id.btnmult);
        btnmais     =  findViewById(R.id.btnmais);
        btnsub =  findViewById(R.id.btnsub);
        exibir = findViewById(R.id.exibir);

        setTitle("Ciclo de Vida");
        Bundle b = getIntent().getExtras();
        if(b != null){
            Toast.makeText(this,
                    b.getString("teste"), Toast.LENGTH_LONG).show();}

        //BOTÃO SOMAR

        btnmais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Passando os valores do layout para as vars da classe
                n1 = Double.parseDouble(valor1.getText().toString());
                n2 = Double.parseDouble(valor2.getText().toString());

                resultado = n1+n2;
                //Passando os valores da soma para o campo Resultado do layout
                display.setText(String.valueOf(resultado));
                exibir.setText("+");
            }
        });

        //BOTÃO SUBTRAIR
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Passando os valores do layout para as vars da classe
                n1 = Double.parseDouble(valor1.getText().toString());
                n2 = Double.parseDouble(valor2.getText().toString());

                resultado = n1-n2;

                //Passando os valores da soma para o campo Resultado do layout
                // display.setText(String.valueOf(resultado));
                display.setText(String.valueOf(resultado));
                exibir.setText("-");
            }
        });

        //BOTÃO DIVIDIR
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Passando os valores do layout para as vars da classe
                n1 = Double.parseDouble(valor1.getText().toString());
                n2 = Double.parseDouble(valor2.getText().toString());

                resultado = n1/n2;

                //Passando os valores da soma para o campo Resultado do layout
                display.setText(String.valueOf(resultado));
                exibir.setText("/");
            }
        });

        //BOTÃO MULTIPLICAR
        btnmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Passando os valores do layout para as vars da classe
                n1 = Double.parseDouble(valor1.getText().toString());
                n2 = Double.parseDouble(valor2.getText().toString());

                resultado = n1*n2;

                //Passando os valores da soma para o campo Resultado do layout
                display.setText(String.valueOf(resultado));
                exibir.setText("x");
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo", "onStart()");
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo", "onDestroy()");
    }
}
