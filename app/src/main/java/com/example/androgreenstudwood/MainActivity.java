package com.example.androgreenstudwood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button boutonQCM;
    private Button boutonVille;
    private Button boutonApropos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonQCM = (Button) findViewById(R.id.boutonQCM);

        boutonQCM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QCM.class);
                intent.putExtra("Info", "un texte");
                startActivity(intent);
            }
        });
        boutonVille= (Button) findViewById(R.id.boutonVille);

        boutonVille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, City.class);
                intent.putExtra("Info", "un texte");
                startActivity(intent);
            }
        });
        boutonApropos= (Button) findViewById(R.id.boutonAPropos);

        boutonApropos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, A_Propos.class);
                intent.putExtra("Info", "un texte");
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


}