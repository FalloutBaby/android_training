package com.bbocelot.workerpractice;

import android.os.Handler;
import android.os.HandlerThread;

public class Worker extends HandlerThread {

    private static final String TAG = "Worker";

    private final Handler handler;

    public Worker() {
        super(TAG);
        start();
        // Создаём Handler для отправки сообщений/задач в фоновый поток
        handler = new Handler(getLooper());
    }

    // Отправляем задачу для выполнения в фоновом потоке
    public Worker execute(Runnable task) {
        handler.post(task);
        return this;
    }
}