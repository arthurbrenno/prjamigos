package com.example.prjcruddreco;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prjcruddreco.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    RecyclerView recyclerView;
    DbAmigosAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            findViewById(R.id.include_listagem).setVisibility(View.INVISIBLE);
            findViewById(R.id.include_cadastro).setVisibility(View.VISIBLE);
            findViewById(R.id.fab).setVisibility(View.INVISIBLE);
        });

        Button btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(view -> {
            Snackbar.make(view, "Cancelando...", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            findViewById(R.id.include_listagem).setVisibility(View.VISIBLE);
            findViewById(R.id.include_cadastro).setVisibility(View.INVISIBLE);
            findViewById(R.id.fab).setVisibility(View.VISIBLE);
        });

        Button btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(view -> {
            Snackbar.make(view, "Salvando...", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            findViewById(R.id.include_listagem).setVisibility(View.VISIBLE);
            findViewById(R.id.include_cadastro).setVisibility(View.INVISIBLE);
            findViewById(R.id.fab).setVisibility(View.VISIBLE);
        });

        configurarRecycler();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void configurarRecycler() {
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DbAmigosDAO dao = new DbAmigosDAO(this);
        adapter = new DbAmigosAdapter(dao.listarAmigos());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}