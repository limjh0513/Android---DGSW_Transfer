package kr.hs.dgsw.sport_recruit.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.domain.model.Post
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.adapter.diffutil.PostDiffUtil
import kr.hs.dgsw.sport_recruit.databinding.PostItemBinding
import kr.hs.dgsw.sport_recruit.ui.activity.DetailActivity
import kr.hs.dgsw.sport_recruit.util.startActivityIntent

class PostListAdapter(var context: Context): ListAdapter<Post, PostListAdapter.ViewHolder>(PostDiffUtil.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mBinding = DataBindingUtil.inflate<PostItemBinding>(LayoutInflater.from(parent.context), R.layout.post_item, parent, false)

        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val mBinding: PostItemBinding) : RecyclerView.ViewHolder(mBinding.root) {
        fun bind(item: Post) {
            mBinding.item = item
            mBinding.time = item.time.toString().substring(0, 16)
            mBinding.itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("postIdx", item.idx)
                context.startActivityIntent(intent)
            }
        }
    }
}