package com.example.prjcruddreco;
import android.content.ContentValues;
import android.content.Context;

public class DbAmigosDAO {
    private final String TABLE_AMIGOS = "Amigos";
    private DbAmigosGateway gateway;

    public DbAmigosDAO(Context context) {
        this.gateway = DbAmigosGateway.getInstance(context);
    }

    public boolean salvar(String nome, String celular, int status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nome", nome);
        contentValues.put("Celular", "Celular");

        return gateway.getDatabase().insert(TABLE_AMIGOS, null, contentValues) > 0;
    }
}
