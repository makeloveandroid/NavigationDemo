package com.qihoo.jectpackdemo.model

import android.media.audiofx.BassBoost
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.qihoo.jectpackdemo.BR
import com.qihoo.jectpackdemo.ui.fragment.log

/**
 *
 * Created by wenyingzhi on 2019-07-19.
 */
data class Register(var userName: String, var passWord: String) : BaseObservable() {
    val iconUrl: String = "http://www.baidu.com"

    var pass = ObservableField(passWord)
    var user = ObservableField(userName)

    @get:Bindable
    var remark: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.remark)
        }

    init {
        addOnPropertyChangedCallback(object :Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                log("onPropertyChanged$sender   $propertyId")
            }
        })
    }


}