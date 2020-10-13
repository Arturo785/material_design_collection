package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFieldFragmentFragment extends Fragment {

    public static final String TAG = "TextField";

    TextInputLayout textInputCapitalLetter;
    TextInputLayout textInputPrice;

    private static Component mInstance;

    public TextFieldFragmentFragment() {
        // Required empty public constructor
    }

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_textfields_outlined_active);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text_field, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textInputCapitalLetter = view.findViewById(R.id.textInputLayoutCapitalLetter);
        textInputPrice = view.findViewById(R.id.textInputPrice);

        //Custom action
        //Sets the text to UPPER if icon clicked
        textInputCapitalLetter.setEndIconOnClickListener(view1 -> {
            if (textInputCapitalLetter.getEditText().getText() != null){
                String contentStr = textInputCapitalLetter.getEditText().getText().toString();
                textInputCapitalLetter.getEditText().setText(contentStr.toUpperCase());
            }
        });

        textInputPrice.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty() && Integer.parseInt(editable.toString()) < 5){
                    textInputPrice.getEditText().setError(getString(R.string.error_price_min));
                }
            }
        });




    }
}
