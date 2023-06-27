package com.br.controledecombustivel_entraga2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SobreActivity extends AppCompatActivity {

    private TextView textViewSobreTex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        textViewSobreTex = findViewById(R.id.textViewSobreTexto);
        setSobreTex();
    }

    public void setSobreTex(){
        textViewSobreTex.setText("Peterson Prestes Carnneiro"
                +"\n"
                +"Especialização em Java"
                +"\n"
                +"peters.prestes@gmail.com"
                +"\n"
                +"App para controle de gasto com combustivél");

    }

}