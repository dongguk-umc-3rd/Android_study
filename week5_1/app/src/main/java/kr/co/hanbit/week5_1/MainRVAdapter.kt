package kr.co.hanbit.week5_1

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.hanbit.week5_1.databinding.ItemDataBinding

class MainRVAdapter (private val dataList:ArrayList<MainData>): RecyclerView.Adapter<MainRVAdapter.DataViewHolder>(){

    private val swithchStatus=SparseBooleanArray()

    inner class DataViewHolder(private val viewBinding: ItemDataBinding):RecyclerView.ViewHolder(viewBinding.root){
        fun bind(data:MainData)=with(viewBinding){
            tvTitle.text = data.title
            tvNum.text=data.num

            mainSwitch.isChecked=swithchStatus[adapterPosition]

            mainSwitch.setOnClickListener(null)

            mainSwitch.setOnClickListener {
                if(!mainSwitch.isChecked)
                    swithchStatus.put(adapterPosition,false)
                else
                    swithchStatus.put(adapterPosition,true)
                notifyItemChanged(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int=dataList.size
}