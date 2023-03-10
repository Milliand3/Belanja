package com.example.penjualan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R


class MenuAdapter (val onMenuClick: OnMenuClick):
    RecyclerView.Adapter<MenuAdapter.MyHolder>(){
    private  val menu = arrayOf(
        arrayOf(R.drawable.ic_goods,"Data Barang"),
        arrayOf(R.drawable.ic_shopping_cart,"Penjualan")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu,parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int=menu.size

    override fun onBindViewHolder(holder: MenuAdapter.MyHolder, position: Int) {
        holder.bind(menu.get(position)[0] as Int, menu.get(position)[1] as String)
        holder.itemView.setOnClickListener{
            onMenuClick.onClick(menu.get(position)[0] as Int)
        }
    }

    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(any:Int, any1: String){
            itemView.findViewById<ImageView>(R.id.mainMenu).setImageResource(any)
            itemView.findViewById<TextView>(R.id.menuText).text = any1

        }
    }

    interface OnMenuClick{
        fun onClick(image:Int)
    }
}