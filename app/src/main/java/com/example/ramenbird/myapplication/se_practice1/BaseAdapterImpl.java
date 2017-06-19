package com.example.ramenbird.myapplication.se_practice1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.ramenbird.myapplication.se_practice1.define.DataWrapper;
import com.example.ramenbird.myapplication.se_practice1.define.DataWrapperCollection;
import com.example.ramenbird.myapplication.se_practice1.wrapper.DataWrapperImplBase;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */

public class BaseAdapterImpl extends BaseAdapter implements DataWrapperCollection {
    private WeakReference<Context> mContext;
    private List<DataWrapperImplBase> mWrappers = new ArrayList<>();
    private int mCount;

    public BaseAdapterImpl(Context context) {
        this.mContext = new WeakReference<Context>(context);
    }

    private void updateCount() {
        int c = 0;
        int headerIndex = 0;
        for (DataWrapperImplBase implBase : mWrappers) {
            implBase.updateIndex(c);
            c += implBase.getViewCount();
            headerIndex = implBase.updateHeaderId(headerIndex);
        }

        mCount = c;
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public DataWrapperImplBase getItem(int position) {
        for (DataWrapperImplBase item : mWrappers) {
            if (item.getIndex() <= position && item.getIndex() + item.getViewCount() > position) {
                return item;
            }
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mContext == null || mContext.get() == null)
            return convertView;

        DataWrapperImplBase dataWrapperImplBase = getItem(position);
        return dataWrapperImplBase.buildView(mContext.get(),
                position - dataWrapperImplBase.getIndex());
    }

    @Override
    public void add(DataWrapper wrapper) {
        add((DataWrapperImplBase) wrapper, false);
    }

    private void add(DataWrapperImplBase wrapper, boolean notify) {
        if (wrapper == null)
            return;

        mWrappers.add(wrapper);
        updateCount();

        if (notify)
            notifyDataSetChanged();
    }

    @Override
    public void remove(DataWrapper wrapper) {
        wrapper.remove();
        mWrappers.remove(wrapper);
        updateCount();
        notifyDataSetChanged();
    }

    @Override
    public void clear() {
        for (DataWrapperImplBase dataWrapper : mWrappers) {
            dataWrapper.remove();
        }
        mWrappers.clear();
        updateCount();
        notifyDataSetChanged();
    }

    @Override
    public int getWrapperCount() {
        return mWrappers.size();
    }

}
