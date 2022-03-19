package com.example.androgreenstudwood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button boutonQCM;
    private Button boutonVille;
    private Button boutonApropos;
    private ClientDbHelper bdd;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);



        //DATABASE
         bdd= new ClientDbHelper(this);
         db= bdd.getWritableDatabase();


        Button Langue = findViewById(R.id.Langue);
        Langue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changerdelangue();
            }
        });






        boutonQCM = (Button) findViewById(R.id.boutonQCM);

        boutonQCM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QCM.class);
                startActivity(intent);
            }
        });
        boutonVille= (Button) findViewById(R.id.boutonVille);

        boutonVille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Region.class);
                startActivity(intent);
            }
        });
        boutonApropos= (Button) findViewById(R.id.boutonAPropos);

        boutonApropos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, A_Propos.class);
                startActivity(intent);
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
                Toast.makeText(this, getString(R.string.Dejasurmenu), Toast.LENGTH_SHORT).show();
                break;
            case R.id.ville:
                intent = new Intent(MainActivity.this, Region.class);
                startActivity(intent);
                break;
            case R.id.qcm:
                intent = new Intent(MainActivity.this, QCM.class);
                startActivity(intent);
                break;
            case R.id.apropos:
                intent = new Intent(MainActivity.this, A_Propos.class);
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }


    private void changerdelangue() {
        final String[] listItems = {"Français", "English"};

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle(getString(R.string.choisirlangue));
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setLocale("fr");
                    recreate();
                } else if (i == 1) {
                    setLocale("en");
                    recreate();
                }

                dialogInterface.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }


    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Paramètres", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Paramètres", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
    }

}