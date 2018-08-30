package com.example.testapp.work.activity;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.testapp.work.R;
import com.example.testapp.work.adapters.ListAdapter;
import com.example.testapp.work.api.Result;

import java.util.ArrayList;
import java.util.List;

public class PreferencesActivity extends AppCompatActivity {
    RecyclerView recycleView;
    LinearLayoutManager layoutManager;
    final String LOG_TAG="myLog";
    List<Result> preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        recycleView=(RecyclerView)findViewById(R.id.posts_recycle_view);
        preferences=new ArrayList<>();
        ListAdapter adapter=new ListAdapter(preferences);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(adapter);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}
