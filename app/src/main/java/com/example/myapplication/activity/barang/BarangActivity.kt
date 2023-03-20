package com.example.myapplication.activity.barang


import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activity.barang.add.AddBarangActivity
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityBarangBinding
import com.example.myapplication.model.BarangItem
import com.google.android.material.floatingactionbutton.FloatingActionButton
@Suppress("DEPRECATION")
class BarangActivity : BaseActivity(), DataBarangView {


    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang)

        refreshBarangItem()
        findViewById<FloatingActionButton>(R.id.brAddDaaBarang).setOnClickListener{
            val intent = Intent(this, AddBarangActivity::class.java).apply {
                putExtra(TAGS.USER, user)
            }
            startActivity(intent)

        }
    }

    private fun refreshBarangItem() {
       DataBarangPresenter(this).getDataBarang(user)
    }

    override fun onSuccessDataBarang(data: List<BarangItem?>?) {
        findViewById<RecyclerView>(R.id.rvDataBarang).adapter = DataBarangAdapter(data, object :
            DataBarangAdapter.OnMenuClicked {
            override fun click(menuItem: MenuItem, barang: BarangItem?) {
                when (menuItem.itemId) {
                    R.id.editBarang -> editBarang(barang)
                    R.id.hapusBarang -> hapusBarang(barang)
                }
            }
        })
    }

    override fun onErrorDataBarang(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun editBarang(barang: BarangItem?) {
        val intent = Intent(this,AddBarangActivity::class.java)
        intent.putExtra(TAGS.USER,user)
        intent.putExtra(TAGS.BARANG,barang)

        startActivityForResult(intent,1)
            }

    override fun onSuccessDeleteBarang(msg: String?){
        Toast.makeText(this,"Berhasil menghapus barang", Toast.LENGTH_SHORT).show()
        refreshBarangItem()
    }

    override fun onErrorDeleteBarang(msg: String?){
        Toast.makeText(this,"Berhasil menghapus barang", Toast.LENGTH_SHORT).show()
        refreshBarangItem()
    }

    private fun hapusBarang(barang: BarangItem?) {
        val  builder = AlertDialog.Builder(this)
        builder.setTitle("Anda Yakin Untuk Menghapus Data")
        builder.setMessage("Anda akan menghapus data ${barang?.namaBarang}! apakah anda yakin?")
        builder.setPositiveButton("Yes"){dialog, which -> DataBarangPresenter(this).deleteBarang(barang)
        }
        builder.setNegativeButton("No") {dialog, which -> Toast.makeText(applicationContext,"Batal", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }



    override fun onResume() {
        super.onResume()
        refreshBarangItem()
    }
}