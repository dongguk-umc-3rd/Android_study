package com.example.week5_standardmission

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week5_standardmission.databinding.ItemDataBinding

class DataRVAdaptor (private val dataList: ArrayList<Data>): RecyclerView.Adapter<DataRVAdaptor.DataViewHolder>(){
    private val switchStatus = SparseBooleanArray()

    inner class DataViewHolder(private val viewBinding: ItemDataBinding): RecyclerView.ViewHolder(viewBinding.root){
        fun bind(data: Data) = with(viewBinding){
            tvTitle.text = data.title
            tvDesc.text = data.desc

            switch1.isChecked = switchStatus[adapterPosition]

            switch1.setOnClickListener(null)

            switch1.setOnClickListener{
                if(!switch1.isChecked)
                    switchStatus.put(adapterPosition,false)
                else
                    switchStatus.put(adapterPosition,true)
                notifyItemChanged(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}