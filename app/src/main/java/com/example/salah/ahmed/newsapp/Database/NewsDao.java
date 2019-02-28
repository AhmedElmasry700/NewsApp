package com.example.salah.ahmed.newsapp.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.salah.ahmed.newsapp.Model.DbNews;

import java.util.List;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM dbnews")
    LiveData<List<DbNews>> getAll();

    @Query("select * from dbnews where db_id = :id")
    DbNews getNewsbyId(String id);

    @Insert
    void insertAll(DbNews... dbNewss);

    @Delete
    void deleteNews(DbNews dbNews);
}
