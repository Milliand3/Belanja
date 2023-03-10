package com.example.myapplication.activity.barang

import com.example.myapplication.model.BarangItem
import com.google.gson.annotations.SerializedName

data class ResultDataBarang(

	@field:SerializedName("barang")
	val barang: List<BarangItem?>? = null
)