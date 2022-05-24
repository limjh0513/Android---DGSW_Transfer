package kr.hs.dgsw.sport_recruit.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.domain.model.Apply
import kr.hs.dgsw.domain.model.MyAllApply

object MyApplyDiffUtil {
    val diffUtil = object : DiffUtil.ItemCallback<MyAllApply>() {
        override fun areItemsTheSame(oldItem: MyAllApply, newItem: MyAllApply): Boolean =
            oldItem.idx == newItem.idx

        override fun areContentsTheSame(oldItem: MyAllApply, newItem: MyAllApply): Boolean =
            oldItem == newItem
    }
}