package kr.hs.dgsw.sport_recruit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import kr.hs.dgsw.domain.model.Post
import kr.hs.dgsw.domain.usecase.post.GetAllPostUseCase
import kr.hs.dgsw.domain.usecase.post.GetCategoryPostUseCase
import kr.hs.dgsw.domain.usecase.post.GetStatePostUseCase
import kr.hs.dgsw.sport_recruit.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllPostUseCase: GetAllPostUseCase,
    private val getCategoryPostUseCase: GetCategoryPostUseCase,
    private val getStatePostUseCase: GetStatePostUseCase,
) : BaseViewModel() {

    private val _onSuccessGetPost = MutableLiveData<List<Post>>()
    val onSuccessGetPost: LiveData<List<Post>> get() = _onSuccessGetPost

    fun getAllPost() {
        addDisposable(getAllPostUseCase.buildUseCaseObservable(),
            object : DisposableSingleObserver<List<Post>>() {
                override fun onSuccess(t: List<Post>) {
                    _onSuccessGetPost.value = t
                }

                override fun onError(e: Throwable) {
                    onErrorEvent.value = e
                }

            })
    }

    fun getStatePost(state: Int) {
        addDisposable(getCategoryPostUseCase.buildUseCaseObservable(GetCategoryPostUseCase.Params(
            state)), object : DisposableSingleObserver<List<Post>>() {
            override fun onSuccess(t: List<Post>) {
                _onSuccessGetPost.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }

        })
    }

    fun getCategoryPost(category: Int) {
        addDisposable(getCategoryPostUseCase.buildUseCaseObservable(GetCategoryPostUseCase.Params(
            category)), object : DisposableSingleObserver<List<Post>>() {
            override fun onSuccess(t: List<Post>) {
                _onSuccessGetPost.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }

        })
    }
}