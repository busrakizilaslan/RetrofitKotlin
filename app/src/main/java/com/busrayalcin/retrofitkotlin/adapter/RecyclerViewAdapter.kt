package com.busrayalcin.retrofitkotlin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busrayalcin.retrofitkotlin.R
import com.busrayalcin.retrofitkotlin.model.CryptoModel
import kotlinx.android.synthetic.main.row_layout.view.*

class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>, private val listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    private val colors : Array<String> = arrayOf("#363b74", "#673888", "#ef4f91", "#c79dd7", "#4d1b7b", "#0f5e9c", "#2389da", "#1ca3ec", "#5abcd8", "#74ccf4")

    interface Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }

    class RowHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(cryptoModel: CryptoModel, colors: Array<String>, position: Int, listener : Listener ){
            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 10]))
            itemView.nameText.text = cryptoModel.currency
            itemView.priceText.text = cryptoModel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position,listener)
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }
}