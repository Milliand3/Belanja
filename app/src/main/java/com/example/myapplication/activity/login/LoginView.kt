package com.example.myapplication.activity.login

import com.example.myapplication.model.User

interface LoginView {
    fun onSuccessLogin(user:User?)
    fun onErrorLogin(msg:String?)

}