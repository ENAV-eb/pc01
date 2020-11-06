package com.na.s03.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.na.s03.entidades.Marcador;
import com.na.s03.util.Constantes;
import com.na.s03.util.MarcadorDB;

import java.util.ArrayList;

public class DAOMarcador {

    MarcadorDB dbMarcador;
    SQLiteDatabase db;
    private Context context;

    public DAOMarcador(Context context){
        dbMarcador = new MarcadorDB(context);
        this.context = context;
    }

    public void openDB(){db = dbMarcador.getWritableDatabase();}

    public void registrarMarcador(Marcador marcador){

        try {
            ContentValues values = new ContentValues();
            values.put("nombre",marcador.getNombre());
            values.put("modelo",marcador.getModelo());
            values.put("marca",marcador.getMarca());
            values.put("color",marcador.getColor());
            values.put("longitud",marcador.getLongitud());

            long result = db.insert(Constantes.NOMBRE_TABLA,
                    null,values);

            if (result == -1){
                Toast.makeText(context, "Insert error of " + marcador.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Success insert of " + marcador.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(),
                Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<Marcador> getAllMarcadores(){

        ArrayList<Marcador> lista = new ArrayList<>();

        try {

            Cursor c = db.rawQuery("SELECT * FROM " + Constantes.NOMBRE_TABLA,
                    null);

            while (c.moveToNext()){
                lista.add(new Marcador(
                        c.getInt(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4),
                        c.getString(5)));
            }

        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return lista;
    }

    public void clearDB(){
        dbMarcador.resetDb(db);
    }
}
