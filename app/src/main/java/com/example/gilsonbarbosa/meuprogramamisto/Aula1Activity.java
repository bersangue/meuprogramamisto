package com.example.gilsonbarbosa.meuprogramamisto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Aula1Activity extends AppCompatActivity {

    private EditText texto;
    private TextView exibir;
    private Button acao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula1);
        texto = (EditText) findViewById(R.id.texto);
        exibir = (TextView) findViewById(R.id.exibir);
        acao = (Button) findViewById(R.id.acao);
        setTitle("Aula Um");
        Bundle b = getIntent().getExtras();
        if(b != null){
            Toast.makeText(this,
                    b.getString("teste"), Toast.LENGTH_LONG).show();}

    }

    public void acao(View v){
        String t = texto.getText().toString();
        exibir.setText(t);
    }

}