package com.mobileia.news.adapter;

import com.mobileia.news.R;
import com.mobileia.news.view.holder.NewsViewHolder;
import com.mobileia.recyclerview.adapter.BuilderAdapter;

/**
 * Created by matiascamiletti on 1/3/18.
 */

public class NewsAdapter extends BuilderAdapter {
    /**
     * Constructor base
     */
    public NewsAdapter(){
        super(R.layout.item_news, NewsViewHolder.class);
    }
}
