package com.example.salah.ahmed.newsapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.salah.ahmed.newsapp.Activites.CountryActivity;
import com.example.salah.ahmed.newsapp.R;

public class Fragment_Public extends Fragment {

    CardView ae, de, eg, fr, gb, ru, tr, us;
    private Intent intent;
    View view;
    private static final String INTENT_KEY_country = "country";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_public,container,false);

        ae = view.findViewById(R.id.cv_ae);
        ae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), CountryActivity.class);
                intent.putExtra(INTENT_KEY_country, "ae");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        de = view.findViewById(R.id.cv_de);
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), CountryActivity.class);
                intent.putExtra(INTENT_KEY_country, "de");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        eg = view.findViewById(R.id.cv_eg);
        eg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), CountryActivity.class);
                intent.putExtra(INTENT_KEY_country, "eg");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        fr = view.findViewById(R.id.cv_fr);
        fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), CountryActivity.class);
                intent.putExtra(INTENT_KEY_country, "fr");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        gb = view.findViewById(R.id.cv_gb);
        gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), CountryActivity.class);
                intent.putExtra(INTENT_KEY_country, "gb");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        ru = view.findViewById(R.id.cv_ru);
        ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), CountryActivity.class);
                intent.putExtra(INTENT_KEY_country, "ru");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        tr = view.findViewById(R.id.cv_tr);
        tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), CountryActivity.class);
                intent.putExtra(INTENT_KEY_country, "tr");
                startActivity(intent);
            }
        });
        ///////////////////
        //
        ///////////////////
        us = view.findViewById(R.id.cv_us);
        us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), CountryActivity.class);
                intent.putExtra(INTENT_KEY_country, "us");
                startActivity(intent);
            }
        });
        return view;
    }
}
