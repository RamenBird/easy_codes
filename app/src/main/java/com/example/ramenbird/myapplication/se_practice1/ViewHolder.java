package com.example.ramenbird.myapplication.se_practice1;

import android.view.View;

/**
 * Created by Administrator on 2017/2/19.
 */

public class ViewHolder {
    public View itemView;

    public ViewHolder(View itemView) {
        if (itemView == null)
            throw new NullPointerException("???");
        this.itemView = itemView;
    }
}
