package com.khush.aliftask.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.khush.aliftask.data.models.ItemData
import com.khush.aliftask.databinding.ItemInfoBinding
import com.squareup.picasso.Picasso

class ItemAdapter(private val context: Context): ListAdapter<ItemData, ItemViewHolder>(ItemDiffCallback) {

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            with(item) {
                itemName.text = name
                itemCity.text = startDate
                itemDate.text = endDate
                Picasso.get().load(icon).into(itemLogo)
                root.setOnClickListener {
                    onItemClickListener?.onItemClick(this)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(itemInfo: ItemData)
    }
}