package com.alain.cursos.mdcomponents.utils;

/* *
 * Project: MD Components from com.alain.cursos.mdcomponents.utils
 * Created by Alain Nicolás Tello on 13/09/2019 at 06:03 PM
 * All rights reserved 2019.
 * Course Material Design and Theming for Android
 * More info: https://www.udemy.com/especialidad-en-firebase-para-android-con-mvp-profesional/
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.fragments.BottomNavigationFragment;
import com.alain.cursos.mdcomponents.fragments.ButtonFragment;
import com.alain.cursos.mdcomponents.fragments.CheckBoxFragment;
import com.alain.cursos.mdcomponents.fragments.FloatingActionButtonFragment;
import com.alain.cursos.mdcomponents.fragments.SnackBarFragment;
import com.alain.cursos.mdcomponents.fragments.TextFieldFragmentFragment;

public class CommonUtils {

    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRes){
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction()
                .add(contentRes, fragment)
                .commit();
    }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment){
            //SCROLL
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
                break;

            case TextFieldFragmentFragment.TAG:
                fragment = new TextFieldFragmentFragment();
                break;

            case CheckBoxFragment.TAG:
                fragment = new CheckBoxFragment();
                break;

            //STATIC
            case BottomNavigationFragment.TAG:
                fragment = new BottomNavigationFragment();
                break;

            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
                break;

            case FloatingActionButtonFragment.TAG:
                fragment = new FloatingActionButtonFragment();
                break;
        }

        return fragment;
    }
}
