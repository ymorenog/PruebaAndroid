package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BBDD_OpenHelper extends SQLiteOpenHelper {
    public static final String TABLA_USUARIOS = "USUARIOS";
    public static final String ID = "ID";
    public static final String NOMBRE = "NOMBRE";
    public static final String DIRECCION = "DIRECCION";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";

    public BBDD_OpenHelper(@Nullable Context context) {
        super(context, "bdusuarios.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "CREATE TABLE " + TABLA_USUARIOS + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOMBRE + " TEXT, " + DIRECCION + " TEXT, " + EMAIL + " TEXT, " + PASSWORD + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertarRegistro(String nom, String dir, String correo, String pass){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(NOMBRE,nom);
        cv.put(DIRECCION,dir);
        cv.put(EMAIL,correo);
        cv.put(PASSWORD,pass);

        long insert = db.insert(TABLA_USUARIOS, null, cv);

        if(insert== -1){
            return false;
        }else{
            return true;
        }


    }

    public Cursor seleccionarRegistros(String usu, String pass) throws SQLException {
        Cursor miCursor = null;
        SQLiteDatabase db = this.getReadableDatabase();


       // String query= "SELECT * FROM " + TABLA_USUARIOS " WHERE "



        return miCursor;

    }


}
