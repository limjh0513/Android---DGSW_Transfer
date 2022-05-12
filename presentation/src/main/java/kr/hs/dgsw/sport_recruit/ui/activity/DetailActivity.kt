package kr.hs.dgsw.sport_recruit.ui.activity

import androidx.activity.viewModels
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
    private var idx: Int = 0
    private var userIdx: Int = 0
    private lateinit var adaptper: ApplyListAdapter
    private var applyState: Int ?= null

    override fun observeViewModel() {
        initDetailPost()
        initAdapter()
        with(mViewModel) {
            onSuccessGetDetail.observe(this@DetailActivity, Observer {
                mBinding.post = it
                if(it.userIdx == userIdx){
                    applyState = 3
                }

            })

            onSuccessGetApply.observe(this@DetailActivity, Observer {
                adaptper.submitList(it)
            })

            onSuccessGetMyApply.observe(this@DetailActivity, Observer {
                applyState = it
                when(applyState){

                }
            })

            onErrorEvent.observe(this@DetailActivity, Observer {
                this@DetailActivity.toast("오류가 발생했습니다. ${it.message}")
            })
        }
    }

    private fun initAdapter() {
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

        if (idx > -1) {
            mViewModel.getDetailPost(idx)
        } else {
            toast("게시글 idx를 전달받지 못했습니다.")
        }
    }
}