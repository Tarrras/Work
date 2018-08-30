package com.example.testapp.work.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TabHost;

import com.example.testapp.work.R;
import com.example.testapp.work.api.Example;
import com.example.testapp.work.api.Result;
import com.example.testapp.work.builders.Builder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost=getTabHost();
        TabHost.TabSpec tabSpec;


        tabSpec=tabHost.newTabSpec("tabs_mostViewed");
        tabSpec.setIndicator("Most Viewed News");
        tabSpec.setContent(new Intent(this,ViewedActivity.class));
        tabHost.addTab(tabSpec);


        tabSpec=tabHost.newTabSpec("tabs_mostShared");
        tabSpec.setIndicator("Most Shared News");
        tabSpec.setContent(new Intent(this,SharedActivity.class));
        tabHost.addTab(tabSpec);


        tabSpec=tabHost.newTabSpec("tabs_mostEmailed");
        tabSpec.setIndicator("Most Emailed News");
        tabSpec.setContent(new Intent(this,EmailedActivity.class));
        tabHost.addTab(tabSpec);


        tabSpec=tabHost.newTabSpec("tabs_preferences");
        tabSpec.setIndicator("Your Favorite News");
        tabSpec.setContent(new Intent(this,PreferencesActivity.class));
        tabHost.addTab(tabSpec);

        }
    }

