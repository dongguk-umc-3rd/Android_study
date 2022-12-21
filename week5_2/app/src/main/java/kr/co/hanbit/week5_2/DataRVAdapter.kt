package kr.co.hanbit.week5_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.hanbit.week5_2.databinding.ItemDataBinding

class DataRVAdapter(
    private val dataList: ArrayList<Data>,
    val onClickDeleteBtn: (data: Data) -> Unit):
    RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {

    inner class DataViewHolder(val binding: ItemDataBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.tvMemo.text = data.memo;
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val listposition = dataList[position]
        holder.bind(listposition)

        holder.binding.deleteBtn.setOnClickListener {
            onClickDeleteBtn.invoke(listposition)
        }
    }

    override fun getItemCount(): Int = dataList.size
}