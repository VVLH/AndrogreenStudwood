package com.example.androgreenstudwood;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ClientDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "androgreen.db";

    public final String SQL_CREATE = "CREATE TABLE Ville (id INTEGER PRIMARY KEY, nom TEXT);";
    public final String SQL_DELETE = "DROP TABLE IF EXISTS Ville;";

    public ClientDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase  db) {
        db.execSQL(SQL_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion,int newVersion){
        onUpgrade(db,oldVersion,newVersion);
    }
}

