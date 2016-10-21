package net.sgoliver.android.navigationdrawer.observaleDummy;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;


/**
 * Created by User on 10/18/2016.
 */

public class MyViewObserver implements Observer {
    public static final String TAG = MyViewObserver.class.getName();

    public void MyView() {
        Log.d(TAG, "MyViewObserver");
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
