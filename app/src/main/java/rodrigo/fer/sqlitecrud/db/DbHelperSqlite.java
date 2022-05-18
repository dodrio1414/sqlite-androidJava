package rodrigo.fer.sqlitecrud.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelperSqlite extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NOMBRE="DBVentas";
    public static final String TABLE_CLIENTES="t_cliente";
    public static final String TABLE_VENTAS="t_ventas";
    public static final String TABLE_PRODUCTOS="t_productos";
    public static final String TABLE_DETALLEVENTAS="t_detalle_ventas";
    public static final String TABLE_USUARIOS="t_usuario";



    //cosntructor
    public DbHelperSqlite(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    //CREACION DE LAS TABLAS
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CLIENTES+"(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "direccion TEXT NOT NULL," +
                "clientescol TEXT NOT NULL," +
                "dni TEXT NOT NULL)");



    }

    //
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_CLIENTES);
        onCreate(sqLiteDatabase);

    }
}
