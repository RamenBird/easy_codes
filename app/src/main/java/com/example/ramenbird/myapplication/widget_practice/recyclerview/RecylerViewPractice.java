package com.example.ramenbird.myapplication.widget_practice.recyclerview;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ramenbird.myapplication.R;

/**
 * Created by ramenbird on 2016/11/17.
 */

public class RecylerViewPractice extends Activity {
    private Drawable drawable;
    private GridLayoutManager gridLayoutManager;

    public void switchSpan(View view) {
        gridLayoutManager.setSpanCount(3 - gridLayoutManager.getSpanCount());
        ((RecyclerView) findViewById(R.id.recycler_view)).getAdapter().notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_activity_recycler_view);

        drawable = getDrawable(R.drawable.home_category_divider);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = getLayoutInflater().inflate(R.layout.practice_activity_recycler_view_item_layout,
                        null);

                ViewHolder vh = new ViewHolder(view);
                vh.view1 = view.findViewById(R.id.layout1);
                vh.view2 = view.findViewById(R.id.layout2);
                vh.number = (TextView) view.findViewById(R.id.number);
                return vh;
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                if (gridLayoutManager.getSpanCount() == 1) {
                    holder.view1.setVisibility(View.VISIBLE);
                    holder.view2.setVisibility(View.GONE);
                } else {
                    holder.view2.setVisibility(View.VISIBLE);
                    holder.view1.setVisibility(View.GONE);
                }

                holder.number.setText(String.valueOf(position));

            }

            @Override
            public int getItemCount() {
                return 100;
            }
        });

        //add divider between items
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                int right = parent.getWidth();
                for (int i = 0; i < parent.getChildCount(); i++) {
                    View view = parent.getChildAt(i);
                    int bottom = view.getBottom();
                    drawable.setBounds(0, bottom - 1, right, bottom);
                    drawable.draw(c);

                    if (gridLayoutManager.getSpanCount() == 2 && i % 2 == 0) {
                        drawable.setBounds(view.getRight(), view.getTop(), view.getRight() + 2, view.getBottom());
                        drawable.draw(c);
                    }
                }
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == recyclerView.getAdapter().getItemCount()) {

                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                lastVisibleItem = gridLayoutManager.findLastVisibleItemPosition();
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view1, view2;
        TextView number;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
