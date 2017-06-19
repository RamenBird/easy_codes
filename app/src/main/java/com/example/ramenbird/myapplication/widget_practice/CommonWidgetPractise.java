package com.example.ramenbird.myapplication.widget_practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.example.ramenbird.myapplication.R;

/**
 * Created by Administrator on 2016/11/20.
 */

public class CommonWidgetPractise extends Activity {
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(this).inflate(R.layout.widget_practise_activity_layout, null);
        setContentView(view);


//        findViewById(R.id.button1).setOnClickListener(v -> {
//            if (mPopupWindow == null) {
//                View view2 = LayoutInflater.from(CommonWidgetPractise.this)
//                        .inflate(R.layout.popup_layout1, null);
//
//                mPopupWindow = new PopupWindow(view2, ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.MATCH_PARENT);
//
//                mPopupWindow.setOutsideTouchable(true);
//                mPopupWindow.setFocusable(true);
//                mPopupWindow.setBackgroundDrawable(new BitmapDrawable((Bitmap) null));
//
//            }
//
//            if (!mPopupWindow.isShowing()) {
//                mPopupWindow.showAsDropDown(findViewById(R.id.button1),
//                        -findViewById(R.id.button1).getWidth(),
//                        -findViewById(R.id.button1).getHeight());
//            }
//        });

//        findViewById(R.id.button2).setOnClickListener(v -> {
//            Dialog dialog = new Dialog(this, R.style.Theme_dialog);
//            View view2 = getLayoutInflater().inflate(R.layout.popup_layout1, null);
//            dialog.setContentView(view2);
//
//            Window window = dialog.getWindow();
//            WindowManager.LayoutParams layoutParams = window.getAttributes();
//            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
//            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
//
//            window.setAttributes(layoutParams);
//
//            dialog.setCancelable(true);
//
//            view2.setOnClickListener(p -> {
//                if (dialog.isShowing()) dialog.dismiss();
//            });
//
//            dialog.show();
//        });
    }
}
