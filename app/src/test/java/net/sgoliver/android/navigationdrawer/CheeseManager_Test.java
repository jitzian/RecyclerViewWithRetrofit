package net.sgoliver.android.navigationdrawer;

import android.content.Context;
import android.util.Log;

import net.sgoliver.android.navigationdrawer.managers.CheeseManager;
import net.sgoliver.android.navigationdrawer.managers.ResourceLoader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by User on 10/9/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CheeseManager_Test {

    public static final String TAG = CheeseManager_Test.class.getName();

    private CheeseManager cheeseManager;

    @Mock
    private Context context;

    @Mock
    private ResourceLoader resourceLoader;

    @Before
    public void setUp(){
        resourceLoader = new ResourceLoader();
        cheeseManager = new CheeseManager(resourceLoader);

    }

    @Test
    public void getSortedCheeseListFromAssets() throws Exception {
        //TODO: Create Unit test for the CheeseManager.getSortedCheeseListFromAssets() method.
        System.out.println(this.resourceLoader);
        System.out.println(cheeseManager);
        System.out.println(context.toString());
        ArrayList<String>lstRes = cheeseManager.getSortedCheeseListFromAssets(context);

        if(lstRes != null){
            System.out.println(lstRes.size());
        }else{
            System.out.println("NULL");
        }
//        System.out.println(lstRes.size());

//        assertNotNull(lstRes);
    }


}
