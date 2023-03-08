package com.example.myapplication.activity.login

import com.example.myapplication.model.User
import com.example.myapplication.network.networkclass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val LoginView: LoginView) {
    fun login(user: User) {
        networkclass.service()
            .loginUser(user.username, user.password)
            .enqueue(object : Callback<ResultLogin> {
                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    LoginView.onErrorLogin(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                    val body = response.body()
                    if (body?.status == "200") {
                        LoginView.onSuccessLogin(body.user)
                    } else {
                        LoginView.onErrorLogin(body?.pesan)

                    }
                }

            }

            )
    }
}