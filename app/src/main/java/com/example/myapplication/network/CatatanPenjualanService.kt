package com.example.myapplication.network

import com.example.myapplication.activity.barang.ResultDataBarang
import com.example.myapplication.activity.login.ResultLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CatatanPenjualanService {
    @FormUrlEncoded
    @POST("user/read.php")
    fun loginUser(@Field("username")username:String?,
                    @Field("password")password:String?)
                        : Call<ResultLogin>

    @FormUrlEncoded
    @POST("barang/read.php")
    fun loginUser(@Field("nama_barang")nama_barang:String?)
            : Call<ResultDataBarang>
}