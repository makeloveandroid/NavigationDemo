package com.qihoo.jectpackdemo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.qihoo.jectpackdemo.R
import com.qihoo.jectpackdemo.databinding.ItemLayoutBinding
import com.qihoo.jectpackdemo.model.UserModel

/**
 *
 * Created by wenyingzhi on 2019-07-19.
 */
class ItemViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

class ItemAdapter(val datas: List<UserModel>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun getItemCount(): Int {
        return datas?.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.user = datas[position]
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = LayoutInflater.from(parent.context).let {
            ItemLayoutBinding.inflate(it, parent, false)
        }

        return ItemViewHolder(binding)
    }

}
