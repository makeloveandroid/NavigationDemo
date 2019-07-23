package com.qihoo.jectpackdemo.ui.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.qihoo.jectpackdemo.R
import com.qihoo.jectpackdemo.databinding.LayoutRegisterBinding
import com.qihoo.jectpackdemo.model.Register
import kotlin.math.log

/**
 *
 * Created by wenyingzhi on 2019-07-18.
 */

fun log(message: String) = Log.d("wyz", message)


class RegisterFragment : Fragment() {

    fun showToast(message: String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()


    val register = Register("awen", "1234")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        // 方案1：使用生成类生成
//        val bindidng = LayoutRegisterBinding.inflate(inflater)
        // 方案2：使用DataBindingUtil
        val bindidng = DataBindingUtil.inflate<LayoutRegisterBinding>(inflater, R.layout.layout_register, null, false)

//        // 方案3：View绑定
//        val view = inflater.inflate(R.layout.layout_register, null)
//        val bindidng = DataBindingUtil.bind<LayoutRegisterBinding>(view)

        register.remark = "初始化值"

        // 赋值数据
        bindidng.apply {
            this.register = this@RegisterFragment.register
            this.activity = this@RegisterFragment
        }
        return bindidng?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 获取传入的参数
//        val args: RegisterFragmentArgs by navArgs()
//        val name = args.name
//        log("收到数据：${name}")
//        view.findViewById<View>(R.id.click).setOnClickListener {
//            findNavController().navigate(R.id.action_registerFragment_to_mainActivity)
//        }
    }

    fun login() {
        showToast("${register.user.get() + "  " + register.pass.get()}")
    }

    fun clear(view: View) {
        register.user.set("")
        register.pass.set("")
    }

    fun changeRemark() {
        register.remark = "我要进行修改"
    }

}


@BindingAdapter("loadImage")
fun loadImage(iv: ImageView, url: String) {
    log("加载图片：$iv $url")
}

/**
 * 多属性
 * 可以配置多个，每个属性对应一个形参
 * 默认requireAll是ture（意思2个属性一定要同时存在）
 * 默认requireAll是false（意思2个属性不一定要同时存在，注意判断非空）
 */
@BindingAdapter("paddingLeftAndRight", "paddingTopAndBottom", requireAll = false)
fun pandCenterView(view: View, leftRight: Int = 0, topBottom: Int = 0) {
    view.setPadding(leftRight, topBottom, leftRight, topBottom)
}

/**
 * 这种的在自定义view中自定义属性比较常用，对应属性+对应方法
 */
//@BindingMethods(value = [
//    BindingMethod(
//        type = ImageView::class,
//        attribute = "android:tint",
//        method = "setImageTintList")])


@BindingConversion
fun convertColorToDrawable(colorStr: String): Drawable {
    log("收到转换：$colorStr")
  return ColorDrawable(Color.RED)
}


