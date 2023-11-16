package com.example.prjcruddreco;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbAmigosGateway {
    private static DbAmigosGateway gateway;
    private final SQLiteDatabase db;
    private DbAmigosGateway(Context context) {
        DbAmigosHelper helper = new DbAmigosHelper(context);
        this.db = helper.getWritableDatabase();
    }

    public static DbAmigosGateway getInstance(Context context) {
        if (gateway == null) {
            gateway = new DbAmigosGateway(context);
        }
        return gateway;
    }

    public SQLiteDatabase getDatabase() {
        return this.db;
    }
}
