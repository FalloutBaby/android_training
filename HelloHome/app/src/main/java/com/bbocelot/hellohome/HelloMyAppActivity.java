package com.bbocelot.hellohome;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class HelloMyAppActivity extends Activity {
    private static final boolean LOG = true;
    private static final String LOG_TAG = "Hello";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (LOG) Log.d(LOG_TAG, "HelloMyAppActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_myapp);
    }
}
