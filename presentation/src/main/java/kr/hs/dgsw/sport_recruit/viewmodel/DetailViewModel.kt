package kr.hs.dgsw.sport_recruit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.Apply
import kr.hs.dgsw.domain.model.DetailPost
import kr.hs.dgsw.domain.usecase.apply.GetApplyUseCase
import kr.hs.dgsw.domain.usecase.apply.GetPostMyApplyUseCase
import kr.hs.dgsw.domain.usecase.apply.PostApplyUseCase
import kr.hs.dgsw.domain.usecase.post.GetDetailPostUseCase
import kr.hs.dgsw.sport_recruit.base.BaseViewModel
import kr.hs.dgsw.sport_recruit.util.testLog
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getDetailPostUseCase: GetDetailPostUseCase,
    private val getPostMyApplyUseCase: GetPostMyApplyUseCase,
    private val getApplyUseCase: GetApplyUseCase,
    private val postApplyUseCase: PostApplyUseCase,
) : BaseViewModel() {
    private val _onSuccessGetDetail = MutableLiveData<DetailPost>()
    val onSuccessGetDetail: LiveData<DetailPost> get() = _onSuccessGetDetail

    private val _onSuccessGetApply = MutableLiveData<List<Apply>>()
    val onSuccessGetApply: LiveData<List<Apply>> get() = _onSuccessGetApply

    private val _onSuccessGetMyApply = MutableLiveData<Int>()
    val onSuccessGetMyApply: LiveData<Int> get() = _onSuccessGetMyApply

    fun getDetailPost(postIdx: Int) {
        addDisposable(getDetailPostUseCase.buildUseCaseObservable(GetDetailPostUseCase.Params(
            postIdx)), object : DisposableSingleObserver<DetailPost>() {
            override fun onSuccess(t: DetailPost) {
                _onSuccessGetDetail.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                testLog("$e.message")
            }

        })
    }

    fun getPostApply(postIdx: Int) {
        addDisposable(getApplyUseCase.buildUseCaseObservable(GetApplyUseCase.Params(postIdx)),
            object : DisposableSingleObserver<List<Apply>>() {
                override fun onSuccess(t: List<Apply>) {
                    _onSuccessGetApply.value = t
                }

                override fun onError(e: Throwable) {
                    onErrorEvent.value = e
                }

            })
    }

    fun getMyApply(postIdx: Int, userIdx: Int) {
        addDisposable(getPostMyApplyUseCase.buildUseCaseObservable(GetPostMyApplyUseCase.Params(
            postIdx,
            userIdx)), object : DisposableSingleObserver<Int>() {
            override fun onSuccess(t: Int) {
                _onSuccessGetMyApply.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }
        })
    }
}