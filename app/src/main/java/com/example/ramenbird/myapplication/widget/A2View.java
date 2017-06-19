package com.example.ramenbird.myapplication.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/2/8.
 */

public class A2View extends ViewGroup {
    public A2View(Context context) {
        super(context);
    }

    public A2View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public A2View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        int widthSpec = MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.AT_MOST);
        int heightSpec = MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.AT_MOST);
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            child.measure(widthSpec, heightSpec);
            child.layout(0, 0, child.getMeasuredWidth(), child.getMeasuredHeight());
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        int s = canvas.save();
        canvas.scale(0.5f, 0.5f);
        canvas.translate(100, 100);
//        canvas.clipRect(10, 10, 210, 210);

        View view = getChildAt(0);
        view.setAlpha(0.5f);

        drawChild(canvas, getChildAt(0), getDrawingTime());

        canvas.restoreToCount(s);
    }



}
