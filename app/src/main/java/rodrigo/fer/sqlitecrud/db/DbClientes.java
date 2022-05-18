package rodrigo.fer.sqlitecrud.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbClientes extends DbHelperSqlite{

    Context context;




    public DbClientes(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public Long insertaClientes(String nombre, String apellido, String direccion, String clientescol, String dni){

        long id=0;

        try {
            DbHelperSqlite dbHelperSqlite=new DbHelperSqlite(context);
            SQLiteDatabase db = dbHelperSqlite.getWritableDatabase();


            //insertar REgistro
            ContentValues values=new ContentValues();
            values.put("nombre",nombre);
            values.put("apellido",apellido);
            values.put("direccion",direccion);
            values.put("clientescol",clientescol);
            values.put("dni",dni);

            id = db.insert(TABLE_CLIENTES,null,values);
        }catch (Exception e){
            e.toString();
        }

        return id;

    }

}
