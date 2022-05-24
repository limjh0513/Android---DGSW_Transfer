package kr.hs.dgsw.sport_recruit.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.domain.model.MyAllApply
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.adapter.diffutil.MyApplyDiffUtil
import kr.hs.dgsw.sport_recruit.databinding.MyapplyItemBinding
import kr.hs.dgsw.sport_recruit.ui.activity.DetailActivity
import kr.hs.dgsw.sport_recruit.util.startActivityIntent

class MyApplyListAdapter(var context: Context) :
    ListAdapter<MyAllApply, MyApplyListAdapter.ViewHolder>(MyApplyDiffUtil.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            DataBindingUtil.inflate<MyapplyItemBinding>(LayoutInflater.from(parent.context),
                R.layout.myapply_item,
                parent,
                false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(val mBinding: MyapplyItemBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(item: MyAllApply) {
            mBinding.item = item

            mBinding.myaView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("postIdx", item.postIdx)
                context.startActivityIntent(intent)
            }
        }
    }
}