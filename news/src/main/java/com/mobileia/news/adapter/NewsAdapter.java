package com.mobileia.news.adapter;

import android.support.v7.widget.RecyclerView;

import com.mobileia.news.R;
import com.mobileia.news.entity.News;
import com.mobileia.news.view.holder.NewsViewHolder;
import com.mobileia.recyclerview.adapter.BuilderAdapter;
import com.mobileia.recyclerview.holder.BaseViewHolder;

/**
 * Created by matiascamiletti on 1/3/18.
 */

public class NewsAdapter extends BuilderAdapter implements NewsViewHolder.OnClickNewsListener {
    /**
     * Almacena para escuchar el click
     */
    protected NewsViewHolder.OnClickNewsListener mListener;
    /**
     * Constructor base
     */
    public NewsAdapter(){
        super(R.layout.item_news, NewsViewHolder.class);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        ((NewsViewHolder)holder).setOnClickNewsListener(this);
    }

    @Override
    public void onClickNews(News news) {
        if(mListener != null){
            mListener.onClickNews(news);
        }
    }

    /**
     * Configurar el listener para el click
     * @param listener
     */
    public void setOnClickNewsListener(NewsViewHolder.OnClickNewsListener listener){
        mListener = listener;
    }
}
