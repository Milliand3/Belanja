package com.example.myapplication.base

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.User


@Suppress("DEPRECATION")
@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    object TAGS{
        val BARANG = "barang"
        val USER = "user"
    }
    var user: User?=null

    fun cekSesi(activity: Activity) {
        val intent = activity.intent.getSerializableExtra("user")

        if (intent == null) {
            Toast.makeText(activity, "ANDA BELUM LOGIN BRO", Toast.LENGTH_SHORT)
            activity.finish()
        } else {
            user = intent as User
        }

    }
}

