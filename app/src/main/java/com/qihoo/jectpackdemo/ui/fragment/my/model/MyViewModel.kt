package com.qihoo.jectpackdemo.ui.fragment.my.model

import android.os.SystemClock
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.qihoo.jectpackdemo.ui.fragment.my.adapter.MyAdapter
import com.qihoo.jectpackdemo.ui.fragment.my.bean.MyData

/**
 *
 * Created by wenyingzhi on 2019-07-23.
 */
class MyViewModel() : ViewModel() {
    val title: MutableLiveData<String> by lazy {
        MutableLiveData<String>("默认标题")
    }

    @MainThread
    fun notify(it: List<MyData>) {
        datas.addAll(it)
        adatper.notifyDataSetChanged()
    }

    val adatper by lazy {
        MyAdapter(datas)
    }

    val datas = ArrayList<MyData>()

    val id: MutableLiveData<Int> = MutableLiveData()
    var result: LiveData<List<MyData>>

    init {
        result = Transformations.switchMap(id) {
            // 模拟延迟加载数据
            val liveData = MutableLiveData<List<MyData>>()
            Thread {
                SystemClock.sleep(5000)
                val datas = ArrayList<MyData>()
                for (i in 1..100) {
                    datas.add(MyData("awen$i"))
                }
                liveData.postValue(datas)
            }.start()
            liveData
        }
    }
}