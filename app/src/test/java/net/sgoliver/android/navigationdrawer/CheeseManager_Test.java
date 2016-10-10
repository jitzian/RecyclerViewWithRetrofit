package net.sgoliver.android.navigationdrawer;

import android.content.Context;

import net.sgoliver.android.navigationdrawer.managers.CheeseManager;
import net.sgoliver.android.navigationdrawer.managers.ResourceLoader;

import org.junit.Before;
import org.mockito.Mock;

/**
 * Created by User on 10/9/2016.
 */

public class CheeseManager_Test {

    private CheeseManager cheeseManager;
    private Context context;

    @Mock
    private ResourceLoader resourceLoader;

    @Before
    public void setUp(){
        cheeseManager = null;
        context = null;
        resourceLoader = null;
    }

}
