package com.gahee.naversearchsample;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.gahee.naversearchsample.Auth.CLIENT_ID;
import static com.gahee.naversearchsample.Auth.CLIENT_SECRET;

public interface NewsService {

    @Headers({"X-Naver-Client-id: " + CLIENT_ID,
    "X-Naver-Client-Secret: " + CLIENT_SECRET})
    @GET("search/news.json")
    Call<NewsItemsModel> getNews(@Query("query") String query, @Query("display") int display, @Query("start") int start, @Query("sort") String sort);

}
