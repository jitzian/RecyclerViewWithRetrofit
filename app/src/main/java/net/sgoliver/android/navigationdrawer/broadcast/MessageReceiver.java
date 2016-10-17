package net.sgoliver.android.navigationdrawer.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import net.sgoliver.android.navigationdrawer.model.Person;

/**
 * Created by User on 10/16/2016.
 */

public class MessageReceiver extends BroadcastReceiver {
    public static final String TAG = MessageReceiver.class.getName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "------------------------------onReceive------------------------------");
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            Person person = (Person) bundle.get("personObj");
            Log.d(TAG, person.getName());
            Log.d(TAG, person.getLastName());
            Log.d(TAG, String.valueOf(person.getAge()));
        }
    }
}
