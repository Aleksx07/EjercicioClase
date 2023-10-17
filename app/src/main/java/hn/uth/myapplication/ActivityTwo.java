package hn.uth.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class ActivityTwo extends AppCompatActivity {

    Button btnCrate, btnList, btnVoz, btnCombo, btnFotoTake;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        btnCrate = (Button) findViewById(R.id.btnCreate);
        btnList = (Button) findViewById(R.id.btnList);
        btnVoz = (Button) findViewById(R.id.btnVoz);
        btnCombo = (Button) findViewById(R.id.btnCombo);
        btnFotoTake = (Button) findViewById(R.id.btnFotoTake);

        /* Creacion de los listener de los botones */

        View.OnClickListener butonclick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class<?> actividad = null;

                if (view.getId() == R.id.btnCreate) {
                    actividad = MainActivity.class;
                }
                else if(view.getId() == R.id.btnList){
                    actividad = ActivityList.class;

                }
                else if(view.getId() == R.id.btnCombo){
                    actividad = ActivityCombo.class;

                }
                else if(view.getId() == R.id.btnFotoTake){
                    actividad = ActivityPhoto.class;

                }

                if (actividad != null){
                    NoveActivity(actividad);
                }

            }
        };

        btnCrate.setOnClickListener(butonclick);
        btnList.setOnClickListener(butonclick);
        btnVoz.setOnClickListener(butonclick);
        btnCombo.setOnClickListener(butonclick);
        btnFotoTake.setOnClickListener(butonclick);

    }

    private void NoveActivity( Class<?> actividad) {
        Intent intent = new Intent(getApplicationContext(), actividad);
        startActivity(intent);
    }
}