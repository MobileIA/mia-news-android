package com.mobileia.news.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.mobileia.news.adapter.NewsAdapter;
import com.mobileia.news.entity.News;
import com.mobileia.news.rest.NewsRest;
import com.mobileia.news.view.holder.NewsViewHolder;
import com.mobileia.recyclerview.MobileiaRecyclerView;

import java.util.ArrayList;

/**
 * Created by matiascamiletti on 1/3/18.
 */

abstract public class BaseNewsActivity extends AppCompatActivity implements NewsViewHolder.OnClickNewsListener {

    /**
     * Almacena la vista del listado
     */
    protected MobileiaRecyclerView mRecyclerView;
    /**
     * Almacena el adapter de las noticias
     */
    protected NewsAdapter mAdapter;

    @Override
    protected void onResume() {
        super.onResume();
        // Verificamos si ya se inicio la vista
        if(mRecyclerView == null){
            setUpViews();
        }
    }

    /**
     * Funcion que se encarga de llamar al servidor en busca de las noticias
     */
    protected void fetchNews(){
        // Iniciamos el loading
        mRecyclerView.startLoading();
        // Llamar al servidor
        new NewsRest().fetchAllCurrent(new NewsRest.OnFetchAllComplete() {
            @Override
            public void onSuccess(ArrayList<News> news) {
                // Asignamos las noticias al adapter
                mAdapter.addAll(news);
                // Paramos el loading
                mRecyclerView.stopLoading();
            }
        });
    }

    /**
     * Funcion que se encarga de inicializar la vista
     */
    protected void setUpViews(){
        // Obtenemos vista del listado
        mRecyclerView = findRecyclerView();
        // Seteamos el layout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Creamos adapter
        mAdapter = new NewsAdapter();
        // Asignamos el adapter
        mRecyclerView.setAdapter(mAdapter);
        // Seteamos click en las noticias
        mAdapter.setOnClickNewsListener(this);
        // Inicamos proceso para buscar las trivias
        fetchNews();
    }

    /**
     * Metodo para obtener el listado desde al vista
     * @return
     */
    abstract protected MobileiaRecyclerView findRecyclerView();
}
