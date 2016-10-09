package net.sgoliver.android.navigationdrawer.FragmentsCommunication;

import java.util.ArrayList;

/**
 * Created by User on 10/8/2016.
 */

public interface ICommunication {
    void getListFromActivity(ArrayList<String> lstRes);
    ArrayList<String> getCheeseListFromWebToFragment();
}
