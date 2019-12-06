package com.gahee.naversearchsample;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repo {
    private static final String TAG = "Repo";

    private static Repo instance;

    public static Repo getInstance() {
        if(instance == null){
            instance = new Repo();
        }
        return instance;
    }

    private MutableLiveData<NewsItemsModel> newsItemsModelMutableLiveData
    = new MutableLiveData<>();

    private void getData(String query, int display, int start, String sort){
        final Call<NewsItemsModel>
        newsItemsModelCall = RetrofitInstanceBuilder
                .getNewsService()
                .getNews(query, display, start, sort);

        Log.d(TAG, "getData: " + newsItemsModelCall.request().url());

        Callback<NewsItemsModel> callback = new Callback<NewsItemsModel>() {
            @Override
            public void onResponse(Call<NewsItemsModel> call, Response<NewsItemsModel> response) {

                newsItemsModelMutableLiveData.setValue(response.body());

                Log.d(TAG, "onResponse: " + response.code() + " , " + response.message());
                Log.d(TAG, "onResponse: " + response.body());

                List<NewsModel> newsModelList= response.body().getItems();
                for(int i = 0; i < newsModelList.size(); i++){

                    Log.d(TAG, "Title : " + newsModelList.get(i).getTitle() + "\n" +
                            "Description : " + newsModelList.get(i).getDescription() + "\n" +
                            "Publish Date : " + newsModelList.get(i).getPubDate() + "\n\n" + "====");
                }
            }

            @Override
            public void onFailure(Call<NewsItemsModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        };

        newsItemsModelCall.enqueue(callback);
    }

    public void executeNewsAsync(String q, int d, int s, String st){
        new NewsAsync(q, d, s, st).execute();
    }

    class NewsAsync extends AsyncTask<Void, Void, Void>{
        private String query;
        private int display;
        private int start;
        private String sort;

        NewsAsync(String q, int d, int s, String sort){
            query = q;
            display = d;
            start = s;
            this.sort = sort;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            getData(query, display, start, sort);
            return null;
        }
    }

    public MutableLiveData<NewsItemsModel> getNewsItemsModelMutableLiveData() {
        return newsItemsModelMutableLiveData;
    }
}
