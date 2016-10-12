package net.sgoliver.android.navigationdrawer.dagger.component;

import android.app.Application;
import android.util.Log;

//import net.sgoliver.android.navigationdrawer.dagger.component.DaggerNetComponent;
//import net.sgoliver.android.navigationdrawer.dagger.module.AppModule;
//import net.sgoliver.android.navigationdrawer.dagger.module.NetModule;

/**
 * Created by User on 10/10/2016.
 */

public class App extends Application {
    public static final String TAG = App.class.getName();
    public NetComponent netComponent;

//    @Override
//    public void onCreate() {
//        super.onCreate();
//        startDagger();
//    }

    //Dagger configuration
//    public void startDagger(){
//        Log.d(TAG, "startDagger");
//        netComponent = DaggerNetComponent.builder()
//                .appModule(new AppModule(this))
//                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
//                .build();
//    }

    public NetComponent getNetComponent(){
        return netComponent;
    }

}
