package net.sgoliver.android.navigationdrawer.util;

import android.content.Context;

import net.sgoliver.android.navigationdrawer.R;

/**
 * Created by evin on 4/29/16.
 * This class is just for testing purposes at SimpleMockitoUnitTest.java
 **/
public class SimpleClass {

    Context context;

    //Constructor
    public SimpleClass(Context context) {
        this.context = context;
    }

    public String getHelloWorldString() {
//        return mContext.getString(R.string.hello_word) + "b";
        return context.getString(R.string.hello_word);
    }
}
