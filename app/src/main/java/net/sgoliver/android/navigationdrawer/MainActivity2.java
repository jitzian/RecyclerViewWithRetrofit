package net.sgoliver.android.navigationdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {
    public static final String TAG = MainActivity2.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();

        if(intent.getExtras() != null){
            Log.d(TAG, (intent.getExtras()).get("name").toString());
            Log.d(TAG, (intent.getExtras()).get("lastName").toString());
        }

    }
}
