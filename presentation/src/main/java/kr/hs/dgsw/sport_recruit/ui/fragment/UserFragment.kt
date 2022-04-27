package kr.hs.dgsw.sport_recruit.ui.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.data.util.PreferenceManager
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.base.BaseFragment
import kr.hs.dgsw.sport_recruit.databinding.FragmentUserBinding
import kr.hs.dgsw.sport_recruit.util.toast
import kr.hs.dgsw.sport_recruit.viewmodel.UserViewModel

@AndroidEntryPoint
class UserFragment : BaseFragment<FragmentUserBinding, UserViewModel>() {
    override val mViewModel: UserViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.fragment_user

    override fun observerViewModel() {
        initUser()

        with(mViewModel){
            onSuccessGetUser.observe(this@UserFragment, Observer {
                mBinding.user = it
            })

            onErrorEvent.observe(this@UserFragment, Observer {
                toast(requireContext(), "유저 정보를 조회하는데 실패했습니다. ${it.message}")
            })
        }

    }

    private fun initUser() {
        val userIdx = PreferenceManager.getUser(requireContext())

        if (userIdx > -1) {
            mViewModel.getUserData(userIdx)
        } else {
            toast(requireContext(), "회원을 조회하지 못했습니다. 다시 로그인해주세요")
        }
    }
}