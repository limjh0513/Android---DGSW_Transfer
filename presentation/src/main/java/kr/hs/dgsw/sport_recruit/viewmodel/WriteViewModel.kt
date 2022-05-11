package kr.hs.dgsw.sport_recruit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import kr.hs.dgsw.data.util.PreferenceManager
import kr.hs.dgsw.domain.request.WriteRequest
import kr.hs.dgsw.domain.usecase.post.WritePostUseCase
import kr.hs.dgsw.sport_recruit.base.BaseViewModel
import okhttp3.internal.format
import java.sql.Timestamp
import java.text.SimpleDateFormat
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


    fun writePost(category: Int, userId: Int) {
        val isAnonymous = if (anonymous.value!!) 1 else 0
        val isHidden = if (hidden.value!!) 1 else 0

        addDisposable(writePostUseCase.buildUseCaseObservable(WritePostUseCase.Params(
            WriteRequest(
                title.value.toString(),
                content.value.toString(),
                personnel.value!!.toInt(),
                place.value.toString(),
                userId,
                time.value.toString(),
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