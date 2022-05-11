package kr.hs.dgsw.sport_recruit.ui.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.data.util.PreferenceManager
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
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, HomeFragment()).commit()
            })
            onErrorEvent.observe(this@WriteFragment, Observer {
                toast(requireContext(), "게시글 작성 실패 - ${it.message}")
            })
        }
    }

    fun onClickWriteBtn() {
        with(mViewModel) {
            val userId = PreferenceManager.getUser(requireContext())

            if (userId != null) {
                if (isNotNullOrEmpty(title.value) && isNotNullOrEmpty(category.value) && isNotNullOrEmpty(
                        place.value) && isNotNullOrEmpty(personnel.value) && isNotNullOrEmpty(time.value)
                ) {
                    try {
                        writePost(categoryToInt(category.value.toString()), userId)
                    } catch (e: Exception) {
                        toast(requireContext(), "입력 양식에 맞게 입력해주세요!")
                    }
                }
            } else {
                toast(requireContext(), "회원을 조회하지 못했습니다. 다시 로그인해주세요.")
            }
        }
    }
}