package com.example.gilsonbarbosa.meuprogramamisto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gilsonbarbosa.meuprogramamisto.daoum.dao.DaoAdapter;
import com.example.gilsonbarbosa.meuprogramamisto.daoum.dao.DaoPessoa;
import com.example.gilsonbarbosa.meuprogramamisto.daoum.domain.Pessoa;

public class NovoActivity extends AppCompatActivity {

    private long id = 0l;

    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtTelefone;
   // private EditText txtEndereco;
    //private EditText txtCidade;

    private RadioGroup radios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);
        setTitle("Nova Pessoa");

        DaoAdapter daoAdapter = new DaoAdapter(this);
        daoAdapter.onCreate(daoAdapter.getWritableDatabase());

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);
      //  txtEndereco = findViewById(R.id.txtEndereco);
        //txtCidade = findViewById(R.id.txtCidade);
        radios = findViewById(R.id.radios);

          Bundle b = getIntent().getExtras();
        if(b != null){

            id = b.getLong("id");
            DaoPessoa daoPessoa = new DaoPessoa(this);
            //pegamos a pessoa do banco
            Pessoa pessoa = daoPessoa.getPessoa(id);
            //setamos os inputs com a informação da pessoa do banco
            txtNome.setText(pessoa.getNome());
            txtEmail.setText(pessoa.getEmail());
            txtTelefone.setText(pessoa.getTelefone());
            //txtEndereco.setText(pessoa.getEndereco());
          //  txtCidade.setText(pessoa.getCidade());
            RadioButton radioSelecionado = findViewById(radios.getCheckedRadioButtonId());
            radioSelecionado.setText(pessoa.getSexo());
          setTitle("Alterar Pessoa");
        }
   }
    public void salvar(View v){
        String result = "";

        RadioButton radioSelecionado = findViewById(radios.getCheckedRadioButtonId());

        Pessoa p = new Pessoa();
        p.setId(id);
        p.setNome(txtNome.getText().toString());
        p.setEmail(txtEmail.getText().toString());
        p.setTelefone(txtTelefone.getText().toString());
        //p.setEndereco(txtEndereco.getText().toString());
       // p.setCidade(txtCidade.getText().toString());
        p.setSexo(radioSelecionado.getText().toString());

        DaoPessoa daoPessoa = new DaoPessoa(this);
        if(id == 0l){
            //inserindo no banco
            if(daoPessoa.insert(p) > 0){
                Toast.makeText(this, "Sucesso!", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "Erro!", Toast.LENGTH_SHORT).show();
            }
        } else{
            //alterando no banco
            if(daoPessoa.update(p)){
                Toast.makeText(this, "Sucesso!", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "Erro!", Toast.LENGTH_SHORT).show();
            }
        }
        finish();
    }
}

