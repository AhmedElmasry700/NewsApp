package com.example.salah.ahmed.newsapp.Activites;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.SearchManager;
import android.support.v7.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Switch;
import android.view.MenuInflater;

import android.content.Context;
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

public class SearchActivity extends AppCompatActivity {

    private static final String KEY = "78a580d5307f465fba38fe641d47092f";
    private List<Article> articlesList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private NewsAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



    }

    public void loadJson(String keyWord) {

        JsonParse service = RetrofitClient.getRetrofit().create(JsonParse.class);
        Call<News> call = service.getNewsSearch(keyWord, "publishedAt", KEY);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(@NonNull Call<News> call, @NonNull Response<News> response) {
                if (!articlesList.isEmpty()){
                    articlesList.clear();
                }
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



//        recyclerView.setHasFixedSize(true);
//        linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView = findViewById(R.id.rv_country);

        linearLayoutManager = new LinearLayoutManager(SearchActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new NewsAdapter(SearchActivity.this, articlesList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
//        adapter.setOnItemClickListener(getActivity());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        MenuItem searchMenuitem = menu.findItem(R.id.action_search);

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search Lasted News...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 2) {
                    loadJson(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newsText) {
                loadJson(newsText);
                return false;
            }
        });
        searchMenuitem.getIcon().setVisible(false,false);

        return true;
    }
}
