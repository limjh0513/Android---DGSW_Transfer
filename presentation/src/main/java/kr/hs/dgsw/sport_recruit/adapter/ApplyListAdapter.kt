package kr.hs.dgsw.sport_recruit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.domain.model.Apply
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.adapter.diffutil.ApplyDiffUtil
import kr.hs.dgsw.sport_recruit.databinding.ApplyItemBinding

class ApplyListAdapter: ListAdapter<Apply, ApplyListAdapter.ViewHolder>(ApplyDiffUtil.diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mBinding = DataBindingUtil.inflate<ApplyItemBinding>(LayoutInflater.from(parent.context), R.layout.apply_item, parent, false)

        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(val mBinding: ApplyItemBinding) : RecyclerView.ViewHolder(mBinding.root) {
        fun bind(apply: Apply){
            mBinding.apply = apply
        }

    }
}