package com.example.androgreenstudwood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TotalConso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_total_conso);
        if (getIntent().getFloatExtra("conso",0)!=0) {
            String conso = String.valueOf(getIntent().getFloatExtra("conso", 0));
            TextView resultatConso = (TextView) findViewById(R.id.resultat);
            TextView texteConso = (TextView) findViewById(R.id.votreconso);
            TextView texteEmission = (TextView) findViewById(R.id.emission);
            TextView resultatEmission = (TextView) findViewById(R.id.resultatemission);
            texteConso.setText(getString(R.string.consoSup));
            resultatConso.setText(conso + getString(R.string.litre100km));
            texteEmission.setText(getString(R.string.emission));
            float calculeEmission = (float) ((6.49 * 352) * Float.valueOf(conso));
            resultatEmission.setText(String.valueOf(calculeEmission) + getString(R.string.g));
        }else {
            TextView resultatConso = (TextView) findViewById(R.id.resultat);
            resultatConso.setText(getString(R.string.felicitation));

        }
        Button boutonretour = (Button) findViewById(R.id.retourtotal);
        boutonretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.home:
                intent = new Intent(TotalConso.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.ville:
                intent = new Intent(TotalConso.this, Region.class);
                startActivity(intent);
                break;
            case R.id.qcm:
                intent = new Intent(TotalConso.this, QCM.class);
                startActivity(intent);
                break;
            case R.id.apropos:
                intent = new Intent(TotalConso.this, A_Propos.class);
                startActivity(intent);
                break;
            case R.id.quitter:
                System.exit(0);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
