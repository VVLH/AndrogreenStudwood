package com.example.androgreenstudwood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class A_Propos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apropos);
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
                intent = new Intent(A_Propos.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.ville:
                intent = new Intent(A_Propos.this, City.class);
                startActivity(intent);
                break;
            case R.id.qcm:
                intent = new Intent(A_Propos.this, QCM.class);
                startActivity(intent);
                break;
            case R.id.apropos:
                Toast.makeText(this, "Vous etes déja sur a propos", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
