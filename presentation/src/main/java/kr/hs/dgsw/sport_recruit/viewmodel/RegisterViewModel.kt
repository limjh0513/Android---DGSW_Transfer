package kr.hs.dgsw.sport_recruit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.request.RegisterRequest
import kr.hs.dgsw.domain.usecase.auth.RegisterUseCase
import kr.hs.dgsw.sport_recruit.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerUseCase: RegisterUseCase) :
    BaseViewModel() {
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val profile = MutableLiveData<String>()
    val grade = MutableLiveData<String>()
    val room = MutableLiveData<String>()
    val number = MutableLiveData<String>()

    private val _onSuccessRegister = MutableLiveData<Int>()
    val onSuccessRegister: LiveData<Int> get() = _onSuccessRegister

    fun register() {
        addDisposable(registerUseCase.buildUseCaseObservable(RegisterUseCase.Params(RegisterRequest(
            id.value.toString(),
            pw.value.toString(),
            grade.value!!.toInt(),
            room.value!!.toInt(),
            number.value!!.toInt(),
            name.value.toString(),
            profile.value.toString()
        ))), object : DisposableSingleObserver<Int>() {
            override fun onSuccess(t: Int) {
                _onSuccessRegister.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                e.printStackTrace()
            }
        })
    }
}