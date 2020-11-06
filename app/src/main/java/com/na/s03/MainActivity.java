package com.na.s03;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.na.s03.modelo.DAOMarcador;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView menuBotones;
    DAOMarcador daoMarcador = new DAOMarcador(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        asignarReferencias();
        daoMarcador.openDB();
    }

    private void asignarReferencias() {
        abrirFragmento(new fragmento_listar_marcador());
        menuBotones = findViewById(R.id.botonNavegacion);
        menuBotones.setItemIconTintList(null);
        menuBotones.getMenu().setGroupCheckable(0, false, true);
        MenuItem item = menuBotones.getMenu().findItem(R.id.lista_menu);
        item.setIcon(R.drawable.ic_baseline_format_list_numbered_24_true);
        menuBotones.getMenu().setGroupCheckable(0, true, true);
        item.setChecked(true);
        menuBotones.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.lista_menu){
                    //Toast.makeText(MainActivity.this, "Seleccionaste Opción 1", Toast.LENGTH_SHORT).show();
                    menuBotones.setItemIconTintList(null);

                    item.setChecked(true);
                    item.setIcon(R.drawable.ic_baseline_format_list_numbered_24_true);
                    abrirFragmento(new fragmento_listar_marcador());
                }
                if (item.getItemId() == R.id.add_menu){
                    //Toast.makeText(MainActivity.this, "Seleccionaste Opción 2", Toast.LENGTH_SHORT).show();
                    menuBotones.setItemIconTintList(null);
                    item.setChecked(true);
                    item.setIcon(R.drawable.ic_baseline_add_24_true);
                    abrirFragmento(new fragmento_add_marcador());
                }
                if (item.getItemId() == R.id.menu_3){
                    //Toast.makeText(MainActivity.this, "Seleccionaste Opción 3", Toast.LENGTH_SHORT).show();
                    abrirFragmento(new fragmento_modify_marcador());
                }
                return false;
            }
        });
    }

    private void abrirFragmento(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }

}