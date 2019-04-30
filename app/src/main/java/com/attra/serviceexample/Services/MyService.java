package com.attra.serviceexample.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static String TAG=MyService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG,"OnCreate Method is called: Thread Name -"+ Thread.currentThread().getName());
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.i(TAG,"onBind Method is called: Thread Name -"+ Thread.currentThread().getName());
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG,"onStartCommand Method is called: Thread Name -"+ Thread.currentThread().getName());

        MyTask task= (MyTask) new MyTask(this).execute();

        return START_STICKY;
    }


    @Override
    public void onDestroy() {

        Log.i(TAG,"onDestroy Method is called: Thread Name -"+ Thread.currentThread().getName());
        super.onDestroy();
    }
}
