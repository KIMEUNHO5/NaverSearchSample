package com.gahee.naversearchsample;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

//Class Auth will not be added to github repository.
import static com.gahee.naversearchsample.Auth.CLIENT_ID;
import static com.gahee.naversearchsample.Auth.CLIENT_SECRET;

public interface NewsService {

    /*
    <API 리퀘스트 결과 받아오기>
    https://developers.naver.com/docs/search/news/
    -> 오픈 API 이용 신청 Click
    -> Client Id, Client Secret 키 발급 후 아래의 String 값 대체해야함.
     */

    @Headers({"X-Naver-Client-id: " + CLIENT_ID,
    "X-Naver-Client-Secret: " + CLIENT_SECRET})
    @GET("search/news.json")
    Call<NewsItemsModel> getNews(@Query("query") String query, @Query("display") int display, @Query("start") int start, @Query("sort") String sort);

}
