package com.qihoo.jectpackdemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.qihoo.jectpackdemo.R


/**
 * 登录的Fragment
 *
 * A simple [Fragment] subclass.
 */
class LoginFragment : androidx.fragment.app.Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_login, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            findViewById<View>(R.id.register_btn).setOnClickListener {
                // 切换到注册界面 对应id就是在配置文件中生成的Action
                val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment("阿文")
                findNavController().navigate(action)
            }

            findViewById<View>(R.id.details_btn).setOnClickListener {
                // 切换到注册登陆界面
                findNavController().navigate(R.id.action_loginFragment_to_detialFragment)
            }
        }
    }
}
