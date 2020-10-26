package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFragment extends Fragment {

    public static final String TAG = "Dialog";

    private static Component mInstance;

    Unbinder mUnbider;

    public DialogFragment() {
        // Required empty public constructor
    }

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_dialog_mobile_alert);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        mUnbider = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbider.unbind();
    }

    @OnClick(R.id.btnDialog1)
    public void onInfoClicked(){
        new MaterialAlertDialogBuilder(getActivity())
               .setTitle(R.string.card_message_demo_small)
                .setPositiveButton(R.string.dialog_ok, null)
                .show();
    }

    @OnClick(R.id.btnDialog2)
    public void onChooserClicked(){
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.select_dialog_item);

        adapter.add("Opcion 1");
        adapter.add("Opcion 2");
        adapter.add("Opcion 3");

        new MaterialAlertDialogBuilder(getActivity())
                .setTitle(R.string.dialog_chooser)
                .setAdapter(adapter, (dialogInterface, i) -> Toast.makeText(getActivity(), adapter.getItem(i),Toast.LENGTH_LONG).show())
                .show();
    }

    @OnClick(R.id.btnDialog3)
    public void onConfirm(){
       // new MaterialAlertDialogBuilder(getActivity()) default one
          new MaterialAlertDialogBuilder(getActivity(), R.style.ThemeOverlay_MaterialComponents_Dialog)
                .setTitle(R.string.dialog_confirm_title)
                .setMessage(R.string.card_message_demo_small)
                .setPositiveButton(R.string.dialog_confirm, null)
                .setNegativeButton(R.string.dialog_cancel, null)
                .show();
    }

    @OnClick(R.id.btnDialog4)
    public void fullDialogButton(){
        FullDialogFragment aaa = new FullDialogFragment();
    }
}
