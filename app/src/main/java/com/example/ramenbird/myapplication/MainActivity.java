package com.example.ramenbird.myapplication;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.widget.LinearLayout;

import static android.R.attr.radius;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View view = findViewById(R.id.i1);
        view.post(new Runnable() {
            @Override
            public void run() {
                RenderScript rs = RenderScript.create(MainActivity.this);
                Allocation overlayAlloc = Allocation.createFromBitmap(rs, view.getDrawingCache());
                ScriptIntrinsicBlur blur =
                        ScriptIntrinsicBlur.create(rs, overlayAlloc.getElement());
                blur.setInput(overlayAlloc);
                blur.setRadius(radius);
                blur.forEach(overlayAlloc);
                overlayAlloc.copyTo(view.getDrawingCache());
                view.setBackground(new BitmapDrawable(getResources(), view.getDrawingCache()));
                rs.destroy();

            }
        });
    }

    public void click1(View v) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.i);
        View node = getLayoutInflater().inflate(R.layout.main_item, null);
        linearLayout.addView(node);
    }
}
