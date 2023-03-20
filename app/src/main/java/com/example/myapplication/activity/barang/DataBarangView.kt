package com.example.myapplication.activity.barang

import com.example.myapplication.model.BarangItem

interface DataBarangView {
    fun onSuccessDataBarang(data:List<BarangItem?>?)
    fun onErrorDataBarang(msg:String?)
    fun onSuccessDeleteBarang(msg: String?)
    fun onErrorDeleteBarang(msg: String?)
}