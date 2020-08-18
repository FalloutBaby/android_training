package com.bbocelot.workerpractice;

import android.util.Log;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleWorker extends Thread {
    private  static final String TAG = "SimpleWorker";

    private final AtomicBoolean isAlive = new AtomicBoolean(true);

    private final ConcurrentLinkedDeque<Runnable> queue = new ConcurrentLinkedDeque<>();

    public SimpleWorker() {
        super(TAG);
        start();
    }

    @Override
    public void run() {
        while (isAlive.get()) {
            Runnable task = queue.poll();
            if (task != null) {
                task.run();
            }
        }
        Log.d(TAG, "Simple Worker Terminated");
    }

    public SimpleWorker execute(Runnable task) {
        queue.add(task);
        return this;
    }

    // Просим завершить работу
    public void quit() {
        isAlive.set(false);
    }
}