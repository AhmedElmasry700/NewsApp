package com.example.salah.ahmed.newsapp.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

public class CountryActivity extends AppCompatActivity {

    private static final String KEY = "78a580d5307f465fba38fe641d47092f";
    private List<Article> articlesList = new ArrayList<>();
    private static final String INTENT_KEY_country = "country";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        Intent intent = getIntent();
        String country = intent.getStringExtra(INTENT_KEY_country);
        Log.v("intent", country);


        JsonParse service = RetrofitClient.getRetrofit().create(JsonParse.class);
        Call<News> call = service.getCountry(country, KEY);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(@NonNull Call<News> call, @NonNull Response<News> response) {


                articlesList = response.body().getArticles();

                generatecountryList(articlesList);

            }

            @Override
            public void onFailure(@NonNull Call<News> call, @NonNull Throwable t) {
            }
        });
    }
    private void generatecountryList(List<Article> articallist ) {
        RecyclerView recyclerView = findViewById(R.id.rv_country);
        NewsAdapter adapter = new NewsAdapter(CountryActivity.this, articallist);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
//        adapter.setOnItemClickListener(getActivity());
    }
}
