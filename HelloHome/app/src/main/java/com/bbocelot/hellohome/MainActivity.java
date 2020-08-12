package com.bbocelot.hellohome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_hello_home).setOnClickListener(this);
        findViewById(R.id.btn_hello_user).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hello_home) {
            startActivity(new Intent(this, HelloMyAppActivity.class));
        } else if (v.getId() == R.id.btn_hello_user) {
            startActivity(new Intent(this, HelloUsernameActivity.class));
        }
    }

}
