package com.example.gilsonbarbosa.meuprogramamisto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AtividadePaticaActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtTelefone;
    private CheckBox checkUm;
    private CheckBox checkDois;
    private CheckBox checkTres;
    private CheckBox checkQuatro;
    private Spinner spinner;
    private SeekBar seekBar;
    private RadioGroup radios;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_patica);
        setTitle("Aula Pratica");
        Bundle b = getIntent().getExtras();
        if (b != null) {
            Toast.makeText(this,
                    b.getString("teste"), Toast.LENGTH_LONG).show();
        }
        txtNome = findViewById(R.id.txtNome);
        txtTelefone = findViewById(R.id.txtTelefone);

        checkUm = findViewById(R.id.checkUm);
        checkDois = findViewById(R.id.checkDois);
        checkTres = findViewById(R.id.checkTres);
        checkQuatro = findViewById(R.id.checkQuatro);
        spinner = findViewById(R.id.spinner);
        seekBar = findViewById(R.id.seekBar);
        radios = findViewById(R.id.radios);
        datePicker = findViewById(R.id.datePicker);
        inicializaSpinner();
        inicializaSeekbar();
    }

    private void inicializaSeekbar() {
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(AtividadePaticaActivity.this, "Seekbar modificada: " + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void inicializaSpinner() {
        List<String> list = new ArrayList<String>();
        list.add("Futebol");
        list.add("Natação");
        list.add("Karate");
        list.add("Ciclismo");
        list.add("Corrida");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }


    public void salvar(View v) {
        String result = "";
        result += "Banana: " + (checkUm.isChecked() ? "Selecionado" : "Não Selecionado");
        result += "\nMaça: " + (checkDois.isChecked() ? "Selecionado" : "Não Selecionado");
        result += "\nPera: " + (checkTres.isChecked() ? "Selecionado" : "Não Selecionado");
        result += "\nMelância: " + (checkQuatro.isChecked() ? "Selecionado" : "Não Selecionado");

        result += "\nspinner: " + spinner.getSelectedItem().toString();

        result += "\nseekBar: " + seekBar.getProgress();

        RadioButton radioSelecionado = findViewById(radios.getCheckedRadioButtonId());
        result += "\nradio: " + radioSelecionado.getText().toString();

        switch (radios.getCheckedRadioButtonId()){
            case R.id.radioUm:
                result +="\nIdade acima de 10 anos";
                break;
            case R.id.radioDois:
                result +="\nIdade acima de 20 anos";
                break;
            case R.id.radioTres:
                result +="\nIdade acima de 30 anos";
                break;
        }
        String nome = txtNome.getText().toString();
        int telefone = Integer.parseInt(txtTelefone.getText().toString());

        if (nome.length() < 3) {
            txtNome.setError("Digite ao menos 3 caracteres!");
            return;
        }
        if (telefone < 3) {
            txtTelefone.setError("Digite ao menos 3 caracteres!");
            return;
        }


        int dia = datePicker.getDayOfMonth();
        int mes = datePicker.getMonth() + 1;
        int ano = datePicker.getYear();
        result += "\ndatePicker: " + dia + "/" + mes + "/" + ano;



        Toast.makeText(this,
                 result
                         + "\nNome: " + nome
                         + "\nTelefone: " + telefone
                         , Toast.LENGTH_LONG).show();
    }

}
