package com.example.petagram;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        SwipeRefreshLayout SwiperRF;
        ListView listV;
        Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agragarFab();
        // boton de refrescar cuando se busca actualizar la app
        SwiperRF = (SwipeRefreshLayout) findViewById(R.id.SwipeRF);
        // inicializa la lista que se ha creado.
        listV = (ListView) findViewById(R.id.listV);
        // se unicializa la nueva variable o array con las lista ya creada en string.
        String[] planetas = getResources().getStringArray(R.array.Planetas);
        // se implenta el array dentro de la lista
        listV.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        // se pone un excuchador del evento refrescar
        SwiperRF.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
    }

    public void refrescandoContenido(){
        // se unicializa la nueva variable o array con las lista ya creada en string.
        String[] planetas = getResources().getStringArray(R.array.Planetas);
        // se implenta el array dentro de la lista
        listV.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        SwiperRF.setRefreshing(false);
    }
    public void agragarFab(){
        FloatingActionButton miFab = (FloatingActionButton) findViewById(R.id.miFab);
        miFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // genera un mensaje emergente que se oculta rapido
               // Toast.makeText(getBaseContext(),getResources().getString(R.string.app_mensajeFab), Toast.LENGTH_SHORT).show();
                Snackbar.make(v, getResources().getString(R.string.app_mensajeFab), Snackbar.LENGTH_SHORT)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                    Log.i("SNACKBAR","mensajeSnackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }
}