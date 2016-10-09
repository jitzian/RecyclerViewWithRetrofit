package net.sgoliver.android.navigationdrawer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eduardopereira.support.RecyclerViewFragment;

import net.sgoliver.android.navigationdrawer.R;
import net.sgoliver.android.navigationdrawer.adapter.CheeseListAdapter;
import net.sgoliver.android.navigationdrawer.managers.CheeseManager;
import net.sgoliver.android.navigationdrawer.managers.ResourceLoader;

import java.util.ArrayList;

public class Fragment1 extends Fragment/*RecyclerViewFragment*/ {
    public static final String TAG = Fragment1.class.getName();
    View rootView;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fragment1, container, false);
        Log.d(TAG, "Start Fragment1");

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
        initControls();

    }

    public void initControls(){
        Log.d(TAG, "initControls");
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_static);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CheeseListAdapter(getActivity(), getListOfCheeses());
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<String> getListOfCheeses() {
        ResourceLoader resourceLoader = new ResourceLoader();
        CheeseManager cheeseManager = new CheeseManager(resourceLoader);
        return cheeseManager.getSortedCheeseListFromAssets(rootView.getContext());
    }


}
