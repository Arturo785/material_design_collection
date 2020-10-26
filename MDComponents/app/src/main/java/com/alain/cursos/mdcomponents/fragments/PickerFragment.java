package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.snackbar.Snackbar;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class PickerFragment extends Fragment {

    public static final String TAG = "picker";

    private LinearLayout containerMain;

    private static Component mInstance;

    Unbinder mUnbider;

    public PickerFragment() {
        // Required empty public constructor
    }

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.picker);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picker, container, false);
        mUnbider = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        containerMain = view.findViewById(R.id.containerMain);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbider.unbind();
    }

    @OnClick(R.id.btnPicker1)
    public void picker1Clicked(){
        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();

        builder.setTitleText(R.string.picker_title);

        builder.setSelection(System.currentTimeMillis()); // selects current time

        builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar);
        MaterialDatePicker<?> picker = builder.build();

        picker.addOnPositiveButtonClickListener(selection -> {
            Snackbar.make(containerMain, picker.getHeaderText(), Snackbar.LENGTH_LONG).show();
        });

        picker.show(getFragmentManager(),picker.toString());
    }

    @OnClick(R.id.btnPicker2)
    public void picker2Clicked(){
        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();

        builder.setTitleText(R.string.picker_title);

        builder.setSelection(System.currentTimeMillis()); // selects current time

        builder.setTheme(R.style.FullScreenPicker);
        MaterialDatePicker<?> picker = builder.build();

        picker.addOnPositiveButtonClickListener(selection -> {
            Snackbar.make(containerMain, picker.getHeaderText(), Snackbar.LENGTH_LONG).show();
        });

        picker.show(getFragmentManager(),picker.toString());
    }




}
