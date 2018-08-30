package com.example.testapp.work.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.testapp.work.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView post;
    TextView site;
    public ViewHolder(View itemView) {
        super(itemView);
        post = (TextView) itemView.findViewById(R.id.postitem_post);
        site = (TextView) itemView.findViewById(R.id.postitem_site);
}
}
