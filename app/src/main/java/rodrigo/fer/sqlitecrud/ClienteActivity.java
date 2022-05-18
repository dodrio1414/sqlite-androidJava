package rodrigo.fer.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import rodrigo.fer.sqlitecrud.db.DbClientes;

public class ClienteActivity extends AppCompatActivity {

    EditText nombre, apellido, direccion,clientescol,dni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        nombre=findViewById(R.id.txt_Cnombre);
        apellido=findViewById(R.id.txt_Capellido);
        direccion=findViewById(R.id.txt_Cdireccion);
        clientescol=findViewById(R.id.txt_Cclientescol);
        dni=findViewById(R.id.txt_Cdni);

        ImageButton addCliente=findViewById(R.id.btn_CagregarCliente);
        ImageButton cancelCliente=findViewById(R.id.btn_CcancelarCliente);

        addCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Agregar REgistros
                agregarRegistros();
            }
        });

        cancelCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cancelar
                limpiarElementos();
            }
        });

    }

 //FUNCIONES VOID
    private void agregarRegistros() {
        DbClientes dbClientes = new DbClientes(ClienteActivity.this);
        long id = dbClientes.insertaClientes(nombre.getText().toString(), apellido.getText().toString(),
                direccion.getText().toString(),
                clientescol.getText().toString(),
                dni.getText().toString());

        if (id>0){
            Toast.makeText(ClienteActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
            //limpiar al finalizar el registro
            limpiarElementos();
        }else {
            Toast.makeText(ClienteActivity.this, "ERROR REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarElementos() {
        nombre.setText("");
        apellido.setText("");
        direccion.setText("");
        clientescol.setText("");
        dni.setText("");
    }
}