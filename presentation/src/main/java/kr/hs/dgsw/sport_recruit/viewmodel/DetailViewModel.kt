package kr.hs.dgsw.sport_recruit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.DetailPost
import kr.hs.dgsw.domain.usecase.post.GetDetailPostUseCase
import kr.hs.dgsw.sport_recruit.base.BaseViewModel
import kr.hs.dgsw.sport_recruit.util.testLog
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getDetailPostUseCase: GetDetailPostUseCase): BaseViewModel() {
    private val _onSuccessGetDetail = MutableLiveData<DetailPost>()
    val onSuccessGetDetail: LiveData<DetailPost> get() = _onSuccessGetDetail

    fun getDetailPost(postIdx: Int){
        addDisposable(getDetailPostUseCase.buildUseCaseObservable(GetDetailPostUseCase.Params(postIdx)), object : DisposableSingleObserver<DetailPost>(){
            override fun onSuccess(t: DetailPost) {
                _onSuccessGetDetail.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                testLog("$e.message")
            }

        })

    }
}