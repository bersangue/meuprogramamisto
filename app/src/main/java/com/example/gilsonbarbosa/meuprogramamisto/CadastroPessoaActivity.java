package com.example.gilsonbarbosa.meuprogramamisto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class CadastroPessoaActivity extends AppCompatActivity {
    private EditText txtNome;
    private EditText txtTelefone;
    private EditText txtIdade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoa);

        txtNome = findViewById(R.id.txtNome);
        txtTelefone = findViewById(R.id.txtTelefone);
        txtIdade = findViewById(R.id.txtIdade);

        setTitle("Cadastro de Pessoa");
        Bundle b = getIntent().getExtras();
        if (b != null) {
            Toast.makeText(this, b.getString("teste"), Toast.LENGTH_LONG).show();
        }
    }

    public void salvar(View v) {
        String nome = txtNome.getText().toString();
        int telefone = Integer.parseInt(txtTelefone.getText().toString());
        int idade = Integer.parseInt(txtIdade.getText().toString());

        if (nome.length() < 3) {
            txtNome.setError("Digite ao menos 3 caracteres!");
            return;
        }
        if (telefone < 3) {
            txtTelefone.setError("Digite ao menos 3 caracteres!");
            return;
        }
        if (idade < 3) {
            txtIdade.setError("Digite ao menos 3 caracteres!");
            return;
        }

        Toast.makeText(this, "Nome: " + nome
                + "\nTelefone: " + telefone
                + "\nIdade: " + idade + " anos", Toast.LENGTH_LONG).show();

    }
}
