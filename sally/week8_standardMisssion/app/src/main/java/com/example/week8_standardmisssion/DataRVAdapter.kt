package com.example.week8_standardmisssion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week8_standardmisssion.databinding.ItemListBinding

class DataRVAdaptor (private val dataList: ArrayList<User>, val onClickDeleteBtn: (data: User) -> Unit) : RecyclerView.Adapter<DataRVAdaptor.DataViewHolder>(){
    inner class DataViewHolder(val viewBinding: ItemListBinding): RecyclerView.ViewHolder(viewBinding.root){
        fun bind(data: User) = with(viewBinding){
            Memo.text = data.memo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val position = dataList[position]
        holder.bind(position)
        // btnTrash 이 눌렸을 때 position 전달
        holder.viewBinding.btnTrash.setOnClickListener {
            onClickDeleteBtn.invoke(position)
        }
    }

    override fun getItemCount(): Int = dataList.size

}