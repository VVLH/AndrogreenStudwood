package com.example.androgreenstudwood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class totalConso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_conso);

        String conso= String.valueOf(getIntent().getIntExtra("conso",0));
        TextView resultatConso= (TextView) findViewById(R.id.resultat);
        TextView texteConso= (TextView) findViewById(R.id.votreconso);
        TextView texteEmission= (TextView)  findViewById(R.id.emission);
        TextView resultatEmission= (TextView) findViewById(R.id.resultatemission);
        texteConso.setText("Votre consommation de carburant est de :");
        resultatConso.setText(conso+" litre/100km ");
        texteEmission.setText("Soit une émission de:");
        double calculeEmission = (6.49 * 352) * Integer.parseInt(conso);
        resultatEmission.setText(String.valueOf(calculeEmission)+ "g de CO2");



    }
}