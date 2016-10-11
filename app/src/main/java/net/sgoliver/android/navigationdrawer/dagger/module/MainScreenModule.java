package net.sgoliver.android.navigationdrawer.dagger.module;

import net.sgoliver.android.navigationdrawer.dagger.contract.MainScreenContract;
import net.sgoliver.android.navigationdrawer.dagger.scope.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by User on 10/11/2016.
 */
@Module
public class MainScreenModule {
    public static final String TAG = MainScreenModule.class.getName();
    private final MainScreenContract.View mView;

    public MainScreenModule(MainScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView(){
        return mView;
    }

}
