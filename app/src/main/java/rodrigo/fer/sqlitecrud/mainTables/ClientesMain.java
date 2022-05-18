package rodrigo.fer.sqlitecrud.mainTables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import rodrigo.fer.sqlitecrud.ClienteActivity;
import rodrigo.fer.sqlitecrud.R;

public class ClientesMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageButton btn_addClienteNuevo= findViewById(R.id.btn_addClienteNuevo);
        btn_addClienteNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevoClienteAct();
            }
        });
    }

//
//    FUNCIONES VOID
//

    private void nuevoClienteAct() {
        Intent intent = new Intent(this, ClienteActivity.class);
        startActivity(intent);
    }
}