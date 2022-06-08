package kr.hs.dgsw.sport_recruit.ui.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.data.util.PreferenceManager
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.adapter.MyApplyListAdapter
import kr.hs.dgsw.sport_recruit.adapter.PostListAdapter
import kr.hs.dgsw.sport_recruit.base.BaseFragment
import kr.hs.dgsw.sport_recruit.databinding.FragmentUserBinding
import kr.hs.dgsw.sport_recruit.util.toast
import kr.hs.dgsw.sport_recruit.viewmodel.UserViewModel

@AndroidEntryPoint
class UserFragment : BaseFragment<FragmentUserBinding, UserViewModel>() {
    override val mViewModel: UserViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.fragment_user

    lateinit var postAdapter: PostListAdapter
    lateinit var myApplyAdapter: MyApplyListAdapter
    var userIdx = -1

    override fun observerViewModel() {
        setAdapter()
        initUser()

        with(mViewModel) {
            onSuccessGetUser.observe(this@UserFragment, Observer {
                mBinding.user = it
            })

            onSuccessGetMyPost.observe(this@UserFragment, Observer {
                postAdapter.submitList(it)
            })

            onSuccessGetMyApply.observe(this@UserFragment, Observer {
                myApplyAdapter.submitList(it)
            })

            onErrorEvent.observe(this@UserFragment, Observer {
                toast(requireContext(), "오류가 발생했습니다. ${it.message}")
            })
        }

    }

    private fun setAdapter() {
        myApplyAdapter = MyApplyListAdapter(requireContext())
        postAdapter = PostListAdapter(requireActivity())

        mBinding.userRecyclerWrite.adapter = postAdapter
        mBinding.userRecyclerApply.adapter = myApplyAdapter
    }

    private fun initUser() {
        userIdx = PreferenceManager.getUser(requireContext())

        if (userIdx > -1) {
            mViewModel.getUserData(userIdx)
            mViewModel.getMyPost(userIdx)
            mViewModel.getMyApply(userIdx)

        } else {
            toast(requireContext(), "회원을 조회하지 못했습니다. 다시 로그인해주세요")
        }
    }

    override fun onResume() {
        super.onResume()

        if (userIdx > -1) {
            mViewModel.getUserData(userIdx)
            mViewModel.getMyPost(userIdx)
            mViewModel.getMyApply(userIdx)
        }
    }
}