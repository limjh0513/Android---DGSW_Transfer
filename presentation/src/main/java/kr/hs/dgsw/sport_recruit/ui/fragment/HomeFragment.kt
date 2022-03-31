package kr.hs.dgsw.sport_recruit.ui.fragment

import android.util.Log
import androidx.fragment.app.viewModels
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.base.BaseFragment
import kr.hs.dgsw.sport_recruit.databinding.FragmentHomeBinding
import kr.hs.dgsw.sport_recruit.viewmodel.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val mViewModel: HomeViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.fragment_home

    override fun observerViewModel() {

        with(mViewModel){

        }
    }

}