package com.example.myapplication.activity.barang

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.BarangItem
import com.example.penjualan.MenuAdapter

class DataBarangAdapter(val BarangItem: List<BarangItem?>?,val onMenuClicked: OnMenuClicked):RecyclerView.Adapter<DataBarangAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.item_data_barang,parent,
        false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int = BarangItem?.size?:0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(BarangItem?.get(position))

        holder.itemView.findViewById<ImageView>(R.id.ivMenuBarang).setOnClickListener{
            val popupMenu = PopupMenu(holder.itemView.context,it)
            popupMenu.menuInflater.inflate(R.menu.menu_barang,popupMenu.menu)
            popupMenu.show()

            popupMenu.setOnMenuItemClickListener {
                onMenuClicked.click(it,BarangItem?.get(position))
                true
            }
        }
    }
    class MyHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bind(barang:BarangItem?){
            itemView.findViewById<TextView>(R.id.tvBarcode).text = barang?.barcode
            itemView.findViewById<TextView>(R.id.tvNamaBarang).text = barang?.namaBarang
            itemView.findViewById<TextView>(R.id.tvCategory).text = barang?.kategori
        }
    }
    interface OnMenuClicked{
        fun click(menuItem: MenuItem, barang: BarangItem?)

    }
}