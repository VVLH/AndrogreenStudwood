package com.example.androgreenstudwood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class City extends AppCompatActivity {

    ListView lvVille;
    String[] villes = {"Paris", "Toulouse", "Clermont-Ferrand", "Marseille", "Nice",
            "Pau", "Narbonne", "Poitier", "Valence", "Montauban",
            "Hossegor", "Gruissan", "Saint-Tropez", "Mimizan", "Capbreton",
            "Angers", "Nantes", "Strasbourg", "Lyon", "Caen"};
    int[] villeImages = {R.drawable.ville, R.drawable.ville, R.drawable.ville, R.drawable.ville, R.drawable.ville,
                        R.drawable.villemoyenne, R.drawable.villemoyenne, R.drawable.villemoyenne, R.drawable.villemoyenne, R.drawable.villemoyenne,
                        R.drawable.petiteville, R.drawable.petiteville, R.drawable.petiteville, R.drawable.petiteville, R.drawable.petiteville,
                        R.drawable.villeverte, R.drawable.villeverte, R.drawable.villeverte, R.drawable.villeverte, R.drawable.villeverte};

    public static final String MSG = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        lvVille = (ListView) findViewById(R.id.listview);
        VilleAdapter villeAdapter = new VilleAdapter(getApplicationContext(), villes, villeImages);
        lvVille.setAdapter(villeAdapter);

        lvVille.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(City.this, Villes.class);
            intent.putExtra(City.MSG, villes[position]);
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.home:
                intent = new Intent(City.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.ville:
                Toast.makeText(this, "Vous etes déja sur les villes", Toast.LENGTH_SHORT).show();

                break;
            case R.id.qcm:
                intent = new Intent(City.this, QCM.class);
                startActivity(intent);
                break;
            case R.id.apropos:
                intent = new Intent(City.this, A_Propos.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}