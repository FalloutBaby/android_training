package com.bbocelot.workerpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            text.setText((String) msg.obj);
        }
    };

    private TextView text;
    //    private SimpleWorker worker;
    private Worker worker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);

//        worker = new SimpleWorker();
        worker = new Worker();

        worker.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Message message = Message.obtain();
                        message.obj = "Task 1 completed";
                        handler.sendMessage(message);
                    }
                }
        ).execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Message message = Message.obtain();
                        message.obj = "Task 2 completed";
                        handler.sendMessage(message);
                    }
                }
        ).execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Message message = Message.obtain();
                        message.obj = "Task 3 completed";
                        handler.sendMessage(message);
                    }
                }
        ).execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Message message = Message.obtain();
                        message.obj = "Task 4 completed";
                        handler.sendMessage(message);
                    }
                }
        ).execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Message message = Message.obtain();
                        message.obj = "Task 5 completed";
                        handler.sendMessage(message);
                    }
                }
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        worker.quit();
    }
}