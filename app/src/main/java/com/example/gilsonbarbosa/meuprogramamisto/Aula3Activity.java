package com.example.gilsonbarbosa.meuprogramamisto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Aula3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula3);
        setTitle("Aula Três!");

        Bundle b = getIntent().getExtras();
        if(b != null){
            Toast.makeText(this,
                    b.getString("teste"), Toast.LENGTH_LONG).show();}
    }

    public void cadastroPessoa(View v){
        Intent i = new Intent(Aula3Activity.this, CadastroPessoaActivity.class);
        i.putExtra("teste", "Gilson");
        startActivity(i);
    }

    public void cadastroAnimal(View v){
        Intent i = new Intent(Aula3Activity.this,
                CadastroAnimalActivity.class);
        i.putExtra("teste", "Gilson");
        startActivity(i);
    }

    public void cadastroFuncionario(View v){
        Intent i = new Intent(Aula3Activity.this,
                CadastroFuncionarioActivity.class);
        i.putExtra("teste", "Gilson");
        startActivity(i);

    }
}
