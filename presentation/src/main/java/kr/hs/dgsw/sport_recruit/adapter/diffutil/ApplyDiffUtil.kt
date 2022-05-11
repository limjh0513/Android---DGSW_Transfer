package kr.hs.dgsw.sport_recruit.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.domain.model.Apply

object ApplyDiffUtil {
    val diffUtil = object : DiffUtil.ItemCallback<Apply>() {
        override fun areItemsTheSame(oldItem: Apply, newItem: Apply): Boolean =
            oldItem.idx == newItem.idx

        override fun areContentsTheSame(oldItem: Apply, newItem: Apply): Boolean =
            oldItem == newItem
    }
}