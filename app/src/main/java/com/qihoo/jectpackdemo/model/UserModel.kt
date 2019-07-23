package com.qihoo.jectpackdemo.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.qihoo.jectpackdemo.BR

/**
 *
 * Created by wenyingzhi on 2019-07-19.
 */
class UserModel : BaseObservable() {
    @get:Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var sex: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var age: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.age)
        }
}