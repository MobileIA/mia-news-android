package com.mobileia.news.view.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mobileia.news.R;
import com.mobileia.news.entity.News;
import com.mobileia.recyclerview.holder.BaseViewHolder;

/**
 * Created by matiascamiletti on 1/3/18.
 */

public class NewsViewHolder extends BaseViewHolder<News> implements View.OnClickListener {

    /**
     * Almacena la noticia que se esta viendo
     */
    protected News mNews;
    /**
     * Vista del titulo
     */
    public final TextView titleView;
    public final ImageView imageView;
    public final TextView captionView;
    /**
     * Almacena para escuchar el click
     */
    protected OnClickNewsListener mListener;

    /**
     * Constructor base
     *
     * @param itemView
     */
    public NewsViewHolder(View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.text_title);
        imageView = itemView.findViewById(R.id.image);
        captionView = itemView.findViewById(R.id.text_caption);
    }

    @Override
    public void bind(News object) {
        // Guardamos la noticia
        mNews = object;
        // Cargamos el titulo
        titleView.setText(object.title);
        // Cargamos texto
        captionView.setText(object.caption);
        // Verificamos si tiene foto
        if(object.photo != null && object.photo.length() > 0){
            Glide.with(imageView).load(object.photo).into(imageView);
        }else{
            imageView.setImageResource(R.drawable.placeholder);
        }
    }

    /**
     * Funcion que se ejecuta al hacer click en una noticia
     * @param view
     */
    @Override
    public void onClick(View view) {
        if(mListener != null){
            mListener.onClickNews(mNews);
        }
    }

    /**
     * Configurar el listener para el click
     * @param listener
     */
    public void setOnClickNewsListener(OnClickNewsListener listener){
        mListener = listener;
    }

    /**
     * Interfaz para escuchar el click en las noticias
     */
    public interface OnClickNewsListener{
        void onClickNews(News news);
    }
}
