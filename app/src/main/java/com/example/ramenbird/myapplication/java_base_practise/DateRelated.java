package com.example.ramenbird.myapplication.java_base_practise;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by RamenBird on 2017/1/23.
 */

public class DateRelated {
    public void func1() {
        Date data = new Date();
        Log.d(getClass().getSimpleName(), new SimpleDateFormat("yyyy:MM:dd:hh:mm:ss")
               .format(data));

    }

}
