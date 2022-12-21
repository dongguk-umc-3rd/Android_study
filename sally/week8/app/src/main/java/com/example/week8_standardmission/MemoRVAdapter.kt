package com.example.week8_standardmission

import android.view.LayoutInflater
import android.view.MenuItem.OnMenuItemClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MemoRVAdapter( private val memoList: ArrayList<Memo>, val onClickDeleteBtn: (data: Memo) -> Unit) :
    RecyclerView.Adapter<MemoRVAdapter.DataViewHolder>() {
    inner class DataViewHolder(val binding: ItemDataBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Memo){
            binding.tvMemo.text=data.memo;
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val position = memoList[position]
        holder.bind(position)
        holder.binding.deleteBtn.setOnClickListener{
            onClickDeleteBtn.invoke(position)
        }
    }

    override fun getItemCount(): Int = memoList.size
}