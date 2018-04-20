package com.example.gilsonbarbosa.meuprogramamisto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroFuncionarioActivity extends AppCompatActivity {


    private EditText txtNome;
    private EditText txtTelefone;

    private EditText txtFuncao;
    private EditText txtEmailFuncionrio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_funcionario);


        txtNome  = findViewById(R.id.txtNome);
        txtTelefone = findViewById(R.id.txtTelefone);

        txtFuncao = findViewById(R.id.txtFuncao);
        txtEmailFuncionrio  = findViewById(R.id.txtEmailFuncionrio);


        setTitle("Cadastro de Funcionario");
        Bundle b = getIntent().getExtras();
        if(b != null){
            Toast.makeText(this,
                    b.getString("teste"), Toast.LENGTH_LONG).show();}
    }

    public void salvar(View v) {

        String nome = txtNome.getText().toString();
        String telefone = txtTelefone.getText().toString();

        String funcao = txtFuncao.getText().toString();
        String emailFuncionrio = txtEmailFuncionrio.getText().toString();


        if(nome.length() < 3) {
            txtNome.setError("Digite ao menos 3 caracteres!");
            return;
        }
        if(telefone.length() < 3) {
            txtTelefone.setError("Digite ao menos 3 caracteres!");
            return;
        }


        if(funcao.length() < 3) {
            txtFuncao.setError("Digite ao menos 3 caracteres!");
            return;
        }


        if(emailFuncionrio.length() < 2) {
            txtEmailFuncionrio.setError("Digite a idade!");
            return;
        }

        Toast.makeText(this, "Nome: " + nome
                + "\nTelefone: " + telefone
                + "\nFunção: " + funcao
                + "\nEmailFuncionrio: " + emailFuncionrio
                 , Toast.LENGTH_LONG).show();

    }
}
