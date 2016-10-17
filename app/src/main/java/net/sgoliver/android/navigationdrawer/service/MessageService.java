package net.sgoliver.android.navigationdrawer.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import net.sgoliver.android.navigationdrawer.model.Person;

/**
 * Created by User on 10/16/2016.
 */

public class MessageService extends Service {
    public static final String TAG = MessageService.class.getName();

    public MessageService(){
        Log.d(TAG, "MessageService");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        sendMessage();
        return super.onStartCommand(intent, flags, startId);
//        return START_NOT_STICKY;
    }

    public void sendMessage(){
        Log.d(TAG, "sendMessage");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setAction("this_is_happeing");
                Person person = new Person();
                person.setName("shachath");
                person.setLastName("cadaver");
                person.setAge(25);
                intent.putExtra("personObj", person);
//        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                sendBroadcast(intent);
                Log.d(TAG, "END sendMessage");
                stopSelf();
            }
        }).start();
    }
}
