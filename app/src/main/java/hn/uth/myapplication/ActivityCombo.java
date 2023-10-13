package hn.uth.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import hn.uth.myapplication.Models.Persona;
import hn.uth.myapplication.configuracion.SQLiteConexion;
import hn.uth.myapplication.configuracion.Transacciones;

public class ActivityCombo extends AppCompatActivity {

    SQLiteConexion conexion;
    Spinner comboPersonas;

    EditText nombres, apellidos, correo;

    ArrayList<Persona> listPerson;
    ArrayList<String> ArregloPersonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        conexion = new SQLiteConexion(this, Transacciones.namedb, null, 1);
        comboPersonas = (Spinner) findViewById(R.id.spinner);
        nombres = (EditText) findViewById(R.id.cbNombre);
        apellidos = (EditText) findViewById(R.id.cbApellido);
        correo = (EditText) findViewById(R.id.cbCorreo);

        GetPersons();

        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ArregloPersonas);
        comboPersonas.setAdapter(adp);



    }

    private void GetPersons() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Persona person = null;
        listPerson = new ArrayList<Persona>();

        Cursor cursor = db.rawQuery(Transacciones.SelectTablePersonas, null);
        while (cursor.moveToNext()){
            person = new Persona();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));

            listPerson.add(person);
        }

        cursor.close();
        FillCombo();
    }

    private void FillCombo() {
        ArregloPersonas = new ArrayList<String>();

        for(int i = 0; i < listPerson.size(); i++){
            ArregloPersonas.add(listPerson.get(i).getId() + " - " +
                    listPerson.get(i).getNombres() + " - " +
                    listPerson.get(i).getApellidos());

        }
    }
}
