package hn.uth.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hn.uth.myapplication.configuracion.SQLiteConexion;
import hn.uth.myapplication.configuracion.Transacciones;

public class MainActivity extends AppCompatActivity
{
    EditText nombres, apellidos, edad, correo;
    Button btnprocesar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres =  (EditText) findViewById(R.id.txtNombre);
        apellidos = (EditText) findViewById(R.id.txtApellidos);
        edad =  (EditText) findViewById(R.id.txtEdad);
        correo = (EditText) findViewById(R.id.txtCorreo);

        btnprocesar = (Button) findViewById(R.id.btnProcesar);

        btnprocesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AddPerson();
            }
        });
    }

    private void AddPerson() {
        try{
            SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.namedb, null, 1);
            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put(Transacciones.nombres, nombres.getText().toString());
            valores.put(Transacciones.apellidos, apellidos.getText().toString());
            valores.put(Transacciones.edad, edad.getText().toString());
            valores.put(Transacciones.correo, correo.getText().toString());

            Long Result = db.insert(Transacciones.Tabla, Transacciones.id, valores);
            Toast.makeText(this, getString(R.string.Respuesta), Toast.LENGTH_SHORT).show();
            db.close();
        }
        catch (Exception exception){
            Toast.makeText(this, getString(R.string.ErrorResp), Toast.LENGTH_SHORT).show();
        }

    }
}