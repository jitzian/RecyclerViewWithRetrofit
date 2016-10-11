package net.sgoliver.android.navigationdrawer.dagger.singleton;

import android.app.Application;
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
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication(){
        return application;
    }

}
