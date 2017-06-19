package com.example.ramenbird.myapplication.anime_study;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.ramenbird.myapplication.R;

/**
 * Created by RamenBird on 2016/12/23.
 */

public class AnimeTest1Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anime_test_1);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        ImageView imageView = (ImageView) findViewById(R.id.image);

        RotateAnimation rotateAnimation = new RotateAnimation(0, 90, Animation.RELATIVE_TO_SELF,
                0, Animation.RELATIVE_TO_SELF, 0);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        imageView.startAnimation(rotateAnimation);

    }
}
