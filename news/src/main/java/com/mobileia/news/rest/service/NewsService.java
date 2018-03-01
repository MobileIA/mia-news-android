package com.mobileia.news.rest.service;

import com.mobileia.core.rest.RestBodyCall;
import com.mobileia.news.entity.News;

import java.util.ArrayList;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by matiascamiletti on 1/3/18.
 */

public interface NewsService {

    @FormUrlEncoded
    @POST("api/news/list")
    RestBodyCall<ArrayList<News>> fetchAllCurrent();

}
