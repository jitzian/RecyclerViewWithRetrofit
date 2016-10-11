package net.sgoliver.android.navigationdrawer.fragments;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.sgoliver.android.navigationdrawer.R;
import net.sgoliver.android.navigationdrawer.dagger.singleton.AppModule;
import net.sgoliver.android.navigationdrawer.dagger.singleton.DaggerNetComponent;
import net.sgoliver.android.navigationdrawer.dagger.singleton.NetModule;
import net.sgoliver.android.navigationdrawer.dagger.singleton.NetComponent;

public class Fragment4 extends Fragment {
    public static final String TAG = Fragment4.class.getName();
    View rootView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    //Dagger Injection
    NetComponent netComponent;



    public Fragment4() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Fragment4 newInstance(String param1, String param2) {
        Fragment4 fragment = new Fragment4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView");
        rootView = inflater.inflate(R.layout.fragment_fragment4, container, false);
        return rootView;
    }

    //DaggerInit()
    public void daggerInit(){
        Log.d(TAG, "daggerInit");
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule((Application) rootView.getContext()))
                .netModule(new NetModule("https://api.github.com"))
                .build();

    }
    public NetComponent getNetComponent() {
        return netComponent;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
