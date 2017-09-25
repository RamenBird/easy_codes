package com.example.ramenbird.myapplication;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

import java.text.DecimalFormat;

/**
 * Created by The great and powerful Android 18 on 2017/9/14.
 */

public class UsefulUtilities {
    public static final void setTouchDelegateForView(View view, Rect rect) {
        ((View) view.getParent()).setTouchDelegate(new TouchDelegate(rect, view));
    }

    public static final String doubleFormat(double value) {
        return new DecimalFormat("#.00").format(value);
    }
}
