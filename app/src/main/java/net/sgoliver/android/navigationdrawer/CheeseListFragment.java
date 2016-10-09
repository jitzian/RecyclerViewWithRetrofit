package net.sgoliver.android.navigationdrawer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import net.sgoliver.android.navigationdrawer.FragmentsCommunication.ICommunication;
import net.sgoliver.android.navigationdrawer.R;
import net.sgoliver.android.navigationdrawer.adapter.CheeseListAdapter;

import java.util.ArrayList;

/**
 * @author Libin
 */
public class CheeseListFragment extends Fragment{
    public static final String TAG = CheeseListFragment.class.getName();

    View rootView;
    ICommunication iCommunication;

    //RecyclerView
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_list , null);
        Log.d(TAG, "Creating Fragment :: onCreateView");
//        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        rootView.setTag(TAG);

        initViewControls();

        return rootView;
    }

    public void initViewControls(){
        Log.d(TAG, "initViewControls");

    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        ArrayList<String> cheeseList = null; //TODO: Receive the cheeseList from Activity.
//
//        RecyclerView listView = (RecyclerView) view.findViewById(R.id.cheese_list_view);
//        CheeseListAdapter cheeseListAdapter = new CheeseListAdapter(cheeseList);
//        listView.setAdapter(cheeseListAdapter);
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iCommunication = (ICommunication) context;
    }

    public void getLstResFromActivity(ArrayList<String>lstRes){
        Log.d(TAG, "getLstResFromActivity");
        if(lstRes != null){
            for(String obj : lstRes){
                Log.d(TAG, "CHEESE: " + obj.toString());
            }
        }
    }

}
