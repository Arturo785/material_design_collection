package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.BottomAppBarCutCornersTopEdge;
import com.alain.cursos.mdcomponents.utils.Component;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.snackbar.Snackbar;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppBottomBarFragment extends DialogFragment {

    public static final String TAG = "appBarBottom";

    private static Component mInstance;

    private BottomAppBar toolbar;
    private FloatingActionButton fab;
    private CoordinatorLayout containerMain;

    private boolean isCentered;

    Unbinder mUnbider;

    public AppBottomBarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_bar_bottom, container, false);
        mUnbider = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        toolbar = view.findViewById(R.id.bottom_app_bar);
        fab = view.findViewById(R.id.fav);
        containerMain = view.findViewById(R.id.containerMain);

        toolbar.setOnMenuItemClickListener(item -> {
            int resMessage = 0;

            switch (item.getItemId()){
                case R.id.action_favorites:
                    resMessage = R.string.menu_favorites;
                    break;

                case R.id.action_profile:
                    resMessage = R.string.menu_profile;
                    break;

                case R.id.action_start:
                    resMessage = R.string.menu_start;
                    break;
            }
            Snackbar.make(containerMain,resMessage, Snackbar.LENGTH_LONG)
                    .setAnchorView(fab) // says it where to appear
                    .show();

            return true;
        });

        toolbar.setNavigationOnClickListener(view1 -> {
            Snackbar.make(containerMain,"Clicked", Snackbar.LENGTH_LONG)
                    .setAnchorView(fab) // says it where to appear
                    .show();
        });

        //To make the bottom bar with corner shape cuts

        BottomAppBarCutCornersTopEdge topEdge = new BottomAppBarCutCornersTopEdge(
                toolbar.getFabCradleMargin(),
                toolbar.getFabCradleRoundedCornerRadius(),
                toolbar.getCradleVerticalOffset()
        );

        MaterialShapeDrawable shapeDrawable = (MaterialShapeDrawable) toolbar.getBackground();

        shapeDrawable.setShapeAppearanceModel(shapeDrawable.getShapeAppearanceModel().toBuilder()
        .setTopEdge(topEdge).build());


        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbider.unbind();
    }

    @OnClick(R.id.fav)
    public void onViewClicked(){
        if (isCentered){
            toolbar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
        }
        else {
            toolbar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        }
        isCentered = !isCentered;
    }

}
