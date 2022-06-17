package com.mustafaunlu.cryptokotlin.adapter

import android.graphics.Color
import android.location.GnssAntennaInfo
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.mustafaunlu.cryptokotlin.model.CryptoModel
import android.view.View
import android.view.ViewGroup
import com.mustafaunlu.cryptokotlin.R
import kotlinx.android.synthetic.main.recycler_row.view.*


class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>, private val listener : Listener) :
    RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
    interface Listener{
        fun onItemOnClick(cryptoModel: CryptoModel)
    }

    private val colors : Array<String> = arrayOf("#006e4e","#003153","#433966","#e6bf33","#ff8d00","#8e7cc3")

    class RowHolder(view : View) : RecyclerView.ViewHolder(view) {

        fun bind(cryptoModel: CryptoModel, colors : Array<String>,position: Int, listener  : Listener){
            itemView.setOnClickListener{
                listener.onItemOnClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 6]))
            itemView.cryptoNameTextView.text=cryptoModel.currency
            itemView.priceTextView.text=cryptoModel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position,listener)
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }
}