package com.example.androgreenstudwood;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Regions extends AppCompatActivity {
    private ClientDbHelper bdd;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regions);
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
                Integer regionId = curs.getInt(curs.getColumnIndexOrThrow("id"));
                String regionNom = curs.getString(curs.getColumnIndexOrThrow("nom"));
                Float regionEmission = curs.getFloat(curs.getColumnIndexOrThrow("emission"));
                nom.setText(regionNom);
                emission.setText(getString(R.string.emissionRegion)+" "+ String.valueOf(regionEmission) +" "+ getString(R.string.enCO));
                rang.setText((getString(R.string.rang))+" "+ String.valueOf(regionId));
        }

        Button bouton = (Button) findViewById(R.id.retour);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

}