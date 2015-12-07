package com.bryanwu95.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    private boolean serviceRunning=false;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return new Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStart Command.");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service has been created.");
        serviceRunning=true;
        new Thread(){
            @Override
            public void run() {
                super.run();
                while(serviceRunning){
                    System.out.println("Service is online");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service has been destroyed");
        serviceRunning=false;
    }
}
