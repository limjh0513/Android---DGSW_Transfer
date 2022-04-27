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

    private val _onSuccessGetAllPost = MutableLiveData<List<Post>>()
    val onSuccessGetAllPost: LiveData<List<Post>> get() = _onSuccessGetAllPost

    private val _onSuccessGetStatePost = MutableLiveData<List<Post>>()
    val onSuccessGetStatePost: LiveData<List<Post>> get() = _onSuccessGetStatePost

    private val _onSuccessGetCategoryPost = MutableLiveData<List<Post>>()
    val onSuccessGetCategoryPost: LiveData<List<Post>> get() = _onSuccessGetCategoryPost

    fun getAllPost() {
        addDisposable(getAllPostUseCase.buildUseCaseObservable(),
            object : DisposableSingleObserver<List<Post>>() {
                override fun onSuccess(t: List<Post>) {
                    _onSuccessGetAllPost.value = t
                }

                override fun onError(e: Throwable) {
                    onErrorEvent.value = e
                }

            })
    }

    fun getStatePost(state: Int) {
        addDisposable(getStatePostUseCase.buildUseCaseObservable(GetStatePostUseCase.Params(state)),
            object : DisposableSingleObserver<List<Post>>() {
                override fun onSuccess(t: List<Post>) {
                    _onSuccessGetStatePost.value = t
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
                _onSuccessGetCategoryPost.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
            }

        })
    }
}