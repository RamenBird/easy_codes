package com.example.ramenbird.myapplication.db_study;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

/**
 * Created by RamenBird on 2016/12/29.
 */

public class DbTestActivity1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        database.query("test", null, null, null, null, null, null);
        database.rawQuery("select rowid as _id from test", null);
    }
}
