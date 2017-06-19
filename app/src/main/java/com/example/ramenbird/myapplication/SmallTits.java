package com.example.ramenbird.myapplication;

import java.text.DecimalFormat;

/**
 * Created by ramenbird on 2016/11/24.
 */

public class SmallTits {
    public final static String doubleFormat(double value) {
        return new DecimalFormat("#.00").format(value);
    }
}
