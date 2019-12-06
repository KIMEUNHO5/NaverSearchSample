package com.gahee.naversearchsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.NewsViewHolder> {

    Context context;
    List<NewsModel> newsModelList;
    MyRvAdapter(Context context, List<NewsModel> newsModelsList){
        this.context = context;
        this.newsModelList = newsModelsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_view_holder, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsModel newsModel = newsModelList.get(position);
        holder.newsTitle.setText(newsModel.getTitle());
        holder.newsPubDate.setText(newsModel.getPubDate());
        holder.newsDescription.setText(newsModel.getDescription());
    }

    @Override
    public int getItemCount() {
        return newsModelList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView newsTitle;
        TextView newsPubDate;
        TextView newsDescription;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.tv_news_title);
            newsPubDate = itemView.findViewById(R.id.tv_news_pub_date);
            newsDescription = itemView.findViewById(R.id.tv_news_description);
        }
    }
}
