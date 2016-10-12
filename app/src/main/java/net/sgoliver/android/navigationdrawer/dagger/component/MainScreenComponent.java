package net.sgoliver.android.navigationdrawer.dagger.component;

import net.sgoliver.android.navigationdrawer.MainActivity;
import net.sgoliver.android.navigationdrawer.dagger.module.MainScreenModule;
import net.sgoliver.android.navigationdrawer.dagger.scope.CustomScope;
import net.sgoliver.android.navigationdrawer.fragments.Fragment4;

import dagger.Component;

/**
 * Created by User on 10/11/2016.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
//    void inject(MainActivity mainActivity);
    void inject(Fragment4 fragment4);
}
