//package com.example.standard2

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.standard2.databinding.ItemListBinding
import androidx.recyclerview.widget.RecyclerView

//class DataRVAdaptor (private val dataList: ArrayList<Data>): RecyclerView.Adapter<DataRVAdaptor.DataViewHolder>(){
//    inner class DataViewHolder(private val viewBinding: ItemListBinding): RecyclerView.ViewHolder(viewBinding.root){
//        fun bind(data: Data) = with(viewBinding){
//            Memo.text = data.context
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
//        val viewBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return DataViewHolder(viewBinding)
//    }
//
//    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
//        holder.bind(dataList[position])
//    }
//
//    override fun getItemCount(): Int = dataList.size
//}