package com.example.materialdesigncomponents.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesigncomponents.R
import com.example.materialdesigncomponents.models.Component
import kotlinx.android.synthetic.main.item_component.view.*

class ListAdapterComponent(private val interaction: Interaction? = null): RecyclerView.Adapter<ListAdapterComponent.ComponentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder {
        return ComponentViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_component,
                parent,
                false
            ), interaction)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {
        val item = differ.currentList[position]

        holder.itemView.apply {
            imagePhoto.setImageResource(item.photoRes)
            textViewName.text = item.name
            setOnClickListener {
                interaction?.onItemSelected(position, item)
            }
        }
    }

    inner class ComponentViewHolder(itemView: View,  private val interaction: Interaction?) : RecyclerView.ViewHolder(itemView) {
    }

    //Our anonymous object to check
    private val differCallBack = object : DiffUtil.ItemCallback<Component>() {
        override fun areItemsTheSame(oldItem: Component, newItem: Component): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Component, newItem: Component): Boolean {
            return oldItem == newItem // kotlin does object content and not referential equals so it's ok
        }
    }

    val differ = AsyncListDiffer(this,differCallBack)

    interface Interaction {
        fun onItemSelected(position: Int, item: Component)
    }
}
