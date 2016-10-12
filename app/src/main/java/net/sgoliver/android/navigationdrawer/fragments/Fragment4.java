package net.sgoliver.android.navigationdrawer.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.sgoliver.android.navigationdrawer.R;
import net.sgoliver.android.navigationdrawer.adapter.PostListAdapter;
import net.sgoliver.android.navigationdrawer.dagger.component.DaggerMainScreenComponent;
import net.sgoliver.android.navigationdrawer.dagger.contract.MainScreenContract;
import net.sgoliver.android.navigationdrawer.dagger.module.MainScreenModule;
import net.sgoliver.android.navigationdrawer.dagger.component.App;
import net.sgoliver.android.navigationdrawer.model.Post;
import net.sgoliver.android.navigationdrawer.presenter.MainScreenPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class Fragment4 extends Fragment implements MainScreenContract.View{
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


    //RecyclerView
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<String>list;

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

    @Inject
    MainScreenPresenter mainScreenPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView");
        rootView = inflater.inflate(R.layout.fragment_fragment4, container, false);

        initRecyclerView();
        initDagger();

        return rootView;
    }

    public void initRecyclerView(){
        Log.d(TAG, "initRecyclerView");
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_dagger);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        list = new ArrayList<>();

        //prepare the adapter..

    }

    public void initDagger(){
        Log.d(TAG, "initDagger");
        DaggerMainScreenComponent.builder()
                .netComponent(((App) getActivity().getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);

        //Call the method in MainPresenter to make Network Request
        mainScreenPresenter.loadPost();
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

    @Override
    public void showPosts(List<Post> posts) {
        Log.d(TAG, "showPosts");

        for(Post obj : posts)
            list.add(obj.getTitle());

        adapter = new PostListAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showError(String message) {
        Log.d(TAG, "showError");
        Toast.makeText(getActivity(), "Error: " + message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showComplete() {
        Log.d(TAG, "showComplete");
        Toast.makeText(getActivity(), "Complete", Toast.LENGTH_LONG).show();

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
