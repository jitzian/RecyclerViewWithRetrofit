package net.sgoliver.android.navigationdrawer.observaleDummy;

import android.util.Log;

/**
 * Created by User on 10/18/2016.
 */

public class ObservDemo {
    public static final String TAG = ObservDemo.class.getName();

    MyViewObserver view;
    MyModelObservable model;

    public ObservDemo(){
        view = new MyViewObserver();
//        model = new MyModelObservable();
    }

    public static void main(String...args){
        ObservDemo me = new ObservDemo();


    }

    public void demo(){
        Log.d(TAG, "demo");
//        model.changeSomething();
    }

}
