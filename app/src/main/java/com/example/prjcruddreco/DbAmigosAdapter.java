package com.example.prjcruddreco;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DbAmigosAdapter extends RecyclerView.Adapter<DbAmigosHolder> {

    private final List<DbAmigo> amigos;

    public DbAmigosAdapter(List<DbAmigo> amigos) {
        this.amigos = amigos;
    }

    @Override
    public DbAmigosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DbAmigosHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_dados_amigo, parent, false));
    }

    @Override
    public void onBindViewHolder(DbAmigosHolder holder, int position) {
        holder.nmAmigo.setText(amigos.get(position).getNome());
        holder.vlCelular.setText(amigos.get(position).getCelular());
    }

    @Override
    public int getItemCount() {
        return amigos != null ? amigos.size() : 0;
    }



}
