package net.sgoliver.android.navigationdrawer.singleton;

/**
 * Created by User on 11/2/2016.
 */

public class MySingleton {

    private static MySingleton instance = null;

    private static MySingleton getInstance(){
        if(instance == null){
            synchronized (MySingleton.class){
                if(instance == null){
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }

}
