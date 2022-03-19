package com.example.androgreenstudwood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class QCM extends AppCompatActivity {
    Button bouton;
    Button enregistrement;
    EditText nom;
    EditText prenom;
    EditText litre;
    EditText conso;
    RadioGroup choix;
    private ClientDbHelper bdd;
    private SQLiteDatabase db;

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
                Intent intent = new Intent(QCM.this, TotalConso.class);
                if(findViewById(R.id.litrelayout).getVisibility()==View.VISIBLE) {
                    EditText conso = (EditText) findViewById(R.id.questionconso);
                    EditText litre = (EditText) findViewById(R.id.litre);
                    EditText nom = (EditText) findViewById(R.id.nom);
                    float nombreLitre = Float.valueOf(litre.getText().toString());
                    float nombreConso = Float.valueOf(conso.getText().toString());
                    float resultat = (nombreLitre * 100) / nombreConso;
                    intent.putExtra("conso", resultat);
                }
                else{
                    intent.putExtra("conso",0);
                }
                startActivity(intent);

            }
        });
        bdd= new ClientDbHelper(this);
        db= bdd.getWritableDatabase();

        nom= (EditText) findViewById(R.id.nom);
        prenom= (EditText) findViewById(R.id.prenom);
        litre= (EditText) findViewById(R.id.litre);
        conso= (EditText) findViewById(R.id.questionconso);
        choix= (RadioGroup) findViewById(R.id.groupe);

        enregistrement= (Button)  findViewById(R.id.enregistrer);
        enregistrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_nom="";
                String s_prenom="";
                float s_litre=0;
                float s_conso=0;
                String s_choix="";
                
                boolean info= true;
                
                if(nom.getText().toString().trim().equals("")== false){
                    s_nom= nom.getText().toString().trim();
                }else{
                    info=false;
                }
                if(prenom.getText().toString().trim().equals("")== false){
                    s_prenom= prenom.getText().toString().trim();
                }else{
                    info=false;
                }
                if(litre.getText().toString().trim().equals("")== false){
                    s_litre= Float.valueOf(litre.getText().toString().trim());
                }else{
                    s_litre=0;
                }
                if(conso.getText().toString().trim().equals("")== false){
                    s_conso= Float.valueOf(conso.getText().toString().trim());
                }else{
                    s_conso =0;
                }


                int select = choix.getCheckedRadioButtonId();

                if (select !=-1){
                    RadioButton radiochoix;
                    radiochoix= (RadioButton) findViewById(select);
                    s_choix= radiochoix.getText().toString();
                }else{
                    info=false;
                }

                if (info==false){
                    Toast.makeText(getApplicationContext(),getString(R.string.manque),Toast.LENGTH_SHORT ).show();
                }else{
                    ContentValues values= new ContentValues();
                    Toast.makeText(getApplicationContext(),getString(R.string.ok),Toast.LENGTH_SHORT ).show();
                    values.put("nom",s_nom);
                    values.put("prenom",s_prenom);
                    values.put("transport",s_choix);
                    values.put("litre",s_litre);
                    values.put("distance",s_conso);
                    db.insert("Personne",null,values);


                }
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
                intent = new Intent(QCM.this, Region.class);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}