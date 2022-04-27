package kr.hs.dgsw.sport_recruit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.User
import kr.hs.dgsw.domain.usecase.user.InquireUserUseCase
import kr.hs.dgsw.sport_recruit.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val getUserUseCase: InquireUserUseCase) :
    BaseViewModel() {
    private val _onSuccessGetUser = MutableLiveData<User>()
    val onSuccessGetUser: LiveData<User> get() = _onSuccessGetUser

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
}