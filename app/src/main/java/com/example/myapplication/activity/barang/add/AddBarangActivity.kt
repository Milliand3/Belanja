package com.example.myapplication.activity.barang.add

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.model.BarangItem
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable

class AddBarangActivity : BaseActivity(),AddBarangView {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_barang)

        val intent = intent.getSerializableExtra(TAGS.BARANG)

                if(intent!=null){
                    setActionEditButton(intent)
                }else{
                    setActionTambahButton()
                }

    }
    private fun setActionEditButton(serializable: Serializable){
        findViewById<Button>(R.id.btAddBarang).text = "Simpan"
        val barang = serializable as BarangItem
        findViewById<EditText>(R.id.etAddBarangBarcode).setText(barang.barcode)
        findViewById<EditText>(R.id.etAddBarangNamaBarang).setText(barang.namaBarang)
        findViewById<EditText>(R.id.etAddBarangKategori).setText(barang.kategori)
        findViewById<EditText>(R.id.etAddBarangHargaBeli).setText(barang.hargaBeli.toString())
        findViewById<EditText>(R.id.etAddBarangHargaJual).setText(barang.hargaJual.toString())


        findViewById<Button>(R.id.btAddBarang).setOnClickListener{
            val barcode = findViewById<EditText>(R.id.etAddBarangBarcode).text.toString()
            val nama_barang = findViewById<EditText>(R.id.etAddBarangNamaBarang).text.toString()
            val kategori = findViewById<EditText>(R.id.etAddBarangKategori).text.toString()
            val harga_beli_s = findViewById<EditText>(R.id.etAddBarangHargaBeli).text.toString()
            val harga_jual_s = findViewById<EditText>(R.id.etAddBarangHargaJual).text.toString()

            if(harga_beli_s.isNotBlank() && harga_jual_s.isNotBlank()){
                val harga_beli = harga_beli_s.toDouble()
                val harga_jual = harga_jual_s.toDouble()

                //buat objek barang
                barang.idUser = user?.id_user
                barang.barcode = barcode
                barang.namaBarang = nama_barang
                barang.kategori = kategori
                barang.hargaBeli = harga_beli
                barang.hargaJual = harga_jual

                //simpan ke database
                AddBarangPresenter(this@AddBarangActivity).updateBarang(barang)
            }else{
                //jangan input
                Snackbar.make(it,"Harga tidak boleh kosong",Snackbar.LENGTH_SHORT)
            }

        }



    }
    private fun setActionTambahButton(){
        findViewById<Button>(R.id.btAddBarang).setOnClickListener{
            findViewById<Button>(R.id.btAddBarang).text = "Tambah"
            val barcode = findViewById<EditText>(R.id.etAddBarangBarcode).text.toString()
            val nama_barang = findViewById<EditText>(R.id.etAddBarangNamaBarang).text.toString()
            val kategori = findViewById<EditText>(R.id.etAddBarangKategori).text.toString()
            val harga_beli_s = findViewById<EditText>(R.id.etAddBarangHargaBeli).text.toString()
            val harga_jual_s = findViewById<EditText>(R.id.etAddBarangHargaJual).text.toString()

            if(harga_beli_s.isNotBlank()&&harga_jual_s.isNotBlank()){
                val harga_beli = harga_beli_s.toDouble()
                val harga_jual = harga_jual_s.toDouble()

                //buat objek barang
                var barang = BarangItem()
                barang.idUser = user?.id_user
                barang.barcode = barcode
                barang.namaBarang = nama_barang
                barang.kategori = kategori
                barang.hargaBeli = harga_beli
                barang.hargaJual = harga_jual

                //simpan ke database
                AddBarangPresenter(this@AddBarangActivity).addBarang(barang)
            }
            else{
                //jangan input
                Snackbar.make(it,"Harga tidak boleh kosong",Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSuccessAddBarang(msg: String?) {
       Toast.makeText(this@AddBarangActivity, "DATA BERHASIL DITAMBAHKAN",Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onErrorAddBarang(msg: String) {
        Toast.makeText(this@AddBarangActivity,"TOLOL",Toast.LENGTH_SHORT).show()
    }
}