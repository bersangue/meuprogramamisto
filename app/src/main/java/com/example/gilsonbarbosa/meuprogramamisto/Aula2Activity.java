package com.example.gilsonbarbosa.meuprogramamisto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Aula2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula2);

        setTitle("Aula Dois");
        Bundle b = getIntent().getExtras();
        if(b != null){
            Toast.makeText(this,
                    b.getString("teste"), Toast.LENGTH_LONG).show();}
    }
    public void openCicloVida(View v){
        Intent i = new Intent(Aula2Activity.this, CicloVidaActivity.class);
        i.putExtra("teste", "Gilson");
        startActivity(i);
    }
}
