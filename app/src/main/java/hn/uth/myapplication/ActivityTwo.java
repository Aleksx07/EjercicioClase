package hn.uth.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTwo extends AppCompatActivity {

    Button btnCrate, btnList, btnVoz, btnCombo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        btnCrate = (Button) findViewById(R.id.btnCreate);
        btnList = (Button) findViewById(R.id.btnList);
        btnVoz = (Button) findViewById(R.id.btnVoz);
        btnCombo = (Button) findViewById(R.id.btnCombo);

        /* Creacion de los listener de los botones */

        btnCrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreate = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentCreate);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreate = new Intent(getApplicationContext(), ActivityList.class);
                startActivity(intentCreate);
            }
        });

        btnVoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreate = new Intent(getApplicationContext(), ActivityList.class);
                startActivity(intentCreate);
            }
        });

        btnCombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreate = new Intent(getApplicationContext(), ActivityCombo.class);
                startActivity(intentCreate);
            }
        });

    }
}