package com.example.androgreenstudwood;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ClientDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "androgreen.db";

    public final String SQL_CREATE_Ville = "CREATE TABLE IF NOT EXISTS Ville (id INTEGER PRIMARY KEY, nom TEXT, emission FLOAT);";
    public final String SQL_CREATE_Personne = "CREATE TABLE IF NOT EXISTS Personne (id INTEGER PRIMARY KEY, nom TEXT, prenom TEXT,transport TEXT, litre FLOAT, distance FLOAT);";
    public final String SQL_INSERT = "INSERT INTO Ville (id,nom,emission) VALUES (01,'Centre-Val de Loire',8.63),(02,'Grand Est',8.65),(03,'Pays de la Loire',8.83),(04,'Bourgogne-Franche-Comté',8.89),(05,'Bretagne',8.91),(06,'Auvergne-Rhône-Alpes',8.94),(07,'Hauts-de-France',9.14),(08,'Occitanie',9.16),(09,'Nouvelle-Aquitaine',9.28),(10,'île-de-France',9.45),(11,'Normandie',9.57),(12,'Corse',9.66),(13,'Provence-Alpes-Côte-d Azur',10.25) ;";
    public final String SQL_DELETE_Ville = "DROP TABLE IF EXISTS Ville;";
    public final String SQL_DELETE_Personne = "DROP TABLE IF EXISTS Personne;";

    public ClientDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase  db) {
        db.execSQL(SQL_CREATE_Ville);
        db.execSQL(SQL_CREATE_Personne);
        db.execSQL(SQL_INSERT);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_Ville);
        db.execSQL(SQL_DELETE_Personne);

        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion,int newVersion){
        onUpgrade(db,oldVersion,newVersion);
    }


}

