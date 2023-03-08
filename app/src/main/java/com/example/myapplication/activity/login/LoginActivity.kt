package com.example.myapplication.activity.login


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.model.User

class LoginActivity : AppCompatActivity(), LoginView {
    lateinit var etUsername:EditText
    lateinit var etPassword:EditText
    lateinit var btLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById<EditText>(R.id.username)
        etPassword = findViewById<EditText>(R.id.password)
        btLogin = findViewById<Button>(R.id.button_login)

        InitActionButton()

    }

    private fun InitActionButton(){
        btLogin.setOnClickListener{
            val user = User()
            user.username = etUsername.text.toString().trim()
            user.password = etPassword.text.toString().trim()

            LoginPresenter(this@LoginActivity).login(user)
        }
    }

    override fun onSuccessLogin(user: User?){
        Toast.makeText(this,"Berhasil Login", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(BaseActivity.TAGS.USER, user)
        }
    finish()
        startActivity(intent)

    }

    override fun onErrorLogin(msg: String?){
//        if(msg!!.isEmpty()){
//            Toast.makeText(this, "asdasd", Toast.LENGTH_SHORT).show()
//
//        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}