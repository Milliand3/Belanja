package com.example.myapplication

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.activity.barang.BarangActivity
import com.example.myapplication.activity.login.LoginActivity
import com.example.myapplication.activity.penjualan.PenjualanActivity
import com.example.myapplication.base.BaseActivity
import com.example.penjualan.MenuAdapter

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initActionButton()
        findViewById<TextView>(R.id.tvWelcome).text = "Welcome ${user?.username}"

    }

    fun initActionButton() {
        findViewById<RecyclerView>(R.id.mainMenu).adapter =
            MenuAdapter(object : MenuAdapter.OnMenuClick{


                override fun onClick(image: Int) {
                    when(image){
                        R.drawable.ic_goods -> openDataBarang()
                        R.drawable.ic_shopping_cart -> openDataPenjualan()
                    }
                }
            })

    }
    private fun openDataBarang() {
        val intent = Intent(this, BarangActivity::class.java).apply {
            putExtra(TAGS.USER, user)
        }
        startActivity(intent)
    }
    private fun openDataPenjualan(){
        val intent= Intent(this, PenjualanActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)

        return super.onOptionsItemSelected(item)
    }
}