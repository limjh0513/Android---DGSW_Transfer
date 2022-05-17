package kr.hs.dgsw.sport_recruit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.Apply
import kr.hs.dgsw.domain.model.DetailPost
import kr.hs.dgsw.domain.model.MyApply
import kr.hs.dgsw.domain.model.User
import kr.hs.dgsw.domain.request.ApplyRequest
import kr.hs.dgsw.domain.usecase.apply.GetApplyUseCase
import kr.hs.dgsw.domain.usecase.apply.GetPostMyApplyUseCase
import kr.hs.dgsw.domain.usecase.apply.PostApplyUseCase
import kr.hs.dgsw.domain.usecase.apply.PutApplyUseCase
import kr.hs.dgsw.domain.usecase.post.GetDetailPostUseCase
import kr.hs.dgsw.domain.usecase.user.InquireUserUseCase
import kr.hs.dgsw.sport_recruit.base.BaseViewModel
import kr.hs.dgsw.sport_recruit.util.testLog
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getDetailPostUseCase: GetDetailPostUseCase,
    private val getPostMyApplyUseCase: GetPostMyApplyUseCase,
    private val getApplyUseCase: GetApplyUseCase,
    private val postApplyUseCase: PostApplyUseCase,
    private val getUserUseCase: InquireUserUseCase,
    private val putApplyUseCase: PutApplyUseCase,
) : BaseViewModel() {
    private val _onSuccessGetDetail = MutableLiveData<DetailPost>()
    val onSuccessGetDetail: LiveData<DetailPost> get() = _onSuccessGetDetail

    private val _onSuccessGetApply = MutableLiveData<List<Apply>>()
    val onSuccessGetApply: LiveData<List<Apply>> get() = _onSuccessGetApply

    private val _onSuccessGetMyApply = MutableLiveData<MyApply>()
    val onSuccessGetMyApply: LiveData<MyApply> get() = _onSuccessGetMyApply

    private val _onSuccessGetUser = MutableLiveData<User>()
    val onSuccessGetUser: LiveData<User> get() = _onSuccessGetUser

    private val _onSuccessPostApply = MutableLiveData<Boolean>()
    val onSuccessPostApply: LiveData<Boolean> get() = _onSuccessPostApply

    private val _onSuccessPutApply = MutableLiveData<Int>()
    val onSuccessPutApply: LiveData<Int> get() = _onSuccessPutApply

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
            userIdx)), object : DisposableSingleObserver<MyApply>() {
            override fun onSuccess(t: MyApply) {
                _onSuccessGetMyApply.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }
        })
    }

    fun getUser(userIdx: Int) {
        addDisposable(getUserUseCase.buildUseCaseObservable(InquireUserUseCase.Params(userIdx)),
            object : DisposableSingleObserver<User>() {
                override fun onSuccess(t: User) {
                    _onSuccessGetUser.value = t
                }

                override fun onError(e: Throwable) {
                    onErrorEvent.value = e
                }

            })
    }

    fun postApply(postIdx: Int, userIdx: Int, user: User) {
        addDisposable(postApplyUseCase.buildUseCaseObservable(PostApplyUseCase.Params(ApplyRequest(
            user.grade,
            user.room,
            user.number,
            user.name,
            postIdx,
            userIdx))), object : DisposableSingleObserver<Boolean>() {
            override fun onSuccess(t: Boolean) {
                _onSuccessPostApply.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }
        })
    }

    fun putApply(applyIdx: Int, state: Int) {
        addDisposable(putApplyUseCase.buildUseCaseObservable(PutApplyUseCase.Params(applyIdx,
            state)), object: DisposableSingleObserver<Int>(){
            override fun onSuccess(t: Int) {
                _onSuccessPutApply.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }

        })
    }
}