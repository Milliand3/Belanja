package com.example.myapplication.base

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import com.example.myapplication.model.User


@Suppress("DEPRECATION")
@SuppressLint("Registered")
open class BaseActivity {
    object TAGS{
        val BARANG = "barang"
        val USER = "user"
    }
    var user: User?=null

    fun CekSesi(activity: Activity) {
        val intent = activity.intent.getSerializableExtra("user")

        if (intent == null) {
            Toast.makeText(activity, "ANDA BELUM LOGIN BRO", Toast.LENGTH_SHORT)
            activity.finish()
        }
    }
}

