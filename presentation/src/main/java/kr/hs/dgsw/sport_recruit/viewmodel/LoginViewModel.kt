package kr.hs.dgsw.sport_recruit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.request.LoginRequest
import kr.hs.dgsw.domain.usecase.auth.LoginUseCase
import kr.hs.dgsw.sport_recruit.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : BaseViewModel() {
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    private val _onSuccessLogin = MutableLiveData<Int>()
    val onSuccessLogin: LiveData<Int> get() = _onSuccessLogin

    fun login() {
        addDisposable(loginUseCase.buildUseCaseObservable(LoginUseCase.Params(LoginRequest(id.value.toString(),
            pw.value.toString()))), object : DisposableSingleObserver<Int>() {
            override fun onSuccess(t: Int) {
                _onSuccessLogin.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                e.printStackTrace()
            }

        })
    }
}