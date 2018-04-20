package com.example.gilsonbarbosa.meuprogramamisto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Aula4Activity extends AppCompatActivity {
    private CheckBox checkUm;
    private CheckBox checkDois;
    private Spinner spinner;
    private SeekBar seekBar;
    private RadioGroup radios;
    private DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula4);
        checkUm = findViewById(R.id.checkUm);
        checkDois = findViewById(R.id.checkDois);
        spinner = findViewById(R.id.spinner);
        seekBar = findViewById(R.id.seekBar);
        radios = findViewById(R.id.radios);
        datePicker = findViewById(R.id.datePicker);
        setTitle("Aula Quatro");
        Bundle b = getIntent().getExtras();
        if(b != null){
            Toast.makeText(this,
                    b.getString("teste"), Toast.LENGTH_LONG).show();}

        inicializaSpinner();
        inicializaSeekbar();
    }
    private void inicializaSeekbar(){
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(Aula4Activity.this, "Seekbar modificada: " + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void inicializaSpinner(){
        List<String> list = new ArrayList<String>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void salvar(View v){
        String result = "";
        result += "checkUm: " + (checkUm.isChecked() ? "Selecionado" : "Não Selecionado");
        result += "\ncheckDois: " + (checkDois.isChecked() ? "Selecionado" : "Não Selecionado");

        result += "\nspinner: " + spinner.getSelectedItem().toString();

        result += "\nseekBar: " + seekBar.getProgress();

        RadioButton radioSelecionado = findViewById(radios.getCheckedRadioButtonId());
        result += "\nradio: " + radioSelecionado.getText().toString();

        switch (radios.getCheckedRadioButtonId()){
            case R.id.radioUm:
                result +="\nradio: radioUm";
                break;
            case R.id.radioDois:
                result +="\nradio: radioDois";
                break;
        }

        int dia = datePicker.getDayOfMonth();
        int mes = datePicker.getMonth() + 1;
        int ano = datePicker.getYear();
        result += "\ndatePicker: " + dia + "/" + mes + "/" + ano;


        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}
