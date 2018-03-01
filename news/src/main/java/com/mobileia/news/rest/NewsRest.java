package com.mobileia.news.rest;

import com.mobileia.core.rest.RestBody;
import com.mobileia.core.rest.RestBodyCall;
import com.mobileia.core.rest.RestBuilder;
import com.mobileia.news.MobileiaNews;
import com.mobileia.news.entity.News;
import com.mobileia.news.rest.service.NewsService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by matiascamiletti on 1/3/18.
 */

public class NewsRest extends RestBuilder {

    /**
     * Servicio para obtener las noticias disponibles
     * @param callback
     */
    public void fetchAllCurrent(final OnFetchAllComplete callback){
        // Creamos el servicio
        NewsService service = createService(NewsService.class);
        // Generamos la call
        RestBodyCall<ArrayList<News>> call = service.fetchAllCurrent();
        // Ejecutamos call
        call.enqueue(new Callback<RestBody<ArrayList<News>>>() {
            @Override
            public void onResponse(Call<RestBody<ArrayList<News>>> call, Response<RestBody<ArrayList<News>>> response) {
                // Verificar si la respuesta fue incorrecta
                if (!response.isSuccessful() || !response.body().success) {
                    //callback.onError(response.body().error);
                    return;
                }
                // Enviamos las noticias
                callback.onSuccess(response.body().response);
            }

            @Override
            public void onFailure(Call<RestBody<ArrayList<News>>> call, Throwable t) {

            }
        });
    }

    @Override
    public String getBaseUrl() {
        return MobileiaNews.getBaseUrl();
    }

    /**
     * Interface para obtener las noticias
     */
    public interface OnFetchAllComplete{
        void onSuccess(ArrayList<News> news);
    }
}
