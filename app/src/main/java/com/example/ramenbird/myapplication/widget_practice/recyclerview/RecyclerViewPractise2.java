package com.example.ramenbird.myapplication.widget_practice.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ramenbird.myapplication.R;

/**
 * Created by Administrator on 2017/2/21.
 */

public class RecyclerViewPractise2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycler_view_practise2);


        RecyclerView view = (RecyclerView) findViewById(R.id.recycler_view);
        view.setAdapter(new RecyclerView.Adapter() {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                TextView textView = new TextView(RecyclerViewPractise2.this);
                ViewGroup.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                       100);
                textView.setLayoutParams(layoutParams);
                return new ViewHolder(textView) {
                };
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                ((TextView) holder.itemView).setText(position + "");
            }

            @Override
            public int getItemCount() {
                return 100;
            }
        });
        view.setLayoutManager(new LinearLayoutManager(this));
        view.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            }
        });
    }
}
