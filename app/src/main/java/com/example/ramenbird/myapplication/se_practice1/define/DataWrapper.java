package com.example.ramenbird.myapplication.se_practice1.define;

/**
 * Created by Administrator on 2017/2/18.
 */

public interface DataWrapper<T, E> {
    void wrap(T t);

    T get();

    E getExtra();

    void remove();

    MultiViewBuilder<T, E> getViewBuilder();
}
