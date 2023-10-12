package hn.uth.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import hn.uth.myapplication.Models.Persona;
import hn.uth.myapplication.configuracion.SQLiteConexion;
import hn.uth.myapplication.configuracion.Transacciones;

public class ActivityList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listView;
    ArrayList<Persona> listPerson;
    ArrayList<String> ArregloPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        try {
            //Establecemos una conexion a base de datos
            conexion = new SQLiteConexion(this, Transacciones.namedb, null, 1);
            listView = (ListView) findViewById(R.id.listPersonas);
            GetPersons();

            ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ArregloPersonas);
            listView.setAdapter(adp);

            listView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                }
            });
        }
        catch (Exception ex){
            ex.toString();
        }
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
        Fillist();
    }

    private void Fillist() {

        ArregloPersonas = new ArrayList<String>();

        for(int i = 0; i < listPerson.size(); i++){
            ArregloPersonas.add(listPerson.get(i).getId() + " - " +
                    listPerson.get(i).getNombres() + " - " +
                    listPerson.get(i).getApellidos());

        }
    }
}