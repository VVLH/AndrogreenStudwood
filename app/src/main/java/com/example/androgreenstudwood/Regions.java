package com.example.androgreenstudwood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
                intent = new Intent(Regions.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.ville:
                intent = new Intent(Regions.this, Region.class);
                startActivity(intent);
                break;
            case R.id.qcm:
                intent = new Intent(Regions.this, QCM.class);
                startActivity(intent);
                break;
            case R.id.apropos:
                intent = new Intent(Regions.this, A_Propos.class);
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