package com.example.ramenbird.myapplication;

import android.graphics.Rect;
import android.util.Log;
import android.view.TouchDelegate;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static final void formatDate() {
        Date data = new Date();
        Log.d(UsefulUtilities.class.getSimpleName(), new SimpleDateFormat("yyyy:MM:dd:hh:mm:ss")
               .format(data));
    }

    public static final void startAnimation(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 90, Animation.RELATIVE_TO_SELF,
               0, Animation.RELATIVE_TO_SELF, 0);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(rotateAnimation);
    }
}
