package com.qihoo.jectpackdemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.qihoo.jectpackdemo.R

/**
 *
 * Created by wenyingzhi on 2019-07-18.
 */
class DetialFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_detial, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.click).setOnClickListener {
           findNavController().navigate(R.id.action_detialFragment_to_mainActivity)
        }
    }
}