package kr.hs.dgsw.sport_recruit.ui.activity

import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.data.util.PreferenceManager
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.adapter.ApplyListAdapter
import kr.hs.dgsw.sport_recruit.base.BaseActivity
import kr.hs.dgsw.sport_recruit.databinding.ActivityDetailBinding
import kr.hs.dgsw.sport_recruit.util.toast
import kr.hs.dgsw.sport_recruit.viewmodel.DetailViewModel

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    override val mViewModel: DetailViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_detail
    private var idx: Int = -1
    private var userIdx: Int = -1
    private lateinit var adaptper: ApplyListAdapter
    private var applyState: Int? = null
    private var applyIdx: Int? = null
    private var hidden: Int? = 0

    override fun observeViewModel() {
        initDetailPost()
        initAdapter()
        with(mViewModel) {
            onSuccessGetDetail.observe(this@DetailActivity, Observer {
                mBinding.post = it
                hidden = it.hidden
                if (it.userIdx == userIdx) {
                    applyState = 2
                }

                mBinding.detailRecyclerView.isVisible = hidden != 1
                mBinding.detailApplyBtn.isVisible = it.state != 2

            })

            onSuccessGetApply.observe(this@DetailActivity, Observer {
                if (hidden != 1) {
                    adaptper.submitList(it)
                }
            })

            onSuccessGetMyApply.observe(this@DetailActivity, Observer {
                applyIdx = it.idx
                applyState = applyState ?: it.state
                mBinding.applyState = applyState!!
            })

            onSuccessGetUser.observe(this@DetailActivity, Observer {
                var apply: Int = -1
                when (applyState) {
                    -1 -> { //참가 신청
                        mViewModel.postApply(idx, userIdx, it)
                    }
                    0 -> { //참가 취소
                        mViewModel.putApply(applyIdx!!, 1)
                    }
                    1 -> { // 참가 신청
                        mViewModel.putApply(applyIdx!!, 0)
                    }
                    2 -> { //조기 마감
                        
                    }
                }
            })

            onSuccessPostApply.observe(this@DetailActivity, Observer {
                if (it) {
                    toast("스포츠 신청 성공!")
                } else {
                    toast("스포츠 신청 실패... 다시 시도해주세요")
                }
            })

            onSuccessPutApply.observe(this@DetailActivity, Observer {
                if(applyState != 2){
                    applyState = it
                }

                mBinding.applyState = it
                toast("신청 상태 수정 완료!")
            })

            onErrorEvent.observe(this@DetailActivity, Observer {
                this@DetailActivity.toast("오류가 발생했습니다. ${it.message}")
            })
        }
    }

    fun applyBtnClick() {
        if (userIdx > -1) {
            mViewModel.getUser(userIdx)
        }
    }

    fun initAdapter() {
        adaptper = ApplyListAdapter()
        mBinding.detailRecyclerView.adapter = adaptper

        if (idx > -1) {
            mViewModel.getPostApply(idx)
        } else {
            toast("게시글을 가져오지 못했습니다.")
        }
    }

    private fun initDetailPost() {
        idx = intent.getIntExtra("postIdx", -1)
        userIdx = PreferenceManager.getUser(this)

        if (idx > -1 && userIdx != -1) {
            mViewModel.getDetailPost(idx)
            mViewModel.getMyApply(idx, userIdx)
        } else {
            toast("게시글 idx 혹은 유저 정보를 전달받지 못했습니다.")
        }
    }
}