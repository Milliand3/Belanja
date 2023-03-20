package com.example.myapplication

import android.webkit.ConsoleMessage
import com.google.gson.annotations.SerializedName

data class ResultSimple(
    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("Message")
    val message: String? = null,
)
