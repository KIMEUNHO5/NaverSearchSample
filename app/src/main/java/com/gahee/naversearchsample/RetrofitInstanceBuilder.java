package com.gahee.naversearchsample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceBuilder {

    public static final String BASE_URL = "https://openapi.naver.com/v1/";

    private static Retrofit retrofit
            = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final NewsService NEWS_SERVICE
            = retrofit.create(NewsService.class);

    public static NewsService getNewsService() {
        return NEWS_SERVICE;
    }
}
