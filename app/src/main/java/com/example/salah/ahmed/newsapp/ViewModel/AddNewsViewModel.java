package com.example.salah.ahmed.newsapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.salah.ahmed.newsapp.Database.AppDatabase;
import com.example.salah.ahmed.newsapp.Model.DbNews;

public class AddNewsViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddNewsViewModel(@NonNull Application application) {
        super(application);

        appDatabase = AppDatabase.getAppDatabase(this.getApplication());

    }

    public void addBorrow(final DbNews dbNews) {
        new addAsyncTask(appDatabase).execute(dbNews);
    }

    private static class addAsyncTask extends AsyncTask<DbNews, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final DbNews... params) {
            db.newsDao().insertAll(params[0]);
            return null;
        }

    }
}
