package com.example.ramenbird.myapplication.fragment_do;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ramenbird.myapplication.R;

/**
 * Created by RamenBird on 2017/6/21.
 */

public class DoFragment extends Fragment implements LoaderManager.LoaderCallbacks<Bitmap> {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f11, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLoaderManager().initLoader(0, null, DoFragment.this);
            }
        });
    }

    @Override
    public ALoader onCreateLoader(int id, Bundle args) {
        return new ALoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<Bitmap> loader, Bitmap data) {
    }

    @Override
    public void onLoaderReset(Loader<Bitmap> loader) {

    }
}
