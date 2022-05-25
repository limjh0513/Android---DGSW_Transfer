package kr.hs.dgsw.sport_recruit.ui.fragment

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.data.util.PreferenceManager
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.base.BaseFragment
import kr.hs.dgsw.sport_recruit.databinding.FragmentWriteBinding
import kr.hs.dgsw.sport_recruit.ui.activity.MainActivity
import kr.hs.dgsw.sport_recruit.util.categoryToInt
import kr.hs.dgsw.sport_recruit.util.isNotNullOrEmpty
import kr.hs.dgsw.sport_recruit.util.testLog
import kr.hs.dgsw.sport_recruit.util.toast
import kr.hs.dgsw.sport_recruit.viewmodel.WriteViewModel
import java.util.regex.Pattern

@AndroidEntryPoint
class WriteFragment : BaseFragment<FragmentWriteBinding, WriteViewModel>() {
    override val mViewModel: WriteViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.fragment_write

    override fun observerViewModel() {
        with(mViewModel) {
            onSuccessWritePost.observe(this@WriteFragment, Observer {
                toast(requireContext(), "게시글 작성 성공!")
                val a = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navbar)
                a.selectedItemId = R.id.page_home
                (requireActivity() as? MainActivity)?.changeBottomNavigationPosition(1)
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

            testLog("${title.value} ${category.value} ${place.value} ${personnel.value} ${time.value} ${
                dateTimeCheck(time.value)
            }")

            if (userId != -1) {
                if (isNotNullOrEmpty(title.value) && isNotNullOrEmpty(category.value) && isNotNullOrEmpty(
                        place.value) && isNotNullOrEmpty(personnel.value) && dateTimeCheck(time.value)
                ) {
                    writePost(categoryToInt(category.value.toString()), userId)
                } else {
                    toast(requireContext(), "입력 양식에 맞게 모두 입력해주세요!")
                }
            } else {
                toast(requireContext(), "회원을 조회하지 못했습니다. 다시 로그인해주세요.")
            }
        }
    }

    private fun dateTimeCheck(time: String?): Boolean {
        Log.e("asdf", "${time}")
        if (time != null) {
            val pattern =
                "\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]) (0[1-9]|1[0-9]|2[0-4]):(0[0-9]|[1-5][0-9])"


            Log.e("asdf", "${Pattern.matches(pattern, time)}")
            return Pattern.matches(pattern, time)
        }

        return false
    }
}