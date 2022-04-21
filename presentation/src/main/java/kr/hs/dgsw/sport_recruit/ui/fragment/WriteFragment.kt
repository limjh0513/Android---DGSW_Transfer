package kr.hs.dgsw.sport_recruit.ui.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.base.BaseFragment
import kr.hs.dgsw.sport_recruit.databinding.FragmentWriteBinding
import kr.hs.dgsw.sport_recruit.util.categoryToInt
import kr.hs.dgsw.sport_recruit.util.isNotNullOrEmpty
import kr.hs.dgsw.sport_recruit.util.toast
import kr.hs.dgsw.sport_recruit.viewmodel.WriteViewModel

@AndroidEntryPoint
class WriteFragment : BaseFragment<FragmentWriteBinding, WriteViewModel>() {
    override val mViewModel: WriteViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.fragment_write

    override fun observerViewModel() {
        with(mViewModel) {
            onSuccessWritePost.observe(this@WriteFragment, Observer {
                toast(requireContext(), "게시글 작성 성공!")
            })
            onErrorEvent.observe(this@WriteFragment, Observer {
                toast(requireContext(), "게시글 작성 실패 - ${it.message}")
            })
        }
    }

    fun onClickWriteBtn() {
        with(mViewModel) {
            if (isNotNullOrEmpty(title.value) && isNotNullOrEmpty(category.value) && isNotNullOrEmpty(
                    place.value) && isNotNullOrEmpty(personnel.value) && isNotNullOrEmpty(time.value)
            ) {
                writePost(categoryToInt(category.value.toString()))
            }
        }
    }
}