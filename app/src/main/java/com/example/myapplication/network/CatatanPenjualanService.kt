package com.example.myapplication.network

import com.example.myapplication.ResultSimple
import com.example.myapplication.activity.barang.ResultDataBarang
import com.example.myapplication.activity.login.ResultLogin
import com.example.myapplication.model.BarangItem
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
    fun getDataBarang(@Field("id_user") id_user: Int?)
            : Call<ResultDataBarang>

    @FormUrlEncoded
    @POST("barang/create.php")
    fun addBarang(@Field("id_user") id_user: Int?,
                  @Field("barcode") barcode: String?,
                  @Field("nama_barang") nama_barang: String?,
                  @Field("kategori") kategori: String?,
                  @Field("harga_beli") harga_beli: Double?,
                  @Field("harga_jual") harga_jual: Double?, )
            : Call<BarangItem>

    @FormUrlEncoded
    @POST("barang/edit.php")
    fun updateBarang(@Field("id_user") id_user: Int?,
                     @Field("id_barang") id_bareng: Int?,
                     @Field("barcode") barcode: String?,
                     @Field("nama_barang") nama_barang: String?,
                     @Field("kategori") kategori: String?,
                     @Field("harga_beli") harga_beli: Double?,
                     @Field("harga_jual") harga_jual: Double?, )
            : Call<BarangItem>

    @FormUrlEncoded
    @POST("barang/delete.php")
    fun deleteBarang(@Field("id_barang") id_barang: Int?)
            :Call<ResultSimple>



}