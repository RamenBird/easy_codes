package com.example.ramenbird.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ramenbird.myapplication.widget_practice.recycler_view.RecyclerViewPractise2;

/**
 * Created by RamenBird on 2017/6/29.
 */

public class StartActivity extends AppCompatActivity {
    static final Object[] w1 = new Object[]{
           "recycler view animator", RecyclerViewPractise2.class,
           "auto input method pop up", AutoFocusActivity.class
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setAdapter(new RecyclerView.Adapter<Vh>() {
            @Override
            public Vh onCreateViewHolder(ViewGroup parent, int viewType) {
                return new Vh(getLayoutInflater().inflate(R.layout.l1, null));
            }

            @Override
            public void onBindViewHolder(Vh vh, final int position) {
                vh.mTextView.setText((CharSequence) w1[position * 2]);
                vh.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setClass(StartActivity.this, (Class<?>) w1[position * 2 + 1]);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return w1.length / 2;
            }
        });
    }

    private static final class Vh extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public Vh(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text);
            itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                   ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }
}
