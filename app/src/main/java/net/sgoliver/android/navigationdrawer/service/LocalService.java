package net.sgoliver.android.navigationdrawer.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Random;

/**
 * Created by User on 10/19/2016.
 */

public class LocalService extends Service {
    public static final String TAG = LocalService.class.getName();

    //Binder for the clients
    private final IBinder binder = new LocalBinder();

    //Generate Ramdom Numbers
    private final Random generator = new Random();

    public class LocalBinder extends Binder{
        public LocalBinder(){

        }
        //Returns instance of the LocalService for the clients. So, they can call it's methods
        public LocalService getService(){
            return LocalService.this;
        }
    }

    public int getRandomNumbers(){
        return generator.nextInt(100);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
