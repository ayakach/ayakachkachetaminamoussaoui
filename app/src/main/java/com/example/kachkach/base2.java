package com.example.kachkach;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class base2  extends SQLiteOpenHelper {
    public base2( Context context) {
        super(context, "ayakachkach2.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists tableannonce (titre text,ville text ,scecteur text ,categorie text ,typedecontrat text,description text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertnewannonce(String titre, String categorie, String secteur, String typedecontrat,String description,String ville) {
        SQLiteDatabase wdb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email",titre );
        values.put("ville", ville);
        values.put("scecteur", secteur);
        values.put("categorie", categorie);
        values.put("typedecontrat",typedecontrat);
        values.put("description", description);
        wdb.insert("tableannonce", null, values);
    }
    public int countAnnoncesByVille(String ville) {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = "tableannonce";
        String[] columns = {"COUNT(*)"};
        String selection = "ville=?";
        String[] selectionArgs = {ville};
        String groupBy = null;
        String having = null;
        String orderBy = null;
        String limit = null;

        Cursor cursor = db.query(table, columns, selection,
                selectionArgs, groupBy, having, orderBy, limit);
        int count = 0;
        if (cursor != null && cursor.moveToFirst()) {
            count = cursor.getInt(0);
            cursor.close();
        }
        return count;
    }
}
