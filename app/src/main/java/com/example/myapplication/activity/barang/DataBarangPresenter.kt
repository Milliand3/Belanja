package com.example.myapplication.activity.barang

import com.example.myapplication.ResultSimple
import com.example.myapplication.model.BarangItem
import com.example.myapplication.model.User
import com.example.myapplication.network.networkclass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataBarangPresenter(val dataBarangView: DataBarangView) {
    fun getDataBarang(user: User?) {
        networkclass.service()
            .getDataBarang(user?.id_user)
            .enqueue(object : Callback<ResultDataBarang> {
                override fun onFailure(call: Call<ResultDataBarang>, t: Throwable) {
                    dataBarangView.onErrorDataBarang(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultDataBarang>,
                    response: Response<ResultDataBarang>
                ) {
                    val body = response.body()
                    dataBarangView.onSuccessDataBarang(body?.barang)
                }
            })
    }

    fun deleteBarang(barangItem: BarangItem?) {
        networkclass.service()
            .deleteBarang(barangItem?.idBarang)
            .enqueue(object : Callback<ResultSimple> {
                override fun onFailure(call: Call<ResultSimple>, t: Throwable) {
                    dataBarangView.onErrorDataBarang(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultSimple>,
                    response: Response<ResultSimple>
                ) {
                    val body = response.body()
                    if (body?.status == "200") {
                        dataBarangView.onSuccessDeleteBarang(body.message)
                    } else {
                        dataBarangView.onErrorDeleteBarang(body?.message)
                    }
                }
            })
    }
}