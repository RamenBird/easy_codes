package com.example.ramenbird.myapplication.se_practice1.define;

import com.example.ramenbird.myapplication.se_practice1.define.DataWrapper;

/**
 * Created by Administrator on 2017/2/19.
 */

public interface DataWrapperCollection {
    void add(DataWrapper wrapper);

    void remove(DataWrapper wrapper);

    void clear();

    int getWrapperCount();
}
