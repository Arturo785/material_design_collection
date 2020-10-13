package com.alain.cursos.mdcomponents;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alain.cursos.mdcomponents.adapters.ComponentAdapter;
import com.alain.cursos.mdcomponents.fragments.BottomNavigationFragment;
import com.alain.cursos.mdcomponents.fragments.ButtonFragment;
import com.alain.cursos.mdcomponents.fragments.CheckBoxFragment;
import com.alain.cursos.mdcomponents.fragments.FloatingActionButtonFragment;
import com.alain.cursos.mdcomponents.fragments.SnackBarFragment;
import com.alain.cursos.mdcomponents.fragments.TextFieldFragmentFragment;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.alain.cursos.mdcomponents.utils.OnClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ComponentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configAdapter();
        configRecyclerView();
    }

    private void configAdapter() {
        mAdapter = new ComponentAdapter(new ArrayList<>(), this);
        mAdapter.add(ButtonFragment.getmInstance());
        mAdapter.add(BottomNavigationFragment.getmInstance());
        mAdapter.add(SnackBarFragment.getmInstance());
        mAdapter.add(TextFieldFragmentFragment.getmInstance());
        mAdapter.add(FloatingActionButtonFragment.getmInstance());
        mAdapter.add(CheckBoxFragment.getmInstance());
    }

    private void configRecyclerView() {
        recyclerView.setAdapter(mAdapter);
    }

    /*
    * OnClickListener
    * */
    @Override
    public void onClick(Component component) {
        Intent intent;
        if (component.getType() == Constants.SCROLL){
            intent = new Intent(this, ScrollActivity.class);
        } else { //STATIC
            intent = new Intent(this, StaticActivity.class);
        }
        intent.putExtra(Constants.ARG_NAME, component.getName());
        startActivity(intent);
    }
}
