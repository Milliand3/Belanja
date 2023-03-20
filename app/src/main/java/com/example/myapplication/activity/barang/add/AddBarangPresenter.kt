package com.example.myapplication.activity.barang.add

import com.example.myapplication.model.BarangItem
import com.example.myapplication.network.networkclass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddBarangPresenter (val addBarangView: AddBarangView){
    fun addBarang(dataBarangItem: BarangItem){
        networkclass.service()
            .addBarang(dataBarangItem.idUser,dataBarangItem.barcode,
            dataBarangItem.namaBarang,dataBarangItem.kategori,dataBarangItem.hargaBeli,dataBarangItem.hargaJual)
            .enqueue(object : Callback<BarangItem>{
                override fun onFailure(call: Call<BarangItem>, t: Throwable) {
                    addBarangView.onErrorAddBarang(t.localizedMessage)
                }

                override fun onResponse(call: Call<BarangItem>, response: Response<BarangItem>) {
                    val body = response.body()
                    addBarangView.onSuccessAddBarang(body?.namaBarang)

                }
            })
    }

    fun updateBarang(dataBarangItem: BarangItem){
        networkclass.service()
            .updateBarang(dataBarangItem.idUser,dataBarangItem.idBarang,dataBarangItem.barcode,
            dataBarangItem.namaBarang,dataBarangItem.kategori, dataBarangItem.hargaBeli,dataBarangItem.hargaJual)
            .enqueue(object :Callback<BarangItem>{
                override fun onFailure(call: Call<BarangItem>, t: Throwable) {
                    addBarangView.onErrorAddBarang(t.localizedMessage)

                }

                override fun onResponse(call: Call<BarangItem>, response: Response<BarangItem>) {
                    val body = response.body()
                    addBarangView.onSuccessAddBarang(body?.namaBarang)
                }
            })
    }
}