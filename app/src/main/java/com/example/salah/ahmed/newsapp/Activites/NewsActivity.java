package com.example.salah.ahmed.newsapp.Activites;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.salah.ahmed.newsapp.API.JsonParse;
import com.example.salah.ahmed.newsapp.API.RetrofitClient;
import com.example.salah.ahmed.newsapp.Adapter.NewsAdapter;
import com.example.salah.ahmed.newsapp.Model.Article;
import com.example.salah.ahmed.newsapp.Model.News;
import com.example.salah.ahmed.newsapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    private static final String KEY = "78a580d5307f465fba38fe641d47092f";
    private List<Article> articlesList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private NewsAdapter adapter;
    private static final String INTENT_KEY = "site";
    private String site;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Intent intent = getIntent();
        site = intent.getStringExtra(INTENT_KEY);
        Log.v("intent", site);


        JsonParse service = RetrofitClient.getRetrofit().create(JsonParse.class);
        Call<News> call = service.getSites(site, KEY);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(@NonNull Call<News> call, @NonNull Response<News> response) {
                articlesList = response.body().getArticles();
                generateRvList(articlesList);
                Log.v("3aaaa", String.valueOf(articlesList));
//                Toast.makeText(NewsActivity.this, "ولا يامحمد يامحرووس يلااا", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<News> call, @NonNull Throwable t) {
//                Toast.makeText(NewsActivity.this, "لااااااااااااا", Toast.LENGTH_SHORT).show();
                Log.v("nooooooo", String.valueOf(t));

            }
        });
    }

    private void generateRvList(List<Article> articallist) {
        RecyclerView recyclerView = findViewById(R.id.rv_aljazeera);
        adapter = new NewsAdapter(NewsActivity.this, articallist);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
//        adapter.setOnItemClickListener(getActivity());
    }
}
