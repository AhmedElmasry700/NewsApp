package com.example.salah.ahmed.newsapp.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "dbNews")
public class DbNews {
    private String db_newsPster;
    private String db_newsTitle;
    private String db_newsUrl;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int db_id;

    public DbNews(String db_newsPster, String db_newsTitle, String db_newsUrl) {
        this.db_newsPster = db_newsPster;
        this.db_newsTitle = db_newsTitle;
        this.db_newsUrl = db_newsUrl;
    }

    public String getDb_newsPster() {
        return db_newsPster;
    }

    public void setDb_newsPster(String db_newsPster) {
        this.db_newsPster = db_newsPster;
    }

    public String getDb_newsTitle() {
        return db_newsTitle;
    }

    public void setDb_newsTitle(String db_newsTitle) {
        this.db_newsTitle = db_newsTitle;
    }

    public String getDb_newsUrl() {
        return db_newsUrl;
    }

    public void setDb_newsUrl(String db_newsUrl) {
        this.db_newsUrl = db_newsUrl;
    }

    @NonNull
    public int getDb_id() {
        return db_id;
    }

    public void setDb_id(@NonNull int db_id) {
        this.db_id = db_id;
    }


}
