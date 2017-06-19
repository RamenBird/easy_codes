package com.example.ramenbird.myapplication.se_practice1.define;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2017/2/19.
 */

public interface MultiViewBuilder<T, E> {
    int getViewCount(T t, E e);

    View buildView(Context context, T t, E e, int index);
}
