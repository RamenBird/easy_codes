package com.example.ramenbird.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

/**
 * Created by RamenBird on 2017/7/21.
 */

public class AutoFocusActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_auto_focus);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getCurrentFocus();
            }
        }, 2000);
    }
}
