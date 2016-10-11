package net.sgoliver.android.navigationdrawer.dagger.singleton;

import net.sgoliver.android.navigationdrawer.fragments.Fragment4;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by User on 10/10/2016.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(Fragment4 fragment4);
}
