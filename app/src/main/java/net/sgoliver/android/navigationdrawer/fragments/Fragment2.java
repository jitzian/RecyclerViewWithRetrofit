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

import net.sgoliver.android.navigationdrawer.R;
import net.sgoliver.android.navigationdrawer.adapter.CheeseListAdapter;
import net.sgoliver.android.navigationdrawer.managers.CheeseManager;
import net.sgoliver.android.navigationdrawer.managers.ResourceLoader;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment2 extends Fragment {
    public static final String TAG = Fragment2.class.getName();

    View rootView;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    private String BASE_URL = "https://gist.githubusercontent.com/";
    private String GITHUB_USER = "libinbensin";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fragment2, container, false);
        Log.d(TAG, "Start Fragment2");
        initRecyclerView();
        return rootView;
    }

    public void initRecyclerView() {
        Log.d(TAG, "initControls");
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_dynamic);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CheeseManager.GitHubRestInterface gitHubRestInterface = retrofit.create(CheeseManager.GitHubRestInterface.class);
        Call<ArrayList<String>> call = gitHubRestInterface.getCheese(GITHUB_USER);

        if(call != null){
            Log.d(TAG, "CALL NOT NULL");
            call.enqueue(new Callback<ArrayList<String>>() {
                @Override
                public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                    Log.d(TAG, "onResponse:: " + response);
                    ArrayList arrLstResponse = response.body();
                    adapter = new CheeseListAdapter(getActivity(), arrLstResponse);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                    Log.d(TAG, "onFailure:: " + t.getMessage());
                }
            });
        }else{
            Log.d(TAG, "CALL NULL");
        }

    }

}
