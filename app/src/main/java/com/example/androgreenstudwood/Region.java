package com.example.androgreenstudwood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Region extends AppCompatActivity {

    private ListView lvRegions;
    private String[] Region = {"Centre-Val de Loire", "Grand Est", "Pays de la Loire", "Bourgogne-Franche-Comté", "Bretagne",
                    "Auvergne-Rhône-Alpes", "Hauts-de-France", "Occitanie", "Nouvelle-Aquitaine", "Île-de-France",
                    "Normandie", "Corse", "Provence-Alpes-Côte d Azur"};
    private int[] regionImages = {R.drawable.ville, R.drawable.ville, R.drawable.ville, R.drawable.ville, R.drawable.ville,
                        R.drawable.villemoyenne, R.drawable.villemoyenne, R.drawable.villemoyenne, R.drawable.villemoyenne, R.drawable.villemoyenne,
                        R.drawable.petiteville, R.drawable.petiteville, R.drawable.petiteville, R.drawable.petiteville, R.drawable.petiteville,
                        R.drawable.villeverte, R.drawable.villeverte, R.drawable.villeverte, R.drawable.villeverte, R.drawable.villeverte};

    public static final String MSG = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);

        Button bouton = (Button) findViewById(R.id.retourCity);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        // creation de la liste des differentes regions
        lvRegions = (ListView) findViewById(R.id.listview);
        //creation d'un adapteur entre les régions et les images
        RegionAdapter villeAdapter = new RegionAdapter(getApplicationContext(), Region, regionImages);
        // application de l'adapteur sur la list des regions
        lvRegions.setAdapter(villeAdapter);

        //creation d'un setOnItemClickListener pour realiser une action des que l'on clique sur un element de la liste
        lvRegions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s =(String)parent.getItemAtPosition(position);
                Intent intent = new Intent(Region.this, Regions.class);
                intent.putExtra("region",Region[position]);
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
                intent = new Intent(Region.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.ville:
                Toast.makeText(this, getString(R.string.Dejasurregion), Toast.LENGTH_SHORT).show();

                break;
            case R.id.qcm:
                intent = new Intent(Region.this, QCM.class);
                startActivity(intent);
                break;
            case R.id.apropos:
                intent = new Intent(Region.this, A_Propos.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}