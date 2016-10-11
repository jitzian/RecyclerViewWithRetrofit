package net.sgoliver.android.navigationdrawer.dagger.module;

import android.app.Application;
import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by User on 10/10/2016.
 */
@Module
public class AppModule {
    public static final String TAG = AppModule.class.getName();
    Application application;

    public AppModule(){
    }

    public AppModule(Application application){
        Log.d(TAG, "AppModule");
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication(){
        Log.d(TAG, "providesApplication");
        return application;
    }

}
