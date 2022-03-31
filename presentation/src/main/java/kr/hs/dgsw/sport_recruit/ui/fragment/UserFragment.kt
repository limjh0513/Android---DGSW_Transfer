package kr.hs.dgsw.sport_recruit.ui.fragment

import android.util.Log
import androidx.fragment.app.viewModels
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.base.BaseFragment
import kr.hs.dgsw.sport_recruit.databinding.FragmentUserBinding
import kr.hs.dgsw.sport_recruit.viewmodel.UserViewModel


class UserFragment : BaseFragment<FragmentUserBinding, UserViewModel>() {
    override val mViewModel: UserViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.fragment_user

    override fun observerViewModel() {

    }
}