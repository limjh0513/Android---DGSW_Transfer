package kr.hs.dgsw.domain.usecase.post

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.BaseUseCase
import kr.hs.dgsw.domain.model.Post
import kr.hs.dgsw.domain.repository.PostRepository
import javax.inject.Inject

class GetAllPostUseCase @Inject constructor(private val repository: PostRepository): BaseUseCase<Single<List<Post>>>() {
    override fun buildUseCaseObservable(): Single<List<Post>> =
        repository.getAllPost()
}