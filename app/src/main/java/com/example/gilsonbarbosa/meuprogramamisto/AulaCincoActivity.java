package com.example.gilsonbarbosa.meuprogramamisto;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AulaCincoActivity extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_cinco);

        listView = findViewById(R.id.listView);
        loadListView();
    }

    private void loadListView() {
        final String[] values = new String[]{
                "José" ,
                "mario",
                "Robert",
                "Andressa",
                "Gilson",
                "João",
                "Luiz",
                "Diego"
        };

        ArrayAdapter<String >adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {
                String nome = listView.getItemAtPosition(position).toString();


                Toast.makeText(AulaCincoActivity.this,
                        "Posição: "+  position + " Clicou no nome " + nome

                        ,Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                String texto = listView.getItemAtPosition(position).toString();
                Toast.makeText(AulaCincoActivity.this,
                        "Long Posição: "+  position + " Clicou no nome " + texto

                        ,Toast.LENGTH_SHORT).show();

                return true;

            }
        }
        );

    }
}

