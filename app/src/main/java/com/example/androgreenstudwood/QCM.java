package com.example.androgreenstudwood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class QCM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm);
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