package com.example.androgreenstudwood;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.text.BreakIterator;

public class QCM extends AppCompatActivity {
    Button bouton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm);
        bouton = (Button) findViewById(R.id.retourQCM);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button boutonV = (Button) findViewById(R.id.valider);
        boutonV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




        RadioGroup radio= findViewById(R.id.groupe);
        RadioButton check= radio.findViewById(radio.getCheckedRadioButtonId());
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TextInputLayout litre= (TextInputLayout) findViewById(R.id.litrelayout) ;
                TextInputLayout conso= (TextInputLayout) findViewById(R.id.consolayout);
                TextView questionLitre= (TextView) findViewById(R.id.questionlitre) ;
                TextView questionConso= (TextView) findViewById(R.id.conso) ;
                switch (i) {
                    case R.id.voiture:
                        litre.setVisibility(View.VISIBLE);
                        conso.setVisibility(View.VISIBLE);
                        questionLitre.setVisibility(View.VISIBLE);
                        questionConso.setVisibility(View.VISIBLE);
                        break;
                    default:
                        litre.setVisibility(View.INVISIBLE);
                        conso.setVisibility(View.INVISIBLE);
                        questionLitre.setVisibility(View.INVISIBLE);
                        questionConso.setVisibility(View.INVISIBLE);

                }
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
                intent = new Intent(QCM.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.ville:
                intent = new Intent(QCM.this, City.class);
                startActivity(intent);
                break;
            case R.id.qcm:
                Toast.makeText(this, "Vous etes déja sur le questionnaire", Toast.LENGTH_SHORT).show();
                break;
            case R.id.apropos:
                intent = new Intent(QCM.this, A_Propos.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}