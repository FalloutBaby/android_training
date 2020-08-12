package com.bbocelot.layouttraining;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class ExampleLayoutActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example);
    }
}
