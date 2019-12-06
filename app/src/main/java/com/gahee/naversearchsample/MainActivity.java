package com.gahee.naversearchsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private NewsViewModel newsViewModel;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_bar);

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                newsViewModel.fetchNews(s, 30, 1, "date");

                newsViewModel.getNewsItemsLive().observe(MainActivity.this, new Observer<NewsItemsModel>() {
                    @Override
                    public void onChanged(NewsItemsModel newsItemsModel) {
                        recyclerView = findViewById(R.id.rv_main);
                        adapter = new MyRvAdapter(MainActivity.this, newsItemsModel.getItems());

                        recyclerView.setAdapter(adapter);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    }
                });
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });




    }

}


