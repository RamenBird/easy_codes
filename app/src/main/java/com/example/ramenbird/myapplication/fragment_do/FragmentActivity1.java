package com.example.ramenbird.myapplication.fragment_do;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ramenbird.myapplication.R;

/**
 * Created by RamenBird on 2017/6/20.
 */

public class FragmentActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1);

        getFragmentManager().beginTransaction().addToBackStack("1").add(R.id.container,
               new DoFragment()).commit();
    }
}
