package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppBarFragment extends Fragment {

    public static final String TAG = "appBar";

    private static Component mInstance;

    Unbinder mUnbider;

    public AppBarFragment() {
        // Required empty public constructor
    }

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.tablayout);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_bar, container, false);
        mUnbider = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbider.unbind();
    }

    @OnClick(R.id.btnTop)
    public void onViewClickedTop(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        AppTopBarFragment topBarFragment = new AppTopBarFragment();
        topBarFragment.show(transaction, AppTopBarFragment.TAG);

    }

    @OnClick(R.id.btnBottom)
    public void onViewClickedBottom(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        AppBottomBarFragment bottomBarFragment = new AppBottomBarFragment();
        bottomBarFragment.show(transaction, AppBottomBarFragment.TAG);
    }


}
