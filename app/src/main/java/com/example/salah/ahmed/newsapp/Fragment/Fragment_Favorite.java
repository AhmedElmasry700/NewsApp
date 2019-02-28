package com.example.salah.ahmed.newsapp.Fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.salah.ahmed.newsapp.Adapter.FavoAdapter;
import com.example.salah.ahmed.newsapp.Adapter.NewsAdapter;
import com.example.salah.ahmed.newsapp.Model.DbNews;
import com.example.salah.ahmed.newsapp.R;
import com.example.salah.ahmed.newsapp.ViewModel.NewsListModelView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Favorite extends Fragment implements NewsAdapter.OnItemClickListener {
    private View view;

    private NewsListModelView viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorite, container, false);


        RecyclerView recyclerView = view.findViewById(R.id.rv_favo);
        final FavoAdapter adapter = new FavoAdapter(getActivity().getApplicationContext(), new ArrayList<DbNews>());
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
//        adapter.setOnItemClickListener(getActivity());

        viewModel = ViewModelProviders.of(this).get(NewsListModelView.class);

        viewModel.getItemNewsList().observe(getActivity(), new Observer<List<DbNews>>() {
            @Override
            public void onChanged(@Nullable List<DbNews> itemAndPeople) {
                adapter.addItems(itemAndPeople);
            }
        });

        return view;
    }


    @Override
    public void onItemClick(int position) {
//        DbNews dbNews = (DbNews) v.getTag();
//        viewModel.deleteItem(borrowModel);
    }

}
