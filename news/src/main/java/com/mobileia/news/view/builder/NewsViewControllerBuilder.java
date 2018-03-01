package com.mobileia.news.view.builder;

import com.mobileia.news.R;
import com.mobileia.news.view.controller.NewsViewController;
import com.mobileia.recyclerview.controller.ViewControllerBuilder;

/**
 * Created by matiascamiletti on 1/3/18.
 */

public class NewsViewControllerBuilder extends ViewControllerBuilder {

    public NewsViewControllerBuilder(){
        mLayoutView = R.layout.item_news;
        mViewController = NewsViewController.class;
    }
}
