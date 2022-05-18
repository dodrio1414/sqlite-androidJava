package rodrigo.fer.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import rodrigo.fer.sqlitecrud.db.DbHelperSqlite;
import rodrigo.fer.sqlitecrud.mainTables.ClientesMain;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageButton btnCrearBD= findViewById(R.id.btn_crearBaseDeDatos);
        btnCrearBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crear base de datos
                newDatabase();
            }
        });

        ImageButton btnClientes= findViewById(R.id.btn_Clientes);
        btnClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClientesActv();
            }
        });


    }




//
    //FUNCIONES VOID
//

    private void newDatabase() {
        //creamos la base de datos
        DbHelperSqlite dbHelperSqlite = new DbHelperSqlite(MainActivity.this);
        //decimos q podemos escribir en nuestra base de datos
        SQLiteDatabase db = dbHelperSqlite.getWritableDatabase();
        if (db!=null){
            Toast.makeText(MainActivity.this, "Se Creo Correctamente la BaseDeDatos", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "ERROR en la creacion de la BaseDeDatos", Toast.LENGTH_SHORT).show();
        }

    }

    private void ClientesActv() {
        Intent intent = new Intent(this, ClientesMain.class);
        startActivity(intent);
    }


}