package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.button.MaterialButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    public static final String TAG = "menu";

    private MaterialButton btnMenu;
    private AutoCompleteTextView autoCompleteTextView;


    private static Component mInstance;

    public MenuFragment() {
        // Required empty public constructor
    }

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_menu);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        btnMenu = view.findViewById(R.id.btnMenuPopUp);
        autoCompleteTextView = view.findViewById(R.id.autoCompleteCourses);


        //This button inflates menu when clicked
        btnMenu.setOnClickListener(view1 -> {
            PopupMenu popupMenu = new PopupMenu(getActivity(), view1);

            popupMenu.getMenuInflater().inflate(R.menu.menu_bottom_nav, popupMenu.getMenu());
            popupMenu.show();
        });

        String[] courses = new String[]{
                "Experto en firebase para android MVP +30 horas ",
                "Material Design/Theming para android",
                "Android fundamentos",
                "Kotlin 2020"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.item_menu_dropdown,courses);

        autoCompleteTextView.setAdapter(adapter);


        super.onViewCreated(view, savedInstanceState);
    }
}
