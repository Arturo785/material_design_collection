package com.alain.cursos.mdcomponents.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 */

public class BottomNavigationFragment extends Fragment {

    public static final String TAG = "Buttom Navigation";

    private static Component mInstance;

    BottomNavigationView bottomNav;

    public BottomNavigationFragment() {
        // Required empty public constructor
    }

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_bottomnav_mobile_portrait);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottom_navigation, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomNav = view.findViewById(R.id.bottomNav);

        bottomNav.getOrCreateBadge(R.id.action_start).setNumber(5); // sets notifications on the icons
        BadgeDrawable favoriteBatch = bottomNav.getOrCreateBadge(R.id.action_favorites); // sets notifications on the icons
        //bottomNav.removeBadge(R.id.action_favorites);

        favoriteBatch.setBackgroundColor(Color.CYAN);
        favoriteBatch.setBadgeTextColor(Color.MAGENTA);
        favoriteBatch.setNumber(2);





    }
}