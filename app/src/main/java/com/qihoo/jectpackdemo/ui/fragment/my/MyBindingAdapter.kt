package com.qihoo.jectpackdemo.ui.fragment.my

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * Created by wenyingzhi on 2019-07-23.
 */
@BindingAdapter("adapter")
fun <T : RecyclerView.ViewHolder> setAdapter(
    recyclerView: RecyclerView,
    recyclerViewAdapter: RecyclerView.Adapter<T>
) {
    recyclerView.adapter = recyclerViewAdapter
}