package net.sgoliver.android.navigationdrawer;

import android.util.Log;

/**
 * Created by User on 10/16/2016.
 */

public class SingletonClient {
    public static final String TAG = SingletonClient.class.getName();
    public static SingletonClient instance;

    public SingletonClient getInstance(){
        Log.d(TAG, "getInstance");
        if(instance == null){
            instance = new SingletonClient();
        }
        return instance;
    }

}
