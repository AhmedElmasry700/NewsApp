package com.example.salah.ahmed.newsapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.salah.ahmed.newsapp.Database.AppDatabase;
import com.example.salah.ahmed.newsapp.Model.DbNews;

import java.util.List;

public class NewsListModelView extends AndroidViewModel {

    private final LiveData<List<DbNews>> itemAndPersonList;
    private AppDatabase appDatabase;


    public NewsListModelView(@NonNull Application application) {
        super(application);

        appDatabase = AppDatabase.getAppDatabase(this.getApplication());

        itemAndPersonList = appDatabase.newsDao().getAll();
    }

    public LiveData<List<DbNews>> getItemNewsList() {
        return itemAndPersonList;
    }

    public void deleteItem(DbNews borrowModel) {
        new deleteAsyncTask(appDatabase).execute(borrowModel);
    }

    private static class deleteAsyncTask extends AsyncTask<DbNews, Void, Void> {

        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final DbNews... params) {
            db.newsDao().deleteNews(params[0]);
            return null;
        }

    }
}
