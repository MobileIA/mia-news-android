package com.mobileia.news.view.controller;

import android.view.View;

import com.mobileia.news.entity.News;
import com.mobileia.news.view.holder.NewsViewHolder;
import com.mobileia.recyclerview.controller.BaseViewController;

/**
 * Created by matiascamiletti on 1/3/18.
 */

public class NewsViewController extends BaseViewController {
    /**
     * Constructor
     *
     * @param view
     */
    public NewsViewController(View view) {
        super(view);
        // Crear ViewHolder
        mViewHolder = new NewsViewHolder(view);
    }

    /**
     * Setea la noticia a mostrar
     * @param news
     */
    public void bind(News news){
        mViewHolder.bind(news);
    }

    /**
     * Setear el listener para el click
     * @param listener
     */
    public void setOnClickNewsListener(NewsViewHolder.OnClickNewsListener listener){
        ((NewsViewHolder)mViewHolder).setOnClickNewsListener(listener);
    }
}
