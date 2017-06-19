package com.example.ramenbird.myapplication.se_practice1.define;

import android.content.Context;
import android.view.View;

import com.example.ramenbird.myapplication.se_practice1.ViewHolder;
import com.example.ramenbird.myapplication.se_practice1.define.MultiViewBuilder;

/**
 * Created by Administrator on 2017/2/19.
 */

public interface SingleViewBuilder<T, E, VH extends ViewHolder> extends MultiViewBuilder<T, E> {
    VH buildViewHolder(View view);

    View buildView(Context context);

    void bindView(View view, VH vh, T t, E e);
}
