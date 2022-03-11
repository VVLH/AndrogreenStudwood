package com.example.androgreenstudwood;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Villes extends AppCompatActivity {
    private ClientDbHelper bdd;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_villes);
       TextView nom= (TextView) findViewById(R.id.region);
       TextView emission= (TextView) findViewById(R.id.emissionRegion);
        TextView rang= (TextView) findViewById(R.id.rang);
        String region = getIntent().getStringExtra("region");
        bdd= new ClientDbHelper(this);
        db= bdd.getWritableDatabase();
        String[] col2= {"id","nom","emission"};
        String[] select= {region};
        Cursor curs= db.query("Ville",col2, "nom=?", select, null,null,"id ASC");
        if (curs.moveToFirst()){
                Integer villeId = curs.getInt(curs.getColumnIndexOrThrow("id"));
                String villeNom = curs.getString(curs.getColumnIndexOrThrow("nom"));
                Float villeEmission = curs.getFloat(curs.getColumnIndexOrThrow("emission"));
                nom.setText(villeNom);
                emission.setText(R.string.emissionRegion+String.valueOf(villeEmission));
                rang.setText(R.string.rang+String.valueOf(villeId));
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}