package kr.hs.dgsw.domain.usecase.post

import io.reactivex.rxjava3.core.Single
import kr.hs.dgsw.domain.base.ParamsUseCase
import kr.hs.dgsw.domain.model.Post
import kr.hs.dgsw.domain.repository.PostRepository
import javax.inject.Inject

class GetStatePostUseCase @Inject constructor(private val repository: PostRepository) :
    ParamsUseCase<GetStatePostUseCase.Params, Single<List<Post>>>() {

    override fun buildUseCaseObservable(params: Params): Single<List<Post>> =
        repository.getStatePost(params.state)

    data class Params(
        val state: Int,
    )
}