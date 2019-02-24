package com.example.salah.ahmed.newsapp.Activites;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.salah.ahmed.newsapp.Database.AppDatabase;
import com.example.salah.ahmed.newsapp.Model.DbNews;
import com.example.salah.ahmed.newsapp.Widget.NewAppWidget;
import com.example.salah.ahmed.newsapp.R;

import java.util.List;

import static com.example.salah.ahmed.newsapp.Activites.NewsActivity.EXTRA_DESCRIPTION;
import static com.example.salah.ahmed.newsapp.Activites.NewsActivity.EXTRA_IMG;
import static com.example.salah.ahmed.newsapp.Activites.NewsActivity.EXTRA_TITLE;
import static com.example.salah.ahmed.newsapp.Activites.NewsActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {
    private static final String KEY_TITLE_PREFERENCES = "widget_title";
    ImageView poster_img;
    TextView title_tv, publishBy_tv;
    WebView webView;

    String title, imgPoster, url, description;
    FloatingActionButton fab;
//    boolean boolfavo = false;


    //    private DbNews dbNews;
    private AppDatabase mDb;
//    private List<DbNews> mFavoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        poster_img = findViewById(R.id.detail_img);
        title_tv = findViewById(R.id.detail_title);
        publishBy_tv = findViewById(R.id.detail_publishBy);
        webView = findViewById(R.id.webView);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        imgPoster = intent.getStringExtra(EXTRA_IMG);
        Glide.with(this)
                .load(imgPoster)
                .centerCrop()
//                .placeholder(R.drawable.loading_spinner)
                .into(poster_img);

        title = intent.getStringExtra(EXTRA_TITLE);
        title_tv.setText(title);

        url = intent.getStringExtra(EXTRA_URL);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        description = intent.getStringExtra(EXTRA_DESCRIPTION);

        mDb = AppDatabase.getAppDatabase(getApplicationContext());

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbNews dbNews = new DbNews();
                dbNews.setDb_newsPster(imgPoster);
                dbNews.setDb_newsTitle(title);
                dbNews.setDb_newsUrl(url);
                mDb.newsDao().insertAll(dbNews);
                Log.d("test", String.valueOf(dbNews.getDb_newsPster()));
            }
        });

        DataToWidget();

    }


    public void DataToWidget() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append("\n\n").append(description);
        SharedPreferences pre = this.getSharedPreferences(KEY_TITLE_PREFERENCES, 0);
        SharedPreferences.Editor ed = pre.edit();
        ed.putString("news_title_description", sb.toString());

        ed.apply();

        int[] ids = AppWidgetManager.getInstance(this).getAppWidgetIds(new ComponentName(this, NewAppWidget.class));
        NewAppWidget myWidget = new NewAppWidget();
        myWidget.onUpdate(this, AppWidgetManager.getInstance(this), ids);
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }


//    private boolean checkid() {
//
//        if (!appDatabase.newsDao().getNewsWithId(id)) {
//            fab.setBackgroundResource(R.drawable.ic_favorite_border_white_24dp);
//
//            return true;
//        } else  {
//
//            fab.setBackgroundResource(R.drawable.ic_favorite_white_24dp);
//            return false;
//        }
//    }



}
