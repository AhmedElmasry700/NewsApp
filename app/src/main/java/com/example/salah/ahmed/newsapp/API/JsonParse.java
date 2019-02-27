package com.example.salah.ahmed.newsapp.API;

import com.example.salah.ahmed.newsapp.Model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonParse {


    @GET("top-headlines")
    Call<News> getSites(
            @Query("sources") String source,
            @Query("apiKey") String key
    );

    @GET("top-headlines")
    Call<News> getCountry(
            @Query("country") String country,
            @Query("apiKey") String key
    );

    @GET("everything")
    Call<News> getNewsSearch(

            @Query("q") String keyword,
//            @Query("language") String language,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String key
    );

}
