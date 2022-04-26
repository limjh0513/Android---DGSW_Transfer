package kr.hs.dgsw.sport_recruit.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.domain.model.Post

object PostDiffUtil {
    val diffUtil = object : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean =
            oldItem.idx == newItem.idx

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean =
            oldItem == newItem

    }
}