package kr.hs.dgsw.sport_recruit.ui.fragment

import android.util.Log
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.base.BaseFragment
import kr.hs.dgsw.sport_recruit.databinding.FragmentWriteBinding
import kr.hs.dgsw.sport_recruit.viewmodel.WriteViewModel

@AndroidEntryPoint
class WriteFragment : BaseFragment<FragmentWriteBinding, WriteViewModel>() {
    override val mViewModel: WriteViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.fragment_write

    override fun observerViewModel() {
    }
}