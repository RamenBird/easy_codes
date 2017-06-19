package com.example.ramenbird.myapplication.se_practice1.wrapper;

import android.content.Context;
import android.view.View;

import com.example.ramenbird.myapplication.se_practice1.HeaderIndexContainer;
import com.example.ramenbird.myapplication.se_practice1.define.DataWrapper;
import com.example.ramenbird.myapplication.se_practice1.define.MultiViewBuilder;

/**
 * Created by Administrator on 2017/2/19.
 */

public abstract class DataWrapperImplBase<T, E> implements DataWrapper<T, E>,
        MultiViewBuilder<T, E>, HeaderIndexContainer {
    private int mIndex;
    private T data;
    private int mHeaderId;

    @Override
    public int getHeaderId(int index) {
        return mHeaderId;
    }

    @Override
    public int updateHeaderId(int formerIndexId) {
        mHeaderId = formerIndexId;
        return formerIndexId;
    }

    @Override
    public void wrap(T t) {
        this.data = t;
    }

    @Override
    public T get() {
        return data;
    }

    @Override
    public void remove() {
        this.data = null;
    }

    public final int getViewCount() {
        return getViewCount(this.get(), this.getExtra());
    }

    public final View buildView(Context context, int index) {
        return buildView(context, get(), getExtra(), index);
    }

    public final void updateIndex(int index) {
        this.mIndex = index;
    }

    public final int getIndex() {
        return this.mIndex;
    }

    @Override
    public MultiViewBuilder<T, E> getViewBuilder() {
        return this;
    }
}
