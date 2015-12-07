package com.bryanwu95.learnintent;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Bryan on 2015/6/8.
 */
public class MyAty extends Activity{
    public static final String ACTION="com.bryanwu95.learnintent.intent.action.myaty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myaty);

    }
}
