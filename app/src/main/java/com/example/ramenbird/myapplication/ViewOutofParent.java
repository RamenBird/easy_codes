package com.example.ramenbird.myapplication;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by RamenBird on 2016/12/2.
 */

public class ViewOutofParent extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_out_of_parent);

        View toastView = getLayoutInflater().inflate(R.layout.toast_layout, null);

        ImageView view = (ImageView) findViewById(R.id.image);
//        view.setOnClickListener(v -> {
//            Toast toast = Toast.makeText(this, "???", Toast.LENGTH_SHORT);
//            toast.setView(toastView);
//            toast.show();
//        });

        View root = findViewById(R.id.root);
//        root.post(new Runnable() {
//            @Override
//            public void run() {
//                Rect rect = new Rect();
//                view.getHitRect(rect);
//                rect.bottom += 150;
//
//                root.setTouchDelegate(new TouchDelegate(rect, view));
//            }
//        });
    }
}
