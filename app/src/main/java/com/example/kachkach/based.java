package com.example.kachkach;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class based  extends SQLiteOpenHelper {
    public based( Context context) {
        super(context, "ayakachkach.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists tablesara (email text ,ville text ,mdp text ,etat text)");
        db.execSQL("create table if not exists tableannonce (titre text,ville text ,scecteur text ,categorie text ,typedecontrat text,description text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertnewone(String email, String ville, String mdp, String etat) {
        SQLiteDatabase wdb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("ville", ville);
        values.put("mdp", mdp);
        values.put("etat", etat);
        wdb.insert("tablesara", null, values);
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

    public boolean verifier(String email) {
        SQLiteDatabase wdb = this.getReadableDatabase();
        String table = "tablesara";
        String[] columns = {"email"};
        String selection = "email=?";
        String[] selectionArgs = {email}; // Utilisation de la valeur de l'email
        String groupBy = null;
        String having = null;
        String orderBy = null;
        String limit = null;
        Cursor cursor = wdb.query(table, columns, selection,
                selectionArgs, groupBy, having, orderBy, limit);
        if (cursor.getCount() == 0)
            return true;
        else
            return false;
    }








}
