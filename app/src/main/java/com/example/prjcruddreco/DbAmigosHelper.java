package com.example.prjcruddreco;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAmigosHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Amigos.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE = "CREATE TABLE Amigos(" +
                                                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                "Nome TEXT NOT NULL," +
                                                "CELULAR TEXT NOT NULL," +
                                                "STATUS INTEGET NOT NULL" +
                                                ");";

    public DbAmigosHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        return;
    }

}
