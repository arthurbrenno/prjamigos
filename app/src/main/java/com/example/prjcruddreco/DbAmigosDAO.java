package com.example.prjcruddreco;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class DbAmigosDAO {
    private final String TABLE_AMIGOS = "Amigos";
    private DbAmigosGateway gateway;

    public DbAmigosDAO(Context context) {
        this.gateway = DbAmigosGateway.getInstance(context);
    }

    public boolean salvar(String nome, String celular, int status) {
        return salvar(0, nome, celular, status);
    }

    public boolean salvar(int id, String nome, String celular, int status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nome", nome);
        contentValues.put("Celular", celular);
        contentValues.put("Status", status);

        if (id > 0) {
            return this.gateway.getDatabase().update(TABLE_AMIGOS, contentValues, "ID=?", new String[]{ id + "" }) > 0;
        }
        return this.gateway.getDatabase().insert(TABLE_AMIGOS, null, contentValues) > 0;
    }

    public List<DbAmigo> listarAmigos(){
        List<DbAmigo> amigos = new ArrayList<>();
        Cursor cursor = this.gateway.getDatabase().rawQuery("SELECT * FROM Amigos", null);

        while (cursor.moveToNext())
        {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("ID"));
            @SuppressLint("Range") String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            @SuppressLint("Range") String celular = cursor.getString(cursor.getColumnIndex("Celular"));
            @SuppressLint("Range") int situacao = cursor.getInt(cursor.getColumnIndex("Status"));
            amigos.add(new DbAmigo(id, nome, celular, situacao));
        }
        cursor.close();
        return amigos;
    }

    public DbAmigo ultimoAmigo() {
        Cursor cursor = this.gateway.getDatabase().rawQuery("SELECT * FROM Amigos ORDER BY ID DESC", null);
        if(cursor.moveToFirst()) {
            @SuppressLint("Range")
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            @SuppressLint("Range")
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            @SuppressLint("Range")
            String celular = cursor.getString(cursor.getColumnIndex("Celular"));
            @SuppressLint("Range")
            int status = cursor.getInt(cursor.getColumnIndex("Status"));
            cursor.close();
            return new DbAmigo(id, nome, celular, status);
        }
        return null;

    }

    public void inserirAmigo(DbAmigo amigo) {
        listarAmigos().add(amigo);
        //notifyItemInserted(getItemCount());
    }

}
