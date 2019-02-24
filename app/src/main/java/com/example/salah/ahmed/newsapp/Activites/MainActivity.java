package com.example.salah.ahmed.newsapp.Activites;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Switch;
import android.view.MenuInflater;
import android.app.SearchManager;
import android.content.Context;
import android.app.Fragment;


import com.crashlytics.android.Crashlytics;
import com.example.salah.ahmed.newsapp.Fragment.Fragment_Favorite;
import com.example.salah.ahmed.newsapp.Fragment.Fragment_Home;
import com.example.salah.ahmed.newsapp.Fragment.Fragment_Public;
import com.example.salah.ahmed.newsapp.R;

import io.fabric.sdk.android.Fabric;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.btn_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new Fragment_Home())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    android.support.v4.app.Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new Fragment_Home();
                            break;
                        case R.id.nav_global:
                            selectedFragment = new Fragment_Public();
                            break;
                        case R.id.nav_favorite:
                            selectedFragment = new Fragment_Favorite();
                            break;
//                        case R.id.nav_search:
//                            selectedFragment = new Fragment_Search();
//                            break;
                    }
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();
                    return true;
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.search_btn) {

            Intent i = new Intent(this,SearchActivity.class);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }


}
