package com.qihoo.jectpackdemo.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.qihoo.jectpackdemo.R

/**
 *
 * Created by wenyingzhi on 2019-07-18.
 */


class RegisterFragment : Fragment() {
    fun log(message: String) = Log.d("wyz", message)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_register, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 获取传入的参数
        val args: RegisterFragmentArgs by navArgs()
        val name = args.name
        log("收到数据：${name}")
        view.findViewById<View>(R.id.click).setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_mainActivity)
        }
    }
}