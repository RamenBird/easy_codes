package com.example.ramenbird.myapplication.se_practice1.wrapper;

import android.content.Context;
import android.view.View;

import com.example.ramenbird.myapplication.se_practice1.HeaderIndexContainer;
import com.example.ramenbird.myapplication.se_practice1.ViewHolder;
import com.example.ramenbird.myapplication.se_practice1.define.DataWrapper;
import com.example.ramenbird.myapplication.se_practice1.define.SingleViewBuilder;

/**
 * Created by Administrator on 2017/2/19.
 */

public abstract class SingleViewDataWrapper<T, VH extends ViewHolder>
        extends DataWrapperImplBase<T, HeaderIndexContainer>
        implements SingleViewBuilder<T, HeaderIndexContainer, VH> {

    @Override
    public View buildView(Context context, T t, HeaderIndexContainer e, int index) {
        View view = buildView(context);
        VH vh = buildViewHolder(view);
        bindView(view, vh, t, e);
        return view;
    }

    @Override
    public HeaderIndexContainer getExtra() {
        return this;
    }

    @Override
    public int getViewCount(T t, HeaderIndexContainer headerIndexContainer) {
        return 1;
    }
}
