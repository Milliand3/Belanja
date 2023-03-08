package com.example.myapplication.activity.login

import com.example.myapplication.model.User
import com.google.gson.annotations.SerializedName

data class ResultLogin(

	@field:SerializedName("pesan")
	val  pesan: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("status")
	val status: String? = null
)