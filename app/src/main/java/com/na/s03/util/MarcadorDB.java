package com.na.s03.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MarcadorDB extends SQLiteOpenHelper {

    public MarcadorDB(Context context) {
        super(context, Constantes.NOMBRE_BD, null, Constantes.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + Constantes.NOMBRE_TABLA +
                        " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " nombre TEXT NOT NULL," +
                        " marca TEXT NOT NULL," +
                        " modelo TEXT NOT NULL," +
                        " color TEXT NOT NULL," +
                        " longitud TEXT NOT NULL);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void resetDb(SQLiteDatabase db) {
        db.execSQL("delete from "+ Constantes.NOMBRE_TABLA);
        db.close();
    }
}
