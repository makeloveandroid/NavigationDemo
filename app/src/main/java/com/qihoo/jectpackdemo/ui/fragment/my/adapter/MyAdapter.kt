package com.qihoo.jectpackdemo.ui.fragment.my.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.qihoo.jectpackdemo.databinding.MyBinding
import com.qihoo.jectpackdemo.databinding.MyItemBinding
import com.qihoo.jectpackdemo.ui.fragment.my.bean.MyData

/**
 *
 * Created by wenyingzhi on 2019-07-23.
 */
class MyAdapter(val datas:List<MyData>) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false).let {
            MyViewHolder(it)
        }
    }

    override fun getItemCount(): Int {
       return datas?.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.data = datas[position]
        holder.binding.executePendingBindings()
    }


}

class MyViewHolder(val binding: MyItemBinding) : RecyclerView.ViewHolder(binding.root)