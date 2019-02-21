package com.example.salah.ahmed.newsapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.salah.ahmed.newsapp.API.JsonParse;
import com.example.salah.ahmed.newsapp.API.RetrofitClient;
import com.example.salah.ahmed.newsapp.Activites.NewsActivity;
import com.example.salah.ahmed.newsapp.Adapter.NewsAdapter;
import com.example.salah.ahmed.newsapp.Model.Article;
import com.example.salah.ahmed.newsapp.Model.News;
import com.example.salah.ahmed.newsapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Home extends Fragment {
    View view;
    CardView aljazeera, bbc, cnn, daily_mail, google, huffpost, rt, the_independent, the_new_york, time;
    private Intent intent;

    private static final String INTENT_KEY = "site";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        aljazeera = view.findViewById(R.id.cv_aljazeera);
        aljazeera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), NewsActivity.class);
                intent.putExtra(INTENT_KEY, "al-jazeera-english");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        bbc = view.findViewById(R.id.cv_bbc);
        bbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), NewsActivity.class);
                intent.putExtra(INTENT_KEY, "bbc-news");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        cnn = view.findViewById(R.id.cv_cnn);
        cnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), NewsActivity.class);
                intent.putExtra(INTENT_KEY, "cnn");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        daily_mail = view.findViewById(R.id.cv_daily);
        daily_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), NewsActivity.class);
                intent.putExtra(INTENT_KEY, "daily-mail");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        google = view.findViewById(R.id.cv_google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), NewsActivity.class);
                intent.putExtra(INTENT_KEY, "google-news");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        huffpost = view.findViewById(R.id.cv_huffpost);
        huffpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), NewsActivity.class);
                intent.putExtra(INTENT_KEY, "the-huffington-post");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        rt = view.findViewById(R.id.cv_rt);
        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), NewsActivity.class);
                intent.putExtra(INTENT_KEY, "rt");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        the_independent = view.findViewById(R.id.cv_independent);
        the_independent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), NewsActivity.class);
                intent.putExtra(INTENT_KEY, "independent");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        the_new_york = view.findViewById(R.id.cv_new_york_times);
        the_new_york.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), NewsActivity.class);
                intent.putExtra(INTENT_KEY, "the-new-york-times");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        time = view.findViewById(R.id.cv_time);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), NewsActivity.class);
                intent.putExtra(INTENT_KEY, "time");
                startActivity(intent);
            }
        });


        return view;
    }


}
