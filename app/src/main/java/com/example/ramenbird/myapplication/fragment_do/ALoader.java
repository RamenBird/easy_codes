package com.example.ramenbird.myapplication.fragment_do;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by RamenBird on 2017/6/21.
 */

public class ALoader extends AsyncTaskLoader<Bitmap> {
    public ALoader(Context context) {
        super(context);
    }

    @Override
    public Bitmap loadInBackground() {
        return null;
    }
}
