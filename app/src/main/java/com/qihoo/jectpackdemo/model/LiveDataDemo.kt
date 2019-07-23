package com.qihoo.jectpackdemo.model

import androidx.lifecycle.LiveData
import com.qihoo.jectpackdemo.ui.fragment.log

/**
 *
 * Created by wenyingzhi on 2019-07-22.
 */
class LiveDataDemo : LiveData<String>() {


    override fun onActive() {
        log("LiveDataDemo:onActive")
        super.onActive()
    }

    override fun onInactive() {
        log("LiveDataDemo:onInactive")
        super.onInactive()
    }

    fun changeValue(value: String) {
        this.value = value
    }
}