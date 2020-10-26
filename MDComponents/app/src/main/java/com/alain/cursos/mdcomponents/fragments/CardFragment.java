package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.chip.Chip;

import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment {

    public static final String TAG = "Card";

    private AppCompatImageView imageNeji;

    private static Component mInstance;

    private Chip chip2;
    private Chip chip3;

    public CardFragment() {
        // Required empty public constructor
    }

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_cards_template);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageNeji = view.findViewById(R.id.imageCardLarge);
        chip2 = view.findViewById(R.id.chip2);
        chip3 = view.findViewById(R.id.chip3);

        RequestOptions options = new RequestOptions().
                diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();


        Glide.with(this)
                .load("https://scx2.b-cdn.net/gfx/news/2019/2-nature.jpg")
                .apply(options)
                .into(imageNeji);

        chip2.setOnCheckedChangeListener((compoundButton, checked) -> {
            if (checked){
                Toast.makeText(getActivity(), "checked", Toast.LENGTH_LONG).show();
            }
        });

        chip3.setOnCloseIconClickListener(view1 -> {
            chip3.setVisibility(View.GONE);
        });
    }

}
