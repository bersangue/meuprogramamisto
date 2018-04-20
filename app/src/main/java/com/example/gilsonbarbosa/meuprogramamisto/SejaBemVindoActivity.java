package com.example.gilsonbarbosa.meuprogramamisto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SejaBemVindoActivity extends AppCompatActivity {

    private EditText txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seja_bem_vindo);
        txtNome = findViewById(R.id.txtNome);
        setTitle("Seja Bem Vindo!");
        Bundle b = getIntent().getExtras();
        if (b != null) {
            Toast.makeText(this,
                    b.getString("teste"), Toast.LENGTH_LONG).show();
        }
    }

    public void openAtividadePratica(View v) {
        String nome = txtNome.getText().toString();
        Intent i = new Intent(SejaBemVindoActivity.this, AtividadePaticaActivity.class);
        switch (nome) {
            case "Fabio":
                Toast.makeText(this, "\nSeja Bem Vindo Fabio: ", Toast.LENGTH_LONG).show();
                startActivity(i);
                break;
            case "Gilson":
                Toast.makeText(this, "\nSeja Bem Vindo Gilson: ", Toast.LENGTH_LONG).show();
                startActivity(i);
                break;


            case "":
                Toast.makeText(this, "\nDigite somente seu nome com a primeira letra Maiuscula ", Toast.LENGTH_LONG).show();
                break;

        }
    }
}