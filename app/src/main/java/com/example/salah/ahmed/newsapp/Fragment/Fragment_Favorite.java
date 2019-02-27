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

import com.example.salah.ahmed.newsapp.Adapter.FavoAdapter;
import com.example.salah.ahmed.newsapp.Adapter.NewsAdapter;
import com.example.salah.ahmed.newsapp.Database.AppDatabase;
import com.example.salah.ahmed.newsapp.Model.DbNews;
import com.example.salah.ahmed.newsapp.R;

import java.util.List;

public class Fragment_Favorite extends Fragment implements NewsAdapter.OnItemClickListener {
    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorite, container, false);

        AppDatabase mDb = AppDatabase.getAppDatabase(getActivity().getApplicationContext());
        List<DbNews> newsList = mDb.newsDao().getAll();
        Log.d("Data", String.valueOf(newsList));
        RecyclerView recyclerView = view.findViewById(R.id.rv_favo);
        FavoAdapter adapter = new FavoAdapter(getActivity().getApplicationContext(), newsList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
//        adapter.setOnItemClickListener(getActivity());

        return view;
    }

    @Override
    public void onItemClick(int position) {

    }


}
