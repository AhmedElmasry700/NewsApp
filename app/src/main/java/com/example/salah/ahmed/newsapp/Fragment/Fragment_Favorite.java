package com.example.salah.ahmed.newsapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.salah.ahmed.newsapp.Activites.NewsActivity;
import com.example.salah.ahmed.newsapp.Adapter.FavoAdapter;
import com.example.salah.ahmed.newsapp.Adapter.NewsAdapter;
import com.example.salah.ahmed.newsapp.Database.AppDatabase;
import com.example.salah.ahmed.newsapp.Database.NewsDao;
import com.example.salah.ahmed.newsapp.Model.DbNews;
import com.example.salah.ahmed.newsapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Favorite extends Fragment implements NewsAdapter.OnItemClickListener {
    View view;
    private List<DbNews> newsList;
    private LinearLayoutManager linearLayoutManager;
    private FavoAdapter adapter;
    private AppDatabase mDb;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorite, container, false);

        mDb = AppDatabase.getAppDatabase(getActivity().getApplicationContext());
        newsList = mDb.newsDao().getAll();
        Log.d("Data", String.valueOf(newsList));
        RecyclerView recyclerView = view.findViewById(R.id.rv_favo);
        adapter = new FavoAdapter(getActivity().getApplicationContext(), newsList);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
//        adapter.setOnItemClickListener(getActivity());

        return view;
    }

    @Override
    public void onItemClick(int position) {

    }


}
