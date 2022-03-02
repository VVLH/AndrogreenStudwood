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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class City extends AppCompatActivity {

    private Context context;
    private String[] villes = {"Toulouse", "Paris", "Lyon"};
    private static LayoutInflater inflater = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        Button bouton = (Button) findViewById(R.id.retourCity);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void AdapterPerso(Context context, String[] villes){

        this.context =context;
        this.villes = villes;

        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount(){
        return this.villes.length;
    }

    public Object getItem(int position){
        return this.villes[position];
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View previous = convertView;
        View retour = previous;


        return retour;
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