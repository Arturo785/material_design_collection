package com.alain.cursos.mdcomponents.adapters;

/* *
 * Project: MD Components from com.alain.cursos.mdcomponents.adapters
 * Created by Alain Nicolás Tello on 13/09/2019 at 04:59 PM
 * All rights reserved 2019.
 * Course Material Design and Theming for Android
 * More info: https://www.udemy.com/especialidad-en-firebase-para-android-con-mvp-profesional/
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.OnClickListener;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ViewHolder> {

    private List<Component> mComponents;
    private OnClickListener mListener;

    public ComponentAdapter(List<Component> mComponents, OnClickListener mListener) {
        this.mComponents = mComponents;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_component, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Component component = mComponents.get(position);

        holder.setClickListener(mListener, component);

        holder.tvName.setText(component.getName());
        holder.imgPhoto.setImageResource(component.getPhotoRes());
    }

    @Override
    public int getItemCount() {
        return mComponents.size();
    }

    public void add(Component component){
        if (!mComponents.contains(component)){
            mComponents.add(component);
            notifyItemInserted(mComponents.size() - 1);
        }
    }

    public void reverse() {
        Collections.reverse(mComponents);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgPhoto)
        AppCompatImageView imgPhoto;
        @BindView(R.id.tvName)
        TextView tvName;

        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }

        void setClickListener(OnClickListener listener, Component component){
            view.setOnClickListener(view1 -> listener.onClick(component));
        }
    }
}
