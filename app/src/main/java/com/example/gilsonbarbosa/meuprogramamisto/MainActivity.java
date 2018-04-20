package com.example.gilsonbarbosa.meuprogramamisto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Bem Vindo!");

        Bundle b = getIntent().getExtras();
        if(b != null){
            Toast.makeText(this,
                    b.getString("teste"), Toast.LENGTH_LONG).show();}
    }

    public void aulaUM(View v){
        Intent i = new Intent(MainActivity.this, Aula1Activity.class);
        i.putExtra("teste", "Gilson");
        startActivity(i);
    }

    public void aulaDOIS(View v){
        Intent i = new Intent(MainActivity.this, Aula2Activity.class);
        i.putExtra("teste", "Gilson");
        startActivity(i);
    }

    public void aulaTRES(View v){
        Intent i = new Intent(MainActivity.this, Aula3Activity.class);

        i.putExtra("teste", "Gilson");
        startActivity(i);

    }
    public void aulaQUATRO(View v){

            Intent i = new Intent(MainActivity.this, Aula4Activity.class);
        i.putExtra("teste", "Gilson");
            startActivity(i);
        }
    public void aulaPRATICA(View v){

        Intent i = new Intent(MainActivity.this, SejaBemVindoActivity.class);
        i.putExtra("teste", "Gilson");
        startActivity(i);
    }
    public void aulaCINCO(View v){

        Intent i = new Intent(MainActivity.this, AulaCincoActivity.class);
        i.putExtra("teste", "Gilson");
        startActivity(i);
    }
    public void aulaPraticaDois2(View v){

        Intent i = new Intent(MainActivity.this, NovoActivity.class);
        startActivity(i);
    }
    public void aulaViewCadastro(View v){

        Intent i = new Intent(MainActivity.this, CadastroViewActivity.class);
       startActivity(i);
    }

}


