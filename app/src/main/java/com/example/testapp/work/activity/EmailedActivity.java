package com.example.testapp.work.activity;

import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.testapp.work.R;
import com.example.testapp.work.adapters.ListAdapter;
import com.example.testapp.work.api.Example;
import com.example.testapp.work.api.Result;
import com.example.testapp.work.builders.Builder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmailedActivity extends Activity {
    RecyclerView recycleView;
    LinearLayoutManager layoutManager;
    final String LOG_TAG="myLog";
    List<Result> mostEmailed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailed);
        recycleView=(RecyclerView)findViewById(R.id.posts_recycle_view);
        mostEmailed=new ArrayList<>();
        ListAdapter adapter=new ListAdapter(mostEmailed);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(adapter);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Builder.getApiMost().mostEmailed().enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()){
                    Log.d(LOG_TAG,"Server response: "+response.toString());
                    Log.d(LOG_TAG,"received information: "+response.body().toString());
                    mostEmailed=response.body().getResults();
                    //recycleView.getAdapter().notifyDataSetChanged();
                    Log.d(LOG_TAG,"cool");
                }else Log.d(LOG_TAG,"bad");
            }


            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d(LOG_TAG,"failure " + t);
            }
        });
    }
}
