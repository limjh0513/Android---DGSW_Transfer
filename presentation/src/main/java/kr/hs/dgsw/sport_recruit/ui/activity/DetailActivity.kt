package kr.hs.dgsw.sport_recruit.ui.activity

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.base.BaseActivity
import kr.hs.dgsw.sport_recruit.databinding.ActivityDetailBinding
import kr.hs.dgsw.sport_recruit.util.toast
import kr.hs.dgsw.sport_recruit.viewmodel.DetailViewModel

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    override val mViewModel: DetailViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_detail
    var idx: Int = 0

    override fun observeViewModel() {
        idx = intent.getIntExtra("postIdx", 0)
        mViewModel.getDetailPost(idx)
        with(mViewModel) {
            onSuccessGetDetail.observe(this@DetailActivity, Observer {
                mBinding.post = it

            })

            onErrorEvent.observe(this@DetailActivity, Observer {
                this@DetailActivity.toast("오류가 발생했습니다. ${it.message}")
            })
        }
    }

}