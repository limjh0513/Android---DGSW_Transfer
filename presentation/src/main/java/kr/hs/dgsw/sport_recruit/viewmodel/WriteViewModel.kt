package kr.hs.dgsw.sport_recruit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.request.WriteRequest
import kr.hs.dgsw.domain.usecase.post.WritePostUseCase
import kr.hs.dgsw.sport_recruit.base.BaseViewModel
import java.sql.Timestamp
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(private val writePostUseCase: WritePostUseCase) :
    BaseViewModel() {
    val title = MutableLiveData<String>()
    val content = MutableLiveData<String>()
    val category = MutableLiveData<String>()
    val place = MutableLiveData<String>()
    val personnel = MutableLiveData<String>()
    val time = MutableLiveData<String>()
    val anonymous = MutableLiveData<Boolean>(false)
    val hidden = MutableLiveData<Boolean>(false)

    private val _onSuccessWritePost = MutableLiveData<Boolean>()
    val onSuccessWritePost: LiveData<Boolean> get() = _onSuccessWritePost


    fun writePost(category: Int) {
        val isAnonymous = if (anonymous.value!!) 1 else 0
        val isHidden = if (hidden.value!!) 1 else 0

        val t = Timestamp.valueOf(time.value.toString())

        addDisposable(writePostUseCase.buildUseCaseObservable(WritePostUseCase.Params(
            WriteRequest(
                title.value.toString(),
                content.value.toString(),
                personnel.value!!.toInt(),
                place.value.toString(),
                0,
                t,
                category, 0, isAnonymous, isHidden)
        )), object : DisposableSingleObserver<Boolean>() {
            override fun onSuccess(t: Boolean) {
                _onSuccessWritePost.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                e.printStackTrace()
            }

        })
    }
}