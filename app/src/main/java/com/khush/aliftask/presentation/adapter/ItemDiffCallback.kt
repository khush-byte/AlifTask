package com.khush.aliftask.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.khush.aliftask.data.models.ItemData

object ItemDiffCallback: DiffUtil.ItemCallback<ItemData>(){
    override fun areItemsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ItemData, newItem: ItemData): Boolean {
        return oldItem == newItem
    }
}