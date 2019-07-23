package com.qihoo.jectpackdemo.ui.actvity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qihoo.jectpackdemo.R
import com.qihoo.jectpackdemo.adapter.ItemAdapter
import com.qihoo.jectpackdemo.databinding.ItemLayoutBinding
import com.qihoo.jectpackdemo.model.LiveDataDemo
import com.qihoo.jectpackdemo.model.UserModel
import com.qihoo.jectpackdemo.ui.fragment.log
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var datas: ArrayList<UserModel>

    val mutableLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val liveDataDemo: LiveDataDemo by lazy {
        LiveDataDemo()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
    }

    private fun initData() {
        datas = ArrayList()


        for (i in 1..100) {
            UserModel().apply {
                name = "awen$i"
                sex = if (i % 2 == 0) {
                    "男"
                } else {
                    "女"
                }
                age = i
                datas.add(this)
            }
        }


        liveDataDemo.observe(this) { value: String ->
            log("收到数据变化:$value")
        }

        // 数据做转化，mutableLiveData收到数据，转化成其他数据
        Transformations.map(mutableLiveData) { value: String ->
            // 不可以延迟操作，因为本质还在一条流水线上
            value.toInt()
        }.observe(this, androidx.lifecycle.Observer {
            log("收到map转化:$it")
        })

        // switchMap转化
        Transformations.switchMap(mutableLiveData) {
            val temp: MutableLiveData<String> = MutableLiveData()
            // 可以做延迟操作
            Thread(Runnable {
                Thread.sleep(4000)
                temp.postValue("121")
            }).start()
            temp
        }.observe(this){
            log("收到数据变换了：$it")
        }

        // 总结：map和switchMap做对比，就和RxJava的map和flatMap作对比



    }

    private fun initView() {
        findViewById<RecyclerView>(R.id.recyclerview).apply {
            adapter = ItemAdapter(datas)
        }
    }

    fun change(view: View) {
        datas[0].name = "修改了哦"
        liveDataDemo.changeValue("尝试修改数据")
        mutableLiveData.value = "121"
    }
}
