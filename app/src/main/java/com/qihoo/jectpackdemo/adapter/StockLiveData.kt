package com.qihoo.jectpackdemo.adapter

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import java.math.BigDecimal

class StockLiveData(symbol: String) : LiveData<BigDecimal>() {

    private val listener = { price: BigDecimal ->
        value = price
    }

    override fun onActive() {

    }

    override fun onInactive() {


    }

    companion object {
        private lateinit var sInstance: StockLiveData

        @MainThread
        fun get(symbol: String): StockLiveData {
            sInstance = if (::sInstance.isInitialized) sInstance else StockLiveData(symbol)
            return sInstance
        }
    }
}