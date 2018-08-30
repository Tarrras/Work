package com.example.testapp.work.adapters;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testapp.work.R;
import com.example.testapp.work.api.Example;
import com.example.testapp.work.api.Result;

import org.json.JSONObject;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Result> resultList;

    public ListAdapter(List<Result> results){
        this.resultList=results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.res_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result example = resultList.get(position);
            holder.tvHead.setText(example.getTitle());
            holder.tvSection.setText(example.getSection());
            holder.tvTime.setText(example.getPublishedDate());
            }

    @Override
    public int getItemCount() {
        return resultList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHead;
        TextView tvSection;
        TextView tvTime;
        CardView cv;
        public ViewHolder(View itemView) {
            super(itemView);
            tvHead = (TextView) itemView.findViewById(R.id.tvHead);
            tvSection = (TextView) itemView.findViewById(R.id.tvSection);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            cv = (CardView) itemView.findViewById(R.id.cv);
        }
    }
}

