package com.bbocelot.hellohome;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class HelloUsernameActivity extends Activity {
    private static final boolean LOG = true;
    private static final String LOG_TAG = "Hello";
    private EditText nameEditText;
    private TextView messageText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (LOG) Log.d(LOG_TAG, "HelloMyAppActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_username);

        nameEditText = findViewById(R.id.edit_text);
        messageText = findViewById(R.id.output);
        Button btnSubmit = findViewById(R.id.button);

        messageText.setVisibility(View.INVISIBLE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String sayingHi = getString(R.string.hello_username, name);
                messageText.setText(sayingHi);
                messageText.setVisibility(View.VISIBLE);
            }
        });
    }
}
