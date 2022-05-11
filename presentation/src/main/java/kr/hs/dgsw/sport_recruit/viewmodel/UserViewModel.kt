package kr.hs.dgsw.sport_recruit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.Apply
import kr.hs.dgsw.domain.model.Post
import kr.hs.dgsw.domain.model.User
import kr.hs.dgsw.domain.usecase.apply.GetMyApplyUseCase
import kr.hs.dgsw.domain.usecase.post.GetMyPostUseCase
import kr.hs.dgsw.domain.usecase.user.InquireUserUseCase
import kr.hs.dgsw.sport_recruit.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: InquireUserUseCase,
    private val getMyPostUseCase: GetMyPostUseCase,
    private val getMyApplyUseCase: GetMyApplyUseCase,
) :
    BaseViewModel() {
    private val _onSuccessGetUser = MutableLiveData<User>()
    val onSuccessGetUser: LiveData<User> get() = _onSuccessGetUser

    private val _onSuccessGetMyPost = MutableLiveData<List<Post>>()
    val onSuccessGetMyPost: LiveData<List<Post>> get() = _onSuccessGetMyPost

    private val _onSuccessGetMyApply = MutableLiveData<List<Apply>>()
    val onSuccessGetMyApply: LiveData<List<Apply>> get() = _onSuccessGetMyApply

    fun getUserData(userIdx: Int) {
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

    fun getMyPost(userIdx: Int){
        addDisposable(getMyPostUseCase.buildUseCaseObservable(GetMyPostUseCase.Params(userIdx)), object: DisposableSingleObserver<List<Post>>(){
            override fun onSuccess(t: List<Post>) {
                _onSuccessGetMyPost.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }

        })
    }

    fun getMyApply(userIdx: Int){
        addDisposable(getMyApplyUseCase.buildUseCaseObservable((GetMyApplyUseCase.Params(userIdx))), object: DisposableSingleObserver<List<Apply>>(){
            override fun onSuccess(t: List<Apply>) {
                _onSuccessGetMyApply.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }

        })
    }
}