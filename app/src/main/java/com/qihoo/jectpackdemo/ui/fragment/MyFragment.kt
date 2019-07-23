package com.qihoo.jectpackdemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.qihoo.jectpackdemo.R
import com.qihoo.jectpackdemo.databinding.MyBinding
import com.qihoo.jectpackdemo.ui.fragment.my.adapter.MyViewHolder
import com.qihoo.jectpackdemo.ui.fragment.my.bean.MyData
import com.qihoo.jectpackdemo.ui.fragment.my.model.MyViewModel


/**
 * 登录的Fragment
 *
 * A simple [Fragment] subclass.
 */
class MyFragment : androidx.fragment.app.Fragment() {
    val myViewModel by lazy {
        ViewModelProviders.of(this).get(MyViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = MyBinding.inflate(inflater)
        binding.vm = myViewModel
        binding.context = this@MyFragment
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myViewModel.result.observe(this, Observer {
            log("收到数据:刷新")
            myViewModel.notify(it)
        })
    }

    fun loadData() {
        myViewModel.id.value = 1
        myViewModel.title.value = "修改标题了"
    }
}
