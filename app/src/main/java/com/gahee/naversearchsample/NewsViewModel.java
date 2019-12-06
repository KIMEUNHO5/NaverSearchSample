package com.gahee.naversearchsample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsViewModel extends ViewModel {

    MutableLiveData<NewsItemsModel> newsItemsLive = new MutableLiveData<>();
    private Repo repo;

    public NewsViewModel(){
        repo = Repo.getInstance();
    }

    public MutableLiveData<NewsItemsModel> getNewsItemsLive() {
        newsItemsLive = repo.getNewsItemsModelMutableLiveData();
        return newsItemsLive;
    }

    public void fetchNews(String q, int d, int s, String st){
        repo.executeNewsAsync(q, d, s, st);
    }

}
